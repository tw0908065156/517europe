package cn.tedu.aeurope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.PersonNumber;
import cn.tedu.aeurope.service.IPersonNumberService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("person_numbers")
public class PersonNumberController extends BaseController {
	
	@Autowired
	IPersonNumberService personNumberService;
	
	@GetMapping("/")
	public JsonResult<List<PersonNumber>> getPersonNumber(){
		List<PersonNumber> data=personNumberService.getPersonNumber();
		return new JsonResult<List<PersonNumber>>(SUCCESS,data);
	}

}
