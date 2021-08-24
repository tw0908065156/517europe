package cn.tedu.aeurope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.Scenic;
import cn.tedu.aeurope.service.IScenicService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("scenics")
public class ScenicController extends BaseController {
	@Autowired
	private IScenicService scenicService;
	
	@GetMapping("{ccode}/getscenic")
	public JsonResult<List<Scenic>> getByCcode(@PathVariable("ccode") String ccode){
		List<Scenic> data= scenicService.getByCcode(ccode);
		return new JsonResult<List<Scenic>>(SUCCESS, data);
	}

}
