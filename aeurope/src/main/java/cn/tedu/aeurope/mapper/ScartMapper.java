package cn.tedu.aeurope.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.aeurope.entity.ScenicCart;
import cn.tedu.aeurope.service.ex.DeleteException;
import cn.tedu.aeurope.vo.ScartVO;

public interface ScartMapper {
	
	/**
	 * 將選定的景點存入購物車表
	 * @param  List<ScenicCart>
	 * @return 插入的行數
	 */
	Integer insertScart(List<ScenicCart> sCarts);
	
	/**
	 * 從購物車中刪除記錄(根據cartid刪除該條記錄)
	 * @param cartid
	 * @return 刪除的行數
	 */
	Integer deleteByCartid(Integer cartid);
	
	/**
	 * 刪除購物車中客戶記錄(已存入訂單後)
	 * @param clientId
	 * @return
	 */
	Integer deleteByClientId(Integer clientId) throws DeleteException;
	
	/**
	 * 根據用戶email和景點代碼查詢購物車記錄
	 * @param clientEmail
	 * @param scode
	 * @return 查到的記録count
	 */
	Integer selectScartByID(@Param("clientId") Integer clientId, @Param("scode") String scode);
	
	/**
	 * 根據前端傳回的id查詢數據是否存在？是否屬於登入用戶
	 * @param cartid
	 * @return ScenicCart
	 */
	ScenicCart selectScartByCartid(Integer cartid);
	
	
	/**
	 * 根據用戶id查詢購物車列表
	 * @param clientId
	 * @return List<ScartVO>
	 */
	List<ScartVO> selectScartByclientId(Integer clientId);
	
	
	/**
	 * 查詢購物車中是否有資料
	 * @param clientEmail
	 * @return count rows
	 */
	Integer selectCountRows(Integer clientId);
	
	/**
	 * 查詢購物車中景點門票費用 合計
	 * @param clientEmail
	 * @return sum
	 */
	Integer selectSumSticket(Integer clientId);

}
