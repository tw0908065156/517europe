package cn.tedu.aeurope.mapper;

import java.util.List;

import cn.tedu.aeurope.entity.PersonNumber;

public interface PersonNumberMapper {
	/**
	 * 顯示參團人數列表（無參數）
	 * @return List<PersonNumber>
	 */
	List<PersonNumber> listPersonNumber();
	
	/**
	 * 查詢人數對應的車資(用於計算旅遊費用)
	 * @param personid
	 * @return
	 */
	Float selectPersonFareByid(Integer personid);
	
	/**
	 * 查詢參團人數(用於前端顯示)
	 * @param personid
	 * @return
	 */
	String selectTotalPersonByid(Integer personid);
}
