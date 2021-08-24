package cn.tedu.aeurope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.FlightsType;
import cn.tedu.aeurope.mapper.FlightsMapper;
import cn.tedu.aeurope.service.IFlightsService;

@Service
public class FlightsService implements IFlightsService {
	
	@Autowired
	FlightsMapper flightsMapper;

	@Override
	public List<FlightsType> getFlightsType() {
		return listFlightsType();
	}

	@Override		//查詢航班類型(用於前端顯示)
	public String selectFlightsNameByid(Integer flightsid) {
		return flightsMapper.selectFlightsNameByid(flightsid);
	}
	
	
	/**
	 * 顯示航班類型列表（無參數）
	 * @return List<FlightsType>
	 */
	private List<FlightsType> listFlightsType(){
		return flightsMapper.listFlightsType();
	}


}
