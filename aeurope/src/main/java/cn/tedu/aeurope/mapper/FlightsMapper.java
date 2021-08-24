package cn.tedu.aeurope.mapper;

import java.util.List;

import cn.tedu.aeurope.entity.FlightsType;

public interface FlightsMapper {
	
	/**
	 * 顯示航班類型列表（無參數）
	 * @return List<FlightsType>
	 */
	List<FlightsType> listFlightsType();
	
	/**
	 * 查詢航班類型(用於前端顯示)
	 * @param flightsid
	 * @return
	 */
	String selectFlightsNameByid(Integer flightsid);
	
}
