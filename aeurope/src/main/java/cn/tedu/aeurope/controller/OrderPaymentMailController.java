package cn.tedu.aeurope.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.service.IOrderPaymentMailService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("send_payment_mail")
public class OrderPaymentMailController extends BaseController {
	
	@Autowired
	IOrderPaymentMailService orderPaymentMailService;
	
	@RequestMapping("/")
	public JsonResult<Void> sendMailForOrderPayment(Integer orderid, HttpSession session, String otherEmail){
		String clientEmail = getClinetemailFromSession(session);
		orderPaymentMailService.sendMailForOrderPayment(orderid, clientEmail, otherEmail);
		return new JsonResult<Void>(SUCCESS);
		
	}

}
