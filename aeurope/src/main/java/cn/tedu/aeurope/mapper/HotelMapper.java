package cn.tedu.aeurope.mapper;

import java.util.List;

import cn.tedu.aeurope.entity.HotelGrade;

public interface HotelMapper {
	
	/**
	 * 顯示飯店等級列表（無參數）
	 * @return List<HotelGrade>
	 */
	List<HotelGrade> listHotelGrade();	

	/**
	 * 查詢飯店基礎費用(用於計算旅遊費用)
	 * @param hid
	 * @return
	 */
	Float selectHotelFareByid(Integer hid);
	
	/**
	 * 查詢飯店等級(用於前端顯示)
	 * @param hid
	 * @return
	 */
	String selectHotelGradeByid(Integer hid);

}
