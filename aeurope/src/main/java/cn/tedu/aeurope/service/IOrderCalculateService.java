package cn.tedu.aeurope.service;

import cn.tedu.aeurope.service.ex.DayNotfitException;
import cn.tedu.aeurope.service.ex.DayUnfixedException;
import cn.tedu.aeurope.service.ex.HotelUnfixedException;
import cn.tedu.aeurope.service.ex.NumberUnfixedException;

public interface IOrderCalculateService {
	/**
	 * 計算團費（臨時計算表）
	 * @param clientEmail
	 * @param stayNights
	 * @param hotelFare
	 * @param personFare
	 */
	Integer calculateOrder(Integer clientId, Integer stayNights, Integer hid, Integer personid) throws 
	HotelUnfixedException, NumberUnfixedException, DayUnfixedException, DayNotfitException;
}
