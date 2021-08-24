package cn.tedu.aeurope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.ClassicRoute;
import cn.tedu.aeurope.service.IRouteService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("routes")
public class RouteController extends BaseController {
	
	@Autowired
	private IRouteService routeService;
	
	@GetMapping("{caid}/get_route")
	public JsonResult<List<ClassicRoute>> selectRouteByCaid(@PathVariable("caid") Integer caid){
		List<ClassicRoute> data = routeService.selectRouteByCaid(caid);
		return new JsonResult<List<ClassicRoute>>(SUCCESS, data);
	}

}
