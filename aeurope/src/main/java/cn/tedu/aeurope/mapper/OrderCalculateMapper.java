package cn.tedu.aeurope.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.aeurope.entity.CalculateTemp;

public interface OrderCalculateMapper {

	/**
	 * 將用戶購物車中城市資料插入計算器臨時表
	 * @param clientEmail(Session中的用戶名)
	 * @return 受影響的行數
	 */
	Integer insertCalculateFromCart(Integer clientId);
	
	
	/**
	 * 清空計算器臨時表
	 * @return 受影響的行數
	 */
	Integer deleteAllFromCalculate();

	
	/**
	 * 修改各城市的停留天數
	 * @param stime 查詢條件：in(stime)
	 * @param sdays 修改字段：停留天數
	 * @param limitRows 修改行數限制，全部修改要提供總行數
	 * @return 受影響的行數
	 */
	Integer updateStayDays(@Param("sdays") Integer sdays, @Param("stimes") List<String> stimes,
			@Param("limitRows") Integer limitRows );
	
	
	/**
	 * 獲取旅遊天數列表（由小到大）
	 * @return
	 */
	List<CalculateTemp> selectStimeList();

	/**
	 * 查詢全部sdays， 求合
	 * @return sum
	 */
	Integer selectSumSdays();

	/**
	 * 查詢每人車資+住宿費
	 * @param hotelFare
	 * @param personFare
	 * @return sum
	 */
	Integer selectSumCalculate(@Param("hotelFare") Float hotelFare, @Param("personFare") Float personFare);
}
