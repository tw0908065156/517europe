package cn.tedu.aeurope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.AboutFAQ;
import cn.tedu.aeurope.service.IAboutFAQService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("about_faq")
public class AboutFAQController extends BaseController {
	
	@Autowired
	IAboutFAQService aboutFAQService;
	
	@GetMapping("/")
	public JsonResult<List<AboutFAQ>> selectAboutFAQ(){
		List<AboutFAQ> data = aboutFAQService.selectAboutFAQ();
		return new JsonResult<List<AboutFAQ>>(SUCCESS, data);
	}

}
