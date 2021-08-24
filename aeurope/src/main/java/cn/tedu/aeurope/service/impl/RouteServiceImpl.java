package cn.tedu.aeurope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.ClassicRoute;
import cn.tedu.aeurope.mapper.RouteMapper;
import cn.tedu.aeurope.service.IRouteService;

@Service
public class RouteServiceImpl implements IRouteService {
	
	@Autowired
	private RouteMapper routeMapper;
	
	@Override
	public List<ClassicRoute> selectRouteByCaid(Integer caid) {
		return  routeMapper.selectRouteByCaid(caid);
	}
	
}
