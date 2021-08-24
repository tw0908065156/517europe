package cn.tedu.aeurope.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.ScenicCart;
import cn.tedu.aeurope.mapper.ScartMapper;
import cn.tedu.aeurope.service.IScartService;
import cn.tedu.aeurope.service.ex.CartItemNotFoundException;
import cn.tedu.aeurope.service.ex.ClientNotMatchException;
import cn.tedu.aeurope.service.ex.DeleteException;
import cn.tedu.aeurope.service.ex.EmptyDataException;
import cn.tedu.aeurope.service.ex.InsertException;
import cn.tedu.aeurope.vo.ScartVO;

@Service
public class ScartServiceImpl implements IScartService {

	@Autowired
	private ScartMapper scartMapper;

	@Override		//在購物車插入數據
	public void addScenicToCart(String[] sCodes, String clientEmail, Integer clientId) throws InsertException {
		/**
		 * sCodes為空無法傳遞參數，改在前端用js判斷。 if (sCodes.length < 1) { throw new
		 * InsertException("提醒：您尚未在本頁面選取任何景點！"); }
		 */
		// 在選取內容中加入漏勾選的城市
		Set<String> sCodeToSet = new HashSet<String>();
		for (int i = 0; i < sCodes.length; i++) {
			sCodeToSet.add(sCodes[i]);
			sCodeToSet.add(sCodes[i].substring(0, 7) + "00000");
		}

		// 去掉購物車中重復添加的scode
		Set<String> sCodeToSetNew = new HashSet<String>();
		for (String s : sCodeToSet) {
			Integer countScode = selectScartByID(clientId, s);
			if (countScode == 0) {
				sCodeToSetNew.add(s);
			}
		}

		if (sCodeToSetNew.isEmpty()) {
			return;
		}

		List<ScenicCart> sCarts = new ArrayList<>();
		Date now = new Date();
		for (String s : sCodeToSetNew) {
			ScenicCart scart = new ScenicCart();
			scart.setClientId(clientId);
			scart.setClientEmail(clientEmail);
			scart.setScode(s);
			scart.setCreatedTime(now);
			scart.setCreatedUser("email=" + clientEmail);
			scart.setModifiedTime(now);
			scart.setModifiedUser("email=" + clientEmail);
			sCarts.add(scart);
		}
		Integer rows = insertScart(sCarts);
		if (rows < 1) {
			throw new InsertException("Sorry! 系統寫入時出現未知錯誤，您選取的景點未能儲存，請聯絡客服或稍後再試。 ");
		}
	}

	@Override		//從購物車中刪除記錄(根據cartid刪除該條記錄)
	public void deleteFromCartByid(Integer cartid, Integer clientId) 
			throws DeleteException, CartItemNotFoundException, ClientNotMatchException {
		ScenicCart result=selectScartByCartid(cartid);
		if(result == null){
			throw new CartItemNotFoundException("資料不存在，請刷新後再試！");
			}
		if(result.getClientId() != clientId){
			throw new ClientNotMatchException("登入資料不匹配，無法執行刪除操作！");
		}
		deleteByCartid(cartid);

	}
	
	@Override		//刪除購物車中客戶記錄(已存入訂單後)
	public void deleteByClientId(Integer clientId) throws DeleteException{
		Integer rows=scartMapper.deleteByClientId(clientId);
		if(rows < 1){
			throw new DeleteException("清除原購物車數據時發生未知錯誤，請稍後再試或聯絡系統管理員。");
		}
	};
	

	@Override		//根據用戶email查詢購物車列表
	public List<ScartVO> getScartByclientId(Integer clientId) {
		List<ScartVO> scartvo = selectScartByclientId(clientId);
		return scartvo;
	}
	
	@Override		//查詢購物車中是否有資料
	public void queryCountRows(Integer clientId) throws EmptyDataException {
		selectCountRows(clientId);
		
	}
	
	@Override		//查詢購物車中景點門票費用 合計
	public Integer selectSumSticket(Integer clientId) {
		return scartMapper.selectSumSticket(clientId);
	}


	/**
	 * 將選定的景點存入購物車表
	 * 
	 * @param List<ScenicCart>
	 * @return 插入的行數
	 */
	private Integer insertScart(List<ScenicCart> sCarts) {
		return scartMapper.insertScart(sCarts);

	}

	/**
	 * 從購物車中刪除記錄(根據cartid刪除該條記錄)
	 * 
	 * @param cartid
	 * @return 刪除的行數
	 */
	private void deleteByCartid(Integer cartid) throws DeleteException {
		Integer rows = scartMapper.deleteByCartid(cartid);
		if (rows != 1) {
			throw new DeleteException("Sorry! 刪除數據時發生意外錯誤，請重試或聯絡系統管理員.");
		}
	}

	/**
	 * 根據用戶email查詢購物車列表
	 * 
	 * @param clientEmail
	 * @return List<ScartVO>
	 */
	private List<ScartVO> selectScartByclientId(Integer clientId) {
		return scartMapper.selectScartByclientId(clientId);
	}

	private Integer selectScartByID(Integer clientId, String scode) {
		return scartMapper.selectScartByID(clientId, scode);
	}

	/**
	 * 根據前端傳回的id查詢數據是否存在？是否屬於登入用戶
	 * 
	 * @param cartid
	 * @return ScenicCart
	 */
	private ScenicCart selectScartByCartid(Integer cartid) {
		return scartMapper.selectScartByCartid(cartid);
	}

	/**
	 * 查詢購物車中是否有資料
	 * @param clientEmail
	 * @return count rows
	 */
	private void selectCountRows(Integer clientId){
		Integer rows= scartMapper.selectCountRows(clientId);
		if(rows < 1){
			throw new EmptyDataException("您尚未選取任何景點, 請先選擇您想去的國家！");
		}
	}



}
