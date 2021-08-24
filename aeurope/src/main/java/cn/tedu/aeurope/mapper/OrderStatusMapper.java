package cn.tedu.aeurope.mapper;

public interface OrderStatusMapper {
	
	/**
	 * 查詢訂單狀態描述
	 * @param orderStatus
	 * @return
	 */
	String selectOrderStatusDesc(Integer orderStatus);
}
