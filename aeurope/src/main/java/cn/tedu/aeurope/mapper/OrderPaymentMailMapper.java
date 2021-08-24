package cn.tedu.aeurope.mapper;

import java.util.List;

import cn.tedu.aeurope.entity.OrderPaymentMail;

public interface OrderPaymentMailMapper {
	
	/**
	 * email發送付款帳號後存入資料到數據表
	 * @param orderPaymentMail
	 * @return
	 */
	Integer insertOrderPaymentMail(OrderPaymentMail orderPaymentMail);
	
	
	/**
	 * 根據orderid查詢已發送mail的OtherMailList
	 * @param orderid
	 * @return
	 */
	List<String> selectOtherMailList(Integer orderid);

}
