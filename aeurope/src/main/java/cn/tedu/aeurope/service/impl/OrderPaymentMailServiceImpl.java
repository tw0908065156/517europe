package cn.tedu.aeurope.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.OrderPaymentMail;
import cn.tedu.aeurope.mapper.OrderPaymentMailMapper;
import cn.tedu.aeurope.service.IOrderPaymentMailService;
import cn.tedu.aeurope.service.ex.EmailFormatIncorrectException;
import cn.tedu.aeurope.service.ex.InsertException;
import cn.tedu.aeurope.service.ex.MailExceedsLimit;

@Service
public class OrderPaymentMailServiceImpl implements IOrderPaymentMailService {
	
	final String formatEmail = "\\p{Alpha}\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";
	
	@Autowired
	OrderPaymentMailMapper orderPaymentMailMapper;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Override	//email發送匯款信息,並將發送時間存入數據表
	public void sendMailForOrderPayment(Integer orderid, String clientEmail, String otherEmail) 
			throws MailExceedsLimit, EmailFormatIncorrectException {
		
		//檢測email發送次數，完全相同的email發送3次，則拒發，拋出異常
		List<String> listOtherMail = selectMailbyOrderid(orderid);
		if(listOtherMail.size()>=3){
			Map mapOtherMail = new HashMap();
			for (String temp : listOtherMail) {
				Integer count = (Integer) mapOtherMail.get(temp);
				mapOtherMail.put(temp, (count == null) ? 1 : count + 1);
			}
			Iterator<String> iter = mapOtherMail.keySet().iterator();
			while (iter.hasNext()) {
				Integer count = (Integer) mapOtherMail.get(iter.next());
				if(count>=3){
					throw new MailExceedsLimit("系統已發送3封郵件到您提供的同一email地址。\n"
							+ "如果您均未收到，請提供其他email地址或直接聯絡您的業務員。");
				}
			}
		}
		
		OrderPaymentMail orderPaymentMail = new OrderPaymentMail();
		if(!otherEmail.matches(formatEmail)) {
			throw new EmailFormatIncorrectException("您填寫的電子郵箱格式錯誤，請更正。謝謝！");
		}
		orderPaymentMail.setOtherEmail(otherEmail);
		//給email地址發送匯款資訊
	    StringBuilder stringBuilder = new StringBuilder();
	    stringBuilder.append("<html><head><title></title></head><body>");
	    stringBuilder.append("親愛的VIP客戶，您好！<br/>");
	    stringBuilder.append("您在517Europe網站的訂單選擇銀行轉帳支付，以下是銀行帳號資訊。<br/>");
	    stringBuilder.append("帳戶名稱：<strong><font color='#0000D1'>歐洲旅遊私人訂製有限公司</font></strong><br/>");
	    stringBuilder.append("開戶銀行：<strong><font color='#0000D1'>第一銀行中崙分行(分行代號:0071428)</font></strong><br/>");
	    stringBuilder.append("銀行帳號：<strong><font color='#0000D1'>142-10-123456</font></strong><br/>");
	    stringBuilder.append("請備註訂單號：<strong><font color='#0000D1'>517").append(orderid).append("</font></strong><br/>");
	    stringBuilder.append("匯款完成請將水單拍照發給您的業務員。感謝您的配合！<br/>");
	    stringBuilder.append("<I>***如果您沒有進行上述操作，請忽略此郵件***</I>");
	    stringBuilder.append("</body></html>");
	    MimeMessage mimeMessage = mailSender.createMimeMessage();
	    MimeMessageHelper mimeMessageHelper;
	    try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		    mimeMessageHelper.setFrom("tw517europe@gmail.com");
		    mimeMessageHelper.setTo(clientEmail);
		    mimeMessageHelper.setTo(otherEmail);
			mimeMessage.setSubject("517Europe訂單匯款資訊");
			mimeMessageHelper.setText(stringBuilder.toString(),true);
	    } catch (MessagingException e) {
			e.printStackTrace();
	    }
		mailSender.send(mimeMessage);	
		
		orderPaymentMail.setClientEmail(clientEmail);
		orderPaymentMail.setOrderid(orderid);
		Date now = new Date();
		orderPaymentMail.setSendTime(now);
		insertOrderPaymentMail(orderPaymentMail);
		
	}
	
	
	/**
	 * email發送付款帳號後存入資料到數據表
	 * @param orderPaymentMail
	 * @return
	 */
	private void insertOrderPaymentMail(OrderPaymentMail orderPaymentMail) throws InsertException{
		Integer rows= orderPaymentMailMapper.insertOrderPaymentMail(orderPaymentMail);
		if(rows != 1){
			throw new InsertException("發送Email時發生未知錯誤，請稍後再試或聯絡系統管理員。");
		}
	}
	
	
	/**
	 * 根據orderid查詢已發送mail的OtherMailList
	 * @param orderid
	 * @return
	 */
	private List<String> selectMailbyOrderid(Integer orderid){
		return orderPaymentMailMapper.selectOtherMailList(orderid);
		
	}




}
