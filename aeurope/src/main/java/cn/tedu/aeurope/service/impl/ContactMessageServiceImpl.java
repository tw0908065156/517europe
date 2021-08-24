package cn.tedu.aeurope.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.ContactMessage;
import cn.tedu.aeurope.mapper.ContactMessageMapper;
import cn.tedu.aeurope.service.IContactMessageService;
import cn.tedu.aeurope.service.ex.InsertException;

@Service
public class ContactMessageServiceImpl implements IContactMessageService{
	
	@Autowired
	ContactMessageMapper contactMessageMapper;

	@Override		//存入"聯絡我們 Contact us"網頁收到的信息
	public void addContactMessage(ContactMessage contactMessage, Integer clientId) {
		
		contactMessage.setClientId(clientId);
		contactMessage.setClientEmail(contactMessage.getClientEmail());
		contactMessage.setClientNickname(contactMessage.getClientNickname());
		contactMessage.setMessageSubject(contactMessage.getMessageSubject());
		contactMessage.setMessageDetail(contactMessage.getMessageDetail());
		contactMessage.setMessageStatus(0);
		Date now =new Date();
		contactMessage.setCreatedTime(now);
		contactMessage.setCreatedUser(contactMessage.getClientNickname());
		insertContactMessage(contactMessage);
	}
	
	
	/**
	 * 存入"聯絡我們 Contact us"網頁收到的信息
	 * @param contactMessage
	 * @return
	 */
	private void insertContactMessage(ContactMessage contactMessage){
		Integer rows = contactMessageMapper.insertContactMessage(contactMessage);
		if(rows != 1){
			throw new InsertException("您的信息無法提交，請稍後再試或聯絡系統管理員！");
		}
	}

}
