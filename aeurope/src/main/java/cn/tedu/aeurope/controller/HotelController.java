package cn.tedu.aeurope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.HotelGrade;
import cn.tedu.aeurope.service.IHotelService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("hotels")
public class HotelController extends BaseController {
	
	@Autowired
	IHotelService hotelService;
	
	@GetMapping("/")
	public JsonResult<List<HotelGrade>> getHotelGrade(){
		List<HotelGrade> data=hotelService.getHotelGrade();
		return new JsonResult<List<HotelGrade>>(SUCCESS, data);
	}

}
