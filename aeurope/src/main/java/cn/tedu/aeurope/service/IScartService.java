package cn.tedu.aeurope.service;

import java.util.List;

import cn.tedu.aeurope.service.ex.CartItemNotFoundException;
import cn.tedu.aeurope.service.ex.ClientNotMatchException;
import cn.tedu.aeurope.service.ex.DeleteException;
import cn.tedu.aeurope.service.ex.EmptyDataException;
import cn.tedu.aeurope.service.ex.InsertException;
import cn.tedu.aeurope.vo.ScartVO;

public interface IScartService {
	
	/**
	 * 在購物車插入數據
	 * @param sCodes，clientEmail
	 * @throws InsertException
	 */
	void addScenicToCart(String[]  sCodes, String clientEmail, Integer clientId) throws InsertException ;
	
	
	/**
	 * 從購物車中刪除記錄(根據cartid刪除該條記錄)
	 * @param cartid
	 * @return 刪除的行數
	 */
	void deleteFromCartByid(Integer cartid, Integer clientId) throws DeleteException, CartItemNotFoundException, ClientNotMatchException;
	
	/**
	 * 刪除購物車中客戶記錄(已存入訂單後)
	 * @param clientId
	 * @return
	 */
	void deleteByClientId(Integer clientId);
	
	
	/**
	 * 根據用戶email查詢購物車列表
	 * @param clientEmail
	 * @return List<ScartVO>
	 */
	List<ScartVO> getScartByclientId(Integer clientId);
	
	
	/**
	 * 查詢購物車中是否有資料
	 * @param clientEmail
	 * @return count rows
	 */
	void queryCountRows(Integer clientId) throws EmptyDataException;
	
	
	/**
	 * 查詢購物車中景點門票費用 合計
	 * @param clientEmail
	 * @return sum
	 */
	Integer selectSumSticket(Integer clientId);

}
