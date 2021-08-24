package cn.tedu.aeurope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.FlightsType;
import cn.tedu.aeurope.service.IFlightsService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("flights")
public class FlightsController extends BaseController {
	
	@Autowired
	IFlightsService flightsService;
	
	@GetMapping("/")
	public JsonResult<List<FlightsType>> getFlightsType(){
		List<FlightsType> data= flightsService.getFlightsType();
		return new JsonResult<List<FlightsType>>(SUCCESS,data);
	}

}
