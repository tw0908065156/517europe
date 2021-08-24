package cn.tedu.aeurope.mapper;

import cn.tedu.aeurope.entity.ContactMessage;

public interface ContactMessageMapper {
	
	/**
	 * 存入"聯絡我們 Contact us"網頁收到的信息
	 * @param contactMessage
	 * @return
	 */
	Integer insertContactMessage(ContactMessage contactMessage);
}
