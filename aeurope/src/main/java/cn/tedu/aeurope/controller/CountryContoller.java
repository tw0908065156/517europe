package cn.tedu.aeurope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.Country;
import cn.tedu.aeurope.service.ICountryService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("countries")
public class CountryContoller extends BaseController {
	@Autowired
	private ICountryService countryService;
	
	@GetMapping("/")
	public JsonResult<List<Country>> getFromCountry(){
		List<Country> data= countryService.getFromCountry();
		return new JsonResult<List<Country>>(SUCCESS, data);
	}
	

}
