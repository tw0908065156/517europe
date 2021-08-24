package cn.tedu.aeurope.service;

public interface IOrderStatusService {
	
	/**
	 * 查詢訂單狀態描述
	 * @param orderStatus
	 * @return
	 */
	String selectOrderStatusDesc(Integer orderStatus);

}
