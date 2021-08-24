package cn.tedu.aeurope.controller;

import java.text.DecimalFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.service.IOrderCalculateService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("order_calculate")
public class OrderCalculateController extends BaseController {
	
	@Autowired
	IOrderCalculateService orderCalculateService;
	
	@GetMapping("{stayNights}/{hid}/{personid}/temp")
	public JsonResult<String> calculateOrder(@PathVariable("stayNights") Integer stayNights, 
			@PathVariable("hid") Integer hid, @PathVariable("personid") Integer personid, HttpSession session){
		Integer clientId= getClinetidFromSession(session);
		Integer totalFare=orderCalculateService.calculateOrder(clientId, stayNights, hid, personid);
		totalFare=(totalFare/100)*100;
		String data="預估費用：\n新臺幣"+(new DecimalFormat(",###").format(totalFare))+"元/人。"
				+ "\n請提交選單，獲取完整行程及準確報價。";
		return new JsonResult<>(SUCCESS, data);		
	}

}
