package cn.tedu.aeurope.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.service.IOrderAppendService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("order_appends")
public class OrderAppendController extends BaseController {
	
	@Autowired
	IOrderAppendService orderAppendService;
	
	@RequestMapping("/")
	public JsonResult<Void> addOrderAddAppend(HttpSession session, Integer orderid, String addAppend){
		Integer clientId = getClinetidFromSession(session);
		String clientEmail = getClinetemailFromSession(session);
		orderAppendService.addOrderAddAppend(clientId, clientEmail, orderid, addAppend);
		return new JsonResult<Void>(SUCCESS);
	}
	

}
