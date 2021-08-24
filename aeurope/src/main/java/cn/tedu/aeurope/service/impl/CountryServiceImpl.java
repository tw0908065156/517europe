package cn.tedu.aeurope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.Country;
import cn.tedu.aeurope.mapper.CountryMapper;
import cn.tedu.aeurope.service.ICountryService;

@Service
public class CountryServiceImpl implements ICountryService {
	
	@Autowired
	CountryMapper countryMapper;	

	//顯示國家列表
	@Override
	public List<Country> getFromCountry() {
		return listFromCountry();
	}

	
	
	/**
	 * 顯示國家列表（無參數）
	 * @return List<Country>
	 */
	private List<Country> listFromCountry(){
		return countryMapper.listFromCountry();
	}
	
}
