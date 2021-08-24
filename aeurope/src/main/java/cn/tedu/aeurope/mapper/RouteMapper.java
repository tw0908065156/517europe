package cn.tedu.aeurope.mapper;

import java.util.List;

import cn.tedu.aeurope.entity.ClassicRoute;

public interface RouteMapper {
	/**
	 * 按景點類型查詢行程列表
	 * @param caid
	 * @return
	 */
	List<ClassicRoute> selectRouteByCaid(Integer caid);

}
