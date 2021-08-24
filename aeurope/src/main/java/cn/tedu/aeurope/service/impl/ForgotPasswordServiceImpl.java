package cn.tedu.aeurope.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.Client;
import cn.tedu.aeurope.entity.ForgotPassword;
import cn.tedu.aeurope.mapper.ForgotPasswordMapper;
import cn.tedu.aeurope.service.IClientService;
import cn.tedu.aeurope.service.IForgotPasswordService;
import cn.tedu.aeurope.service.ex.ClientNotfoundException;
import cn.tedu.aeurope.service.ex.EmptyDataException;
import cn.tedu.aeurope.service.ex.InsertException;
import cn.tedu.aeurope.service.ex.TimeExpiredException;
import cn.tedu.aeurope.service.ex.UpdateException;
import cn.tedu.aeurope.service.ex.VerifyCodeNotMatchException;

@Service
public class ForgotPasswordServiceImpl implements IForgotPasswordService {
	
	@Autowired
	ForgotPasswordMapper forgotPasswordMapper;
	
	@Autowired
	IClientService clientService;
	
	@Autowired
	JavaMailSender mailSender;
	

	@Override		//給email地址發送驗證碼
	public void sendVerifyCode(String clientEmail) throws ClientNotfoundException, EmptyDataException{
		
		//email地址不為空檢測
		if(clientEmail == null || clientEmail.length()<1){
			throw new EmptyDataException("請先輸入您的email帳號!");
		}
		
		//查找用戶是否存在
		Client result = clientService.findByClientEmail(clientEmail);
		if(result == null){
			throw new ClientNotfoundException("您輸入的email帳號"+clientEmail+"尚未註冊，請核對或直接註冊新用戶。");
		}
		
		//查找上次發送驗證碼時效是否已過
		ForgotPassword verifyResult = selectByClientEmail(clientEmail);
		Calendar calendar = Calendar.getInstance();
		long nowDate = calendar.getTime().getTime();
		if(verifyResult !=null){
		Integer remainingTime = (int) (verifyResult.getExpiredTime().getTime() - nowDate);
		if(remainingTime > 0){
			remainingTime = remainingTime / 1000;
			Integer remainingMin = remainingTime / 60;
			Integer remainingSec =remainingTime % 60;
			throw new TimeExpiredException("您已收到的驗證碼效期為10分鐘，目前尚余"
					+ remainingMin + "分" + remainingSec + "秒。\n"
					+ "請直接輸入您已收到的驗證碼 或 等待" + remainingMin + "分" + remainingSec + "秒後再選擇重新發送.");
		}		
		}
		//生成驗證碼及有效時限，存入t_forgot_password
		String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);//生成隨機6位數字驗證碼
	    Timestamp outDate = new Timestamp(System.currentTimeMillis() + 10 * 60 * 1000);// 設置有效期限為10分鐘
	    ForgotPassword validataCode = new ForgotPassword();
	    validataCode.setClientEmail(clientEmail);
	    validataCode.setValidataCode(verifyCode);
	    validataCode.setExpiredTime(outDate);
	    insertForgotPassword(validataCode);
		
		//給email地址發送驗證碼
	    StringBuilder stringBuilder = new StringBuilder();
	    stringBuilder.append("<html><head><title></title></head><body>");
	    stringBuilder.append("親愛的VIP客戶，您好！<br/>");
	    stringBuilder.append("我們收到您在517Europe網站重置密碼的申請。<br/>");
	    stringBuilder.append("您的驗證碼是：<strong><font color='red'>").append(verifyCode).append("</font></strong><br/>");
	    stringBuilder.append("您可以複製此驗證碼並返回517Europe網站，重置您的登入密碼。<br/>");
	    stringBuilder.append("此驗證碼<strong>只能使用一次，在10分鐘內有效</strong>。驗證成功則自動失效。<br/>");
	    stringBuilder.append("<I>***如果您沒有進行上述操作，請忽略此郵件***</I>");
	    stringBuilder.append("</body></html>");
	    MimeMessage mimeMessage = mailSender.createMimeMessage();
	    MimeMessageHelper mimeMessageHelper;
	    try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		    mimeMessageHelper.setFrom("tw517europe@gmail.com");
		    mimeMessageHelper.setTo(clientEmail);
			mimeMessage.setSubject("517Europe用戶郵箱驗證");
			mimeMessageHelper.setText(stringBuilder.toString(),true);
	    } catch (MessagingException e) {
			e.printStackTrace();
	    }
		mailSender.send(mimeMessage);
	}
	

	@Override		// 重置密碼
	public void updatePassword(String clientEmail, String verifyCode, String newPassword)
			throws TimeExpiredException, VerifyCodeNotMatchException, UpdateException, EmptyDataException{
		
		//檢查輸入數據是否為空，格式是否正確
		if(clientEmail == null || clientEmail.length()<1){
			throw new EmptyDataException("email帳號不能為空！請先輸入您的email帳號。");
		}
		if(verifyCode == null || verifyCode.length()<1){
			throw new EmptyDataException("驗證碼不能為空，請輸入您email收到的驗證碼。\n"
					+ "如尚未收到驗證碼，請再次檢查您的email地址，選擇重發驗證碼。");
		}
		Pattern isNumuber = Pattern.compile("[0-9]*");
		if(verifyCode.length() != 6 || !(isNumuber.matcher(verifyCode).matches())){
			throw new VerifyCodeNotMatchException("驗證碼輸入有誤，請核對您email收到的驗證碼。\n"
					+ "如尚未收到驗證碼，請再次檢查您的email地址，選擇重發驗證碼。");
		}
		if(newPassword == null || newPassword.length()<1){
			throw new EmptyDataException("密碼不能為空，請輸入您的新密碼。");
		}
		
		
		//核對驗證碼、效期
		ForgotPassword verifyResult = selectByClientEmail(clientEmail);
		if(verifyResult == null){
			throw new VerifyCodeNotMatchException("您的驗證碼有誤，請再次檢查您的email地址，選擇重發驗證碼。");
		}
		
		Date now = new Date();
		if(now.compareTo(verifyResult.getExpiredTime()) > 0){
			throw new TimeExpiredException("您的驗證碼效期已過，請選擇重新發送取得新的驗證碼.");
		}

		if(!(verifyCode.equals(verifyResult.getValidataCode()))){
			throw new VerifyCodeNotMatchException("驗證碼輸入有誤，請核對您email收到的驗證碼。\n"
					+ "如尚未收到驗證碼，請再次檢查您的email地址，選擇重發驗證碼。");
		}

		//更改密碼
		clientService.updatePassword(clientEmail, newPassword);
		
		//驗證碼設為過期
		Integer verifyId = verifyResult.getVerifyId();
		Date expiredTime =now;
		updateExpiredTime(verifyId, expiredTime);		
	}
	
	
	/**
	 * 插入email驗證碼資料
	 * @param forgortPassword
	 * @return
	 */
	private void insertForgotPassword(ForgotPassword forgortPassword) throws InsertException{
		Integer row = forgotPasswordMapper.insertForgotPassword(forgortPassword);
		if(row != 1){
			throw new InsertException("發送Email驗證碼時出現未知錯誤，請稍後再試或聯絡系統管理員。");
		}
	}
	
	
	/**
	 * 更改驗證碼效期為失效
	 * @param verifyId
	 * @param expiredTime
	 * @return
	 */
	private void updateExpiredTime(Integer verifyId, Date expiredTime){
		Integer rows = forgotPasswordMapper.updateExpiredTime(verifyId, expiredTime);
		if(rows != 1){
			throw new UpdateException("更改密碼時出現未知錯誤，請稍後重試或聯絡系統管理員。");
		}
	}
	
	
	/**
	 * 查詢忘記密碼表email對應的最新一條數據
	 * @param clientEmail
	 * @return
	 */
	private ForgotPassword selectByClientEmail(String clientEmail){
		return forgotPasswordMapper.selectByClientEmail(clientEmail);
	}



}
