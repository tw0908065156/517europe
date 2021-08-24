package cn.tedu.aeurope.mapper;

import java.util.List;

import cn.tedu.aeurope.entity.Country;

public interface CountryMapper {
	/**
	 * 顯示國家列表（無參數）
	 * @return List<Country>
	 */
	List<Country> listFromCountry();
}
