package cn.tedu.aeurope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.PersonNumber;
import cn.tedu.aeurope.mapper.PersonNumberMapper;
import cn.tedu.aeurope.service.IPersonNumberService;

@Service
public class PersonNumberService implements IPersonNumberService {
	
	@Autowired
	PersonNumberMapper personNumberMapper;

	@Override		//顯示參團人數列表
	public List<PersonNumber> getPersonNumber() {
		return listPersonNumber();
	}
	
	@Override		//查詢人數對應的車資(用於計算旅遊費用)
	public Float selectPersonFareByid(Integer personid) {
		return personNumberMapper.selectPersonFareByid(personid);
	}


	@Override		//查詢參團人數(用於前端顯示)
	public String selectTotalPersonByid(Integer personid) {
		return personNumberMapper.selectTotalPersonByid(personid);
	}
	
	
	/**
	 * 顯示參團人數列表（無參數）
	 * @return List<PersonNumber>
	 */
	private List<PersonNumber> listPersonNumber(){
		return personNumberMapper.listPersonNumber();
	}



}
