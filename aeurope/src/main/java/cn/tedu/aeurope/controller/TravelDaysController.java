package cn.tedu.aeurope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.TravelDays;
import cn.tedu.aeurope.service.ITravelDaysService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("traveldays")
public class TravelDaysController extends BaseController {
	
	@Autowired
	ITravelDaysService travelDaysService;
	
	@GetMapping("/")
	public JsonResult<List<TravelDays>> getTravelDays(){
		List<TravelDays> data=travelDaysService.getTravelDays();
		return new JsonResult<List<TravelDays>>(SUCCESS,data);
	}

}
