package cn.tedu.aeurope.mapper;

import java.util.List;

import cn.tedu.aeurope.entity.OrderPayment;

public interface OrderPaymentMapper {
	
	/**
	 * 根據訂單id查詢付款資料
	 * @param orderid
	 * @return
	 */
	List<OrderPayment> selectOrderPaymentByid(Integer orderid);
}
