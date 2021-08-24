package cn.tedu.aeurope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.HotelGrade;
import cn.tedu.aeurope.mapper.HotelMapper;
import cn.tedu.aeurope.service.IHotelService;

@Service
public class HotelService implements IHotelService {
	
	@Autowired
	HotelMapper hotelMapper;
	
	@Override		//顯示飯店等級列表
	public List<HotelGrade> getHotelGrade() {
		return listHotelGrade();
	}

	@Override		//查詢飯店基礎費用(用於計算旅遊費用)
	public Float selectHotelFareByid(Integer hid) {
		return hotelMapper.selectHotelFareByid(hid);
	}

	@Override		//查詢飯店等級(用於前端顯示)
	public String selectHotelGradeByid(Integer hid) {
		return hotelMapper.selectHotelGradeByid(hid);
	}

	
	/**
	 * 顯示飯店等級列表（無參數）
	 * @return List<HotelGrade>
	 */
	private List<HotelGrade> listHotelGrade(){
		return hotelMapper.listHotelGrade();
	}



}
