package cn.tedu.aeurope.service;

import cn.tedu.aeurope.service.ex.PaymentCompletedException;
import cn.tedu.aeurope.vo.OrderVO;

public interface IOrderPaymentService {
	
	/**
	 * 根據訂單id查詢應付款金額
	 * @param orderid
	 * @return 應付款金額
	 */
	Integer selectPayableAmountByid(Integer orderid) throws PaymentCompletedException;
	
	/**
	 * 依據orderid查詢訂單明細表，生成訂單明細VO類
	 * @param orderid
	 * @return OrderVO
	 */
	OrderVO selectOrderVOById(Integer orderid, String clientEmail) throws PaymentCompletedException;

}
