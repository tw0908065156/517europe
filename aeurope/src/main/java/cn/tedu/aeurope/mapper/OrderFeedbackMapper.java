package cn.tedu.aeurope.mapper;

import cn.tedu.aeurope.entity.OrderFeedback;

public interface OrderFeedbackMapper {

	/**
	 * 查詢訂單資料表—之行程反饋
	 * @param orderid
	 * @return
	 */
	OrderFeedback selectOrderFeedbackByid(Integer orderid);
}
