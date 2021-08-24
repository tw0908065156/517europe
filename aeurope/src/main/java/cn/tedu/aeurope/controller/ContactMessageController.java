package cn.tedu.aeurope.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.ContactMessage;
import cn.tedu.aeurope.service.IContactMessageService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("contact_message")
public class ContactMessageController extends BaseController {
	
	@Autowired
	IContactMessageService contactMessageService;
	
	@RequestMapping("/")
	public JsonResult<Void>  addContactMessage(ContactMessage contactMessage, HttpSession session){
		Integer clientId;
		if(session.getAttribute("clientid") == null){
			clientId = 0;
		}else{
		clientId = getClinetidFromSession(session);
		}
		contactMessageService.addContactMessage(contactMessage, clientId);
		return new JsonResult<>(SUCCESS);
	}

}
