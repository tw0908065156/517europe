package cn.tedu.aeurope.service;

import cn.tedu.aeurope.entity.Client;
import cn.tedu.aeurope.service.ex.ClientEmailDuplicateException;
import cn.tedu.aeurope.service.ex.ClientNotfoundException;
import cn.tedu.aeurope.service.ex.EmailFormatIncorrectException;
import cn.tedu.aeurope.service.ex.InsertException;
import cn.tedu.aeurope.service.ex.PasswordNotMatchException;
import cn.tedu.aeurope.service.ex.UpdateException;

public interface IClientService {
	public static final Integer SUCCESS = 100;

	/**
	 * 注冊新用戶
	 * @param client
	 * @throws ClientEmailDuplicateException
	 * @throws InsertException
	 * @throws EmailFormatIncorrectException
	 */
	void regist(Client client) throws ClientEmailDuplicateException, InsertException, EmailFormatIncorrectException;

	/**
	 * 用戶登入
	 * @param clientEmail
	 * @param password
	 * @return 寫入session資料
	 * @throws ClientNotfoundException
	 * @throws PasswordNotMatchException
	 */
	Client login(String clientEmail, String password) throws ClientNotfoundException, PasswordNotMatchException;

	/**
	 * 依據客戶Id查找客戶資料
	 * @param clientId
	 * @return
	 */
	Client getByClientId(Integer clientId);

	/**
	 * 修改用戶資料（含修改密碼）
	 * @param client
	 * @throws ClientNotfoundException
	 * @throws ClientEmailDuplicateException
	 * @throws EmailFormatIncorrectException
	 * @throws UpdateException
	 */
	void updateClient(Client client) throws ClientNotfoundException, ClientEmailDuplicateException,
			EmailFormatIncorrectException, UpdateException;
	
	/**
	 * 更改密碼
	 * @param clientEmail
	 * @param newPassword
	 * @return
	 */
	void updatePassword(String clientEmail,  String newPassword) throws UpdateException;
	
	
	/**
	 * 依據客戶email查找客戶資料
	 * @param clientEmail
	 * @return
	 */
	Client findByClientEmail(String clientEmail);
}
