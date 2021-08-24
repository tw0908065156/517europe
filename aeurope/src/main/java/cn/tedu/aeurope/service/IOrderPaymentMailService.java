package cn.tedu.aeurope.service;

import cn.tedu.aeurope.service.ex.EmailFormatIncorrectException;
import cn.tedu.aeurope.service.ex.MailExceedsLimit;

public interface IOrderPaymentMailService {

	
	/**
	 * email發送匯款信息,並將發送時間存入數據表
	 * @param orderid
	 * @param clientEmail
	 * @param otherMail
	 * @throws MailExceedsLimit
	 * @throws EmailFormatIncorrectException
	 */
	void sendMailForOrderPayment(Integer orderid, String clientEmail, String otherEmail)
			throws MailExceedsLimit, EmailFormatIncorrectException;
}
