package cn.tedu.aeurope.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.CalculateTemp;
import cn.tedu.aeurope.mapper.OrderCalculateMapper;
import cn.tedu.aeurope.service.IHotelService;
import cn.tedu.aeurope.service.IOrderCalculateService;
import cn.tedu.aeurope.service.IPersonNumberService;
import cn.tedu.aeurope.service.IScartService;
import cn.tedu.aeurope.service.ex.DayNotfitException;
import cn.tedu.aeurope.service.ex.DayUnfixedException;
import cn.tedu.aeurope.service.ex.HotelUnfixedException;
import cn.tedu.aeurope.service.ex.NumberUnfixedException;
import cn.tedu.aeurope.service.ex.UpdateException;

@Service
public class OrderCalculateService implements IOrderCalculateService {
	
	@Autowired
	OrderCalculateMapper orderCalculateMapper;
	
	@Autowired
	IHotelService hotelService;
	
	@Autowired
	IPersonNumberService personNumberService;
	
	@Autowired
	IScartService scartService;

	@Override		//計算團費（臨時計算表）
	public Integer calculateOrder(Integer clientId, Integer stayNights, Integer hid, Integer personid)
			throws HotelUnfixedException, NumberUnfixedException, DayUnfixedException, DayNotfitException {
		if (hid == 99) {
			throw new HotelUnfixedException("抱歉, 因您選擇自定飯店等級，無法為您提供電腦試算報價。" + "請改選固定飯店等級或直接提交選單，由專人為您提供服務。");
		}
		if (personid == 99) {
			throw new NumberUnfixedException("抱歉, 因您選擇自定義人數或人數過多，無法為您提供電腦試算報價。" + "請改選固定人數或直接提交選單，由專人為您提供服務。");
		}
		if (stayNights == 99) {
			throw new DayUnfixedException("抱歉, 因您選擇自定義天數或天數過多，無法為您提供電腦試算報價。" + "請改選固定天數或直接提交選單，由專人為您提供服務。");
		}
		
		//清空臨時計算表
		deleteAllFromCalculate();
		//計算所選城市個數，排除不合理天數
		Integer countDays = insertCalculateFromCart(clientId);
		if ((stayNights * 2) < countDays) {
			throw new DayNotfitException(
					"抱歉, 因您選擇的城市/景點較多，很難在您指定的旅遊天數中完成，無法為您提供電腦試算報價。" + "請增加旅遊天數或放棄部分景點再試。或者您可直接提交選單，由專人為您提供服務。");
		}		
		//在臨時計算表中，先設置所有城市停留1天，讓計算天數sumDays與客人所選天數stayNights比較後增減，目標：sumDays=stayNights
		List<String> stimes = selectStimeList(); //所選城市依推薦停留天數升序分類列表
		updateStayDays(1, stimes, countDays);	//設置所有城市停留1天
		Integer sumDays = selectSumSdays();
		if (sumDays != stayNights) {
			int incDay = 0;	//天數增加值
			int limitDay = 0;	//計算天數與目標的差值
			List<String> stimeTemp = new ArrayList<>();		//修改天數的城市集合
			List<String> stimeTempOld = new ArrayList<>();		//上一次修改天數的城市集合
			
			if (sumDays > stayNights) {
				do {
					stimeTemp.add(stimes.get(incDay));
					updateStayDays(0, stimeTemp, countDays);//計算天數大於目標天數，推薦停留天數最少的城市改為停留0天，
					stimeTempOld.clear();
					stimeTempOld.addAll(stimeTemp);
					sumDays = selectSumSdays();
					if (incDay < (stimes.size() - 1)) {
						incDay++;
					}
					limitDay = stayNights - sumDays;
					stimeTemp.clear();
				} while (sumDays > stayNights);
				if (limitDay != 0) {
					updateStayDays(1, stimeTempOld, limitDay);//計算天數與目標天數有差額，則最後一次修改依差額數改回1
				}
			} else {
				int setDay = 1;
				int sumDaysOld = sumDays;
				while (sumDays < stayNights) {
					if (incDay < (stimes.size() - 1)) {
						incDay = incDay + 1;
					}
					for (int i = (stimes.size() - 1); i >= incDay; i--) {
						stimeTemp.add(stimes.get(incDay));//計算天數小於目標天數，推薦停留天數第二少以上的城市停留天數次遞+1
					}
					setDay++;
					updateStayDays(setDay, stimeTemp, countDays);
					stimeTempOld.clear();
					stimeTempOld.addAll(stimeTemp);
					stimeTemp.clear();
					sumDaysOld = sumDays;
					sumDays = selectSumSdays();
					limitDay = stayNights - sumDaysOld;
				}
				;
				if (limitDay != 0) {
					setDay--;
					updateStayDays(setDay, stimeTempOld, countDays);//計算天數與目標天數有差額，則最後一次修改依復原
					setDay++;
					updateStayDays(setDay, stimeTempOld, limitDay);//最後一次修改改為依差額數部分+1
				}
			}
			sumDays = selectSumSdays();
		}
		if (sumDays != stayNights) {
			throw new UpdateException("計算過程發生未知錯誤，請稍後再試或聯絡系統管理員！");
		}
		
		Float hotelFare = hotelService.selectHotelFareByid(hid);
		Float busFare = personNumberService.selectPersonFareByid(personid);
		Integer sumSticket = scartService.selectSumSticket(clientId);
		Integer totalFare = selectSumCalculate(hotelFare, busFare) + sumSticket;
		return totalFare;
	}


	/**
	 * 將用戶購物車中城市資料插入計算器臨時表
	 * @param clientEmail(Session中的用戶名)
	 * @return 受影響的行數
	 */
	private Integer insertCalculateFromCart(Integer clientId) {
		Integer rows = orderCalculateMapper.insertCalculateFromCart(clientId);
		return rows;
	}
	
	
	/**
	 * 清空計算器臨時表
	 * @return 受影響的行數
	 */
	private void deleteAllFromCalculate() {
		orderCalculateMapper.deleteAllFromCalculate();
	}
	
	
	/**
	 * 修改各城市的停留天數
	 * @param stime 查詢條件：in(stime)
	 * @param sdays修改字段：停留天數
	 * @param limitRows 修改行數限制，全部修改要提供總行數
	 * @return 受影響的行數
	 */
	private Integer updateStayDays(Integer sdays, List<String> stimes, Integer limitRows) {
		return orderCalculateMapper.updateStayDays(sdays, stimes, limitRows);
	}
	
	/**
	 * 獲取旅遊天數列表（由小到大）
	 * @return
	 */
	private List<String> selectStimeList() {
		List<CalculateTemp> result = orderCalculateMapper.selectStimeList();
		List<String> stimes = new ArrayList<>();
		for (CalculateTemp s : result) {
			stimes.add(s.getStime());
		}
		return stimes;
	}

	/**
	 * 查詢全部sdays， 求合
	 * @return sum
	 */
	private Integer selectSumSdays() {
		Integer rows = orderCalculateMapper.selectSumSdays();
		return rows;
	}

	/**
	 * 查詢每人車資+住宿費
	 * @param hotelFare
	 * @param personFare
	 * @return sum
	 */
	private Integer selectSumCalculate(Float hotelFare, Float personFare) {
		return orderCalculateMapper.selectSumCalculate(hotelFare, personFare);
	}
	
	
}
