package cn.tedu.aeurope.service;

import cn.tedu.aeurope.entity.ContactMessage;

public interface IContactMessageService {
	
	/**
	 * 存入"聯絡我們 Contact us"網頁收到的信息
	 * @param contactMessage
	 * @return
	 */
	void addContactMessage(ContactMessage contactMessage, Integer clientId);
	
}
