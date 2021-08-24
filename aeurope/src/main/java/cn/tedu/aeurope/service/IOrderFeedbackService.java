package cn.tedu.aeurope.service;

import cn.tedu.aeurope.entity.OrderFeedback;

public interface IOrderFeedbackService {
	
	/**
	 * 查詢訂單資料表—之行程反饋
	 * @param orderid
	 * @return
	 */
	OrderFeedback selectOrderFeedbackByid(Integer orderid);

}
