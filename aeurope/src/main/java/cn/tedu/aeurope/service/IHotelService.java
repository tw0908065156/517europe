package cn.tedu.aeurope.service;

import java.util.List;

import cn.tedu.aeurope.entity.HotelGrade;

public interface IHotelService {
	
	/**
	 * 顯示飯店等級列表（無參數）
	 * @returnList<HotelGrade>
	 */
	List<HotelGrade> getHotelGrade();
	
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
