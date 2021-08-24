package cn.tedu.aeurope.mapper;

import java.util.List;

import cn.tedu.aeurope.entity.TravelDays;

public interface TravelDaysMapper {
	
	/**
	 * 顯示旅遊天數列表（無參數）
	 * @return List<TravelDays> 
	 */
	List<TravelDays> listTravelDays();
	
	/**
	 * 查詢旅遊天數(用於前端顯示)
	 * @param daysid
	 * @return
	 */
	String selectTravelDaysByid(Integer daysid);
}
