package cn.tedu.aeurope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.TravelDays;
import cn.tedu.aeurope.mapper.TravelDaysMapper;
import cn.tedu.aeurope.service.ITravelDaysService;

@Service
public class TravelDaysService implements ITravelDaysService {
	
	@Autowired
	TravelDaysMapper travelDaysMapper;

	@Override		//顯示旅遊天數列表
	public List<TravelDays> getTravelDays() {
		return listTravelDays();
	}
		
	@Override		//查詢旅遊天數(用於前端顯示)
	public String selectTravelDaysByid(Integer daysid) {
		return travelDaysMapper.selectTravelDaysByid(daysid);
	}
	
	
	/**
	 * 顯示旅遊天數列表（無參數）
	 * @return List<TravelDays> 
	 */
	private List<TravelDays> listTravelDays(){
		return travelDaysMapper.listTravelDays();
	}


	

}
