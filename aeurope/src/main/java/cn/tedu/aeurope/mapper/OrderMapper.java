package cn.tedu.aeurope.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.aeurope.entity.ScartOrder;
import cn.tedu.aeurope.entity.ScenicOrder;
import cn.tedu.aeurope.vo.OrderVO;
import cn.tedu.aeurope.vo.TownVO;

public interface OrderMapper {

	/**
	 * 生成訂單資料表
	 * @param ScartOrder scartOrder
	 * @return 受影響的行數(1)
	 */
	Integer insertScartOrder(ScartOrder scartOrder);
	
	/**
	 * 生成訂單資料表—之景點明細
	 * @param scenicOrder
	 * @return 受影響的行數
	 */
	Integer insertScenicOrder(List<ScenicOrder> scenicOrders);
	
	/**
	 * 修改訂單狀態（標識為已刪除99，已付款2，已反饋3, 已出團9）
	 * @param orderid
	 * @param orderStatus
	 * @return
	 */
	Integer updateOrderStatusByid(@Param("orderid") Integer orderid, @Param("orderStatus") Integer orderStatus);

	/**
	 * 查詢訂單明細表，生成訂單明細VO類
	 * @param clientId
	 * @return List<OrderVO>
	 */
	List<OrderVO> selectOrderList(Integer clientId);
	
	/**
	 * 依據orderid查詢訂單明細表，生成訂單明細VO類
	 * @param orderid
	 * @return OrderVO
	 */
	OrderVO selectOrderVOById(Integer orderid);

	/**
	 * 查詢訂單資料表—之景點明細，生成城市VO類
	 * @param orderid
	 * @return
	 */
	List<TownVO> selectSidsFromScenicOrder(Integer orderid);

	/**
	 * 查詢訂單資料表中訂單id的clientid
	 * @param orderid
	 * @return
	 */
	Integer selectClientidByOrderid(Integer orderid);
	
}
