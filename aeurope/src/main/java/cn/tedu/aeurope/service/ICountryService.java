package cn.tedu.aeurope.service;

import java.util.List;

import cn.tedu.aeurope.entity.Country;

public interface ICountryService {
	/**
	 * 顯示國家列表（無參數）
	 * @returnList<Country>
	 */
	List<Country> getFromCountry();

}
