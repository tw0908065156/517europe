package cn.tedu.aeurope.service;

import java.util.List;

import cn.tedu.aeurope.entity.ScartOrder;
import cn.tedu.aeurope.service.ex.CartItemNotFoundException;
import cn.tedu.aeurope.service.ex.ClientNotMatchException;
import cn.tedu.aeurope.service.ex.InsertException;
import cn.tedu.aeurope.vo.OrderVO;

public interface IOrderService {

	/**
	 * 生成訂單資料表
	 * @param ScartOrder scartOrder
	 * @return 受影響的行數(1)
	 */
	Integer addScartOrder(String clientEmail, Integer clientId,  ScartOrder scartOrder) throws InsertException, CartItemNotFoundException;

	/**
	 * 修改訂單狀態（標識為已刪除99，已付款2，已反饋3, 已出團9）
	 * @param orderid
	 * @param orderStatus
	 * @return
	 */
	void deleteScartOrderByid(Integer orderid, Integer clientId) throws ClientNotMatchException;
	
	/**
	 * 查詢訂單明細表，生成訂單明細VO類
	 * @param clientId
	 * @return List<OrderVO>
	 */
	List<OrderVO> listOrderList(Integer clientId);
	
	/**
	 * 依據orderid查詢訂單明細表，生成訂單明細VO類
	 * @param orderid
	 * @return OrderVO
	 */
	OrderVO selectOrderVOById(Integer orderid);
	
	/**
	 * 訂單資料明細VO類
	 */
	void addOrderVODetails(OrderVO orderVO);
	
	/**
	 * 查詢訂單資料表中訂單id是否歸屬於目前登入的clientid
	 * @param orderid
	 * @return
	 */
	void selectClientidByOrderid(Integer orderid, Integer clientId) throws ClientNotMatchException;
	
	
}
