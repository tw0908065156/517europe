package cn.tedu.aeurope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.service.IForgotPasswordService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("forgotps")
public class ForgotPasswordController extends BaseController {
	 
	@Autowired
	IForgotPasswordService forgotPasswordService;
	
	@GetMapping("/send_mail")
	public JsonResult<Void> sendVerifyCode(String clientEmail){
		forgotPasswordService.sendVerifyCode(clientEmail);
		return new JsonResult<>(SUCCESS);
	}
	
	@RequestMapping("/reset_password")
	public JsonResult<Void> updatePassword(String clientEmail, String verifyCode, String newPassword){
		forgotPasswordService.updatePassword(clientEmail, verifyCode, newPassword);
		return new JsonResult<>(SUCCESS);
	}

}
