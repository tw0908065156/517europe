package cn.tedu.aeurope.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.aeurope.entity.Client;
import cn.tedu.aeurope.mapper.ClientMapper;
import cn.tedu.aeurope.service.IClientService;
import cn.tedu.aeurope.service.ex.ClientEmailDuplicateException;
import cn.tedu.aeurope.service.ex.ClientNotfoundException;
import cn.tedu.aeurope.service.ex.EmailFormatIncorrectException;
import cn.tedu.aeurope.service.ex.InsertException;
import cn.tedu.aeurope.service.ex.PasswordNotMatchException;
import cn.tedu.aeurope.service.ex.UpdateException;

@Service
public class ClientServiceImpl implements IClientService {

	final String formatEmail = "\\p{Alpha}\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";

	@Autowired
	private ClientMapper clientMapper;
	
	@Autowired
	JavaMailSender mailSender;

	@Override		//注冊新用戶
	public void regist(Client client)
			throws ClientEmailDuplicateException, InsertException, EmailFormatIncorrectException {
		String clientEmail = client.getClientEmail();
		if (!clientEmail.matches(formatEmail)) {
			throw new EmailFormatIncorrectException("您填寫的電子郵箱格式錯誤，請更正。謝謝！");
		}
		Client result = findByClientEmail(clientEmail);
		if (result != null) {
			throw new ClientEmailDuplicateException("您的Email：" + clientEmail + "已註冊為我們的VIP客戶，請直接登入或使用其他EMAIL帳號注冊！");
		}

		String salt = UUID.randomUUID().toString().toUpperCase();
		String md5Password = getMd5Password(client.getClientPassword(), salt);
		client.setClientPassword(md5Password);
		client.setPsSalt(salt);

		client.setClientNickname(client.getClientNickname());
		client.setClientPhone(client.getClientPhone());
		client.setClientGender(client.getClientGender());

		client.setIsDelete(0);
		Date now = new Date();
		client.setCreatedUser(clientEmail);
		client.setCreatedTime(now);
		client.setModifiedUser(clientEmail);
		client.setModifiedTime(now);

		Integer rows = clientMapper.insert(client);
		if (rows != 1) {
			throw new InsertException("Sorry! 系統寫入時出現未知錯誤，您的註冊未完成，請聯絡客服或稍後再試。 ");
		}
	}

	@Override		//用戶登入
	public Client login(String clientEmail, String password) throws ClientNotfoundException, PasswordNotMatchException {
		Client result = findByClientEmail(clientEmail);
		if (result == null) {
			throw new ClientNotfoundException("登入失敗！您的email帳號不存在，請重新輸入或前往註冊！");
		}
		if (result.getIsDelete() == 1) {
			throw new ClientNotfoundException("登入失敗！您的email帳號已凍結，請聯絡系統管理員！");
		}
		String md5Password = getMd5Password(password, result.getPsSalt());
		if (!result.getClientPassword().equals(md5Password)) {
			throw new PasswordNotMatchException("登入失敗！密碼錯誤，請重新輸入！");
		}
		result.setClientPassword(null);
		result.setPsSalt(null);
		result.setIsDelete(null);
		return result;
	}

	
	@Override		//修改用戶資料（含修改密碼）
	public void updateClient(Client client) throws ClientNotfoundException, ClientEmailDuplicateException,
			EmailFormatIncorrectException, UpdateException {
		Client result = clientMapper.findByClientId(client.getClientId());
		if (result == null) {
			throw new ClientNotfoundException("修改資料失敗！您的帳號不存在，請重新輸入！");
		}
		if (result.getIsDelete() == 1) {
			throw new ClientNotfoundException("修改資料失敗！您的email帳號已凍結，請聯絡系統管理員！");
		}

		String clientEmail = client.getClientEmail();
		if (!clientEmail.matches(formatEmail)) {
			throw new EmailFormatIncorrectException("您填寫的電子郵箱格式錯誤，請更正。謝謝！");
		}
		Client resultEmail = findByClientEmail(client.getClientEmail());
		if (resultEmail != null && resultEmail.getClientId() != result.getClientId()) {
			throw new ClientEmailDuplicateException("您要更新的Email帳號：" + client.getClientEmail() + "已註冊！");
		}

		String newps = client.getClientPassword();
		if ((newps == null) || (newps.equals(""))) {			
			client.setClientPassword(result.getClientPassword());
		}else{
			String md5Password = getMd5Password(newps, result.getPsSalt());
			client.setClientPassword(md5Password);
		}
		client.setPsSalt(result.getPsSalt());

		Date now = new Date();
		client.setModifiedUser(clientEmail);
		client.setModifiedTime(now);

		Integer rows = clientMapper.updateClient(client);
		if (rows != 1) {
			throw new UpdateException("Sorry! 更新用戶資料時出現未知錯誤，您的修改未完成，請聯絡客服或稍後再試。 ");
		}

	}

	@Override		//更改密碼
	public void updatePassword(String clientEmail, String newPassword) throws UpdateException {
		Client result = findByClientEmail(clientEmail);
		String PsSalt = result.getPsSalt();
		String newPasswordMd5= getMd5Password(newPassword, PsSalt);
		Integer row = clientMapper.updatePassword(clientEmail, newPasswordMd5);
		if(row !=1){
			throw new UpdateException("更改密碼時出現未知錯誤，請稍後重試或聯絡系統管理員。");
		}
	}

	@Override		//依據客戶Id查找客戶資料
	public Client getByClientId(Integer clientId) {
		Client result = clientMapper.findByClientId(clientId);
		return result;
	}

	
	@Override			//通過email查找客戶資料
	public Client findByClientEmail(String clientEmail){
		return clientMapper.findByClientEmail(clientEmail);
	}
	
	
	
	/**
	 * 密碼通過Md5摘要做加密
	 * @param password
	 * @param salt
	 * @return 加密後的密碼
	 */
	private String getMd5Password(String password, String salt) {
		String str = password + salt;
		str = DigestUtils.md5DigestAsHex(str.getBytes());
		return str;
	}



	



}
