package cn.tedu.aeurope.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.OrderFeedback;
import cn.tedu.aeurope.entity.ScartOrder;
import cn.tedu.aeurope.entity.ScenicOrder;
import cn.tedu.aeurope.mapper.OrderMapper;
import cn.tedu.aeurope.service.IFlightsService;
import cn.tedu.aeurope.service.IHotelService;
import cn.tedu.aeurope.service.IOrderFeedbackService;
import cn.tedu.aeurope.service.IOrderService;
import cn.tedu.aeurope.service.IOrderStatusService;
import cn.tedu.aeurope.service.IPersonNumberService;
import cn.tedu.aeurope.service.IScartService;
import cn.tedu.aeurope.service.ITravelDaysService;
import cn.tedu.aeurope.service.ex.CartItemNotFoundException;
import cn.tedu.aeurope.service.ex.ClientNotMatchException;
import cn.tedu.aeurope.service.ex.InsertException;
import cn.tedu.aeurope.service.ex.UpdateException;
import cn.tedu.aeurope.vo.OrderVO;
import cn.tedu.aeurope.vo.ScartVO;
import cn.tedu.aeurope.vo.TownVO;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private IScartService scartService;
	
	@Autowired
	private IFlightsService flightsService;
	
	@Autowired
	private ITravelDaysService travelDaysService;
	
	@Autowired
	private IPersonNumberService personNumberService;
	
	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IOrderStatusService orderStatusService;
	
	@Autowired
	private IOrderFeedbackService orderFeedbackService;


	@Override
	public Integer addScartOrder(String clientEmail, Integer clientId, ScartOrder scartOrder)
			throws InsertException, CartItemNotFoundException {
		scartService.queryCountRows(clientId);
		scartOrder.setClientId(clientId);
		scartOrder.setOrderStatus(1);
		Date now = new Date();
		scartOrder.setCreatedUser(clientEmail);
		scartOrder.setCreatedTime(now);
		scartOrder.setModifiedUser(clientEmail);
		scartOrder.setModifiedTime(now);
		insertScartOrder( scartOrder);
		
		List<ScartVO> scartVO= scartService.getScartByclientId(clientId);
		List<ScenicOrder> scenicOrders = new ArrayList<ScenicOrder>();
		for(ScartVO s : scartVO) {
			ScenicOrder scenicOrder = new ScenicOrder();
			scenicOrder.setOrderid(scartOrder.getOrderid());
			scenicOrder.setSid(s.getSid());
			scenicOrder.setTname(s.getTname());
			scenicOrder.setScenic(s.getScenic());
			scenicOrder.setSticket(s.getSticket());
			scenicOrder.setScode(s.getScode());
			scenicOrder.setHotelWeights(s.getHotelWeights());
			scenicOrder.setBusWeights(s.getBusWeights());
			scenicOrders.add(scenicOrder);
		}
		
		insertScenicOrder(scenicOrders);
		scartService.deleteByClientId(clientId);
		
		return null;
	}

	@Override
	public List<OrderVO> listOrderList(Integer clientId) {
		List<OrderVO> orderVOs = selectOrderList(clientId);
		
		for(OrderVO orderVO : orderVOs){
						
			//添加VO類需顯示資料
			addOrderVODetails(orderVO);
		}	
		return orderVOs;
	}

	
	@Override	//訂單狀態設為99（不顯示在訂單列表）
	public void deleteScartOrderByid(Integer orderid, Integer clientId){
		selectClientidByOrderid(orderid, clientId);
		updateOrderStatusByid(orderid, 99);		
	}
	
	@Override		//查詢訂單資料表中訂單id是否歸屬於目前登入的clientid
	public void selectClientidByOrderid(Integer orderid, Integer clientId) throws ClientNotMatchException{
		Integer result = orderMapper.selectClientidByOrderid(orderid);
		if(clientId != result){
			throw new ClientNotMatchException("您的操作無法完成！因您欲操作的數據不屬於目前登入帳號，請檢核！");
		}		
	}
	
	@Override 	//訂單資料顯示
	public void addOrderVODetails(OrderVO orderVO){
		
		//訂單日期，時間
		SimpleDateFormat myFmt=(SimpleDateFormat)DateFormat.getDateInstance();
		myFmt.applyPattern("yyyy/MM/dd HH:MM");
		orderVO.setDateFmt(myFmt.format(orderVO.getCreatedTime()));
		Integer orderid=orderVO.getOrderid();

		//購物車城市明細
		orderVO.setTownDetails(selectSidsFromScenicOrder(orderid));
		
		//行程反饋名稱、PDF鏈接
		OrderFeedback orderFeedback =orderFeedbackService.selectOrderFeedbackByid(orderid);
		if(orderFeedback != null){
		orderVO.setFeedbackName(orderFeedback.getFeedbackName());
		orderVO.setFeedbackPdf(orderFeedback.getFeedbackPdf());
		}
		
		//訂單狀態
		Integer orderStatus = orderVO.getOrderStatus();
		String orderStatusDesc = orderStatusService.selectOrderStatusDesc(orderStatus);
		orderVO.setOrderStatusDesc(orderStatusDesc);
		
		//飯店等級
		Integer hid=orderVO.getHid();
		String hotelAppend = orderVO.getHotelAppend();
		if(hid==99 && (hotelAppend == null || hotelAppend.length() ==0)){
		hotelAppend="未指定飯店等級";
		}else{				
			if(hotelAppend == null || hotelAppend.length() ==0){
				hotelAppend = hotelService.selectHotelGradeByid(hid);
			}else{
			hotelAppend = hotelService.selectHotelGradeByid(hid) + "<br>" + hotelAppend;
			}
			}
		orderVO.setHotelAppend(hotelAppend);
		
		//旅遊天數
		Integer daysid=orderVO.getDaysid();
		String daysAppend = orderVO.getDaysAppend();
		if(daysid == 99 && (daysAppend == null || daysAppend.length() == 0)){
			daysAppend="未指定天數";
		}else{
			if(daysAppend == null || daysAppend.length() == 0){
				daysAppend = travelDaysService.selectTravelDaysByid(daysid);
			}else{
				daysAppend = travelDaysService.selectTravelDaysByid(daysid) + "<br>" + daysAppend;
			}
		}
		orderVO.setDaysAppend(daysAppend);
		
		//參團人數
		Integer personid = orderVO.getPersonid();
		String personAppend = orderVO.getPersonAppend();
		if(personid == 99 && (personAppend == null || personAppend.length() ==0)){
			personAppend = "未確定人數";
		}else{				
			if(personAppend == null || personAppend.length() ==0){
				personAppend = personNumberService.selectTotalPersonByid(personid);
			}else{
				personAppend = personNumberService.selectTotalPersonByid(personid) + "<br>" + personAppend;
			}				
		}
		orderVO.setPersonAppend(personAppend);
		
		//航班偏好
		String flightsList = orderVO.getFlightsidList();
		if(flightsList == null || flightsList.length() == 0){
			orderVO.setFlightsAppend("未指訂航班");
		}else{
			List<String> flightsNames = new ArrayList<>();	
			String[] flightIDs = flightsList.split(",");
			String flightName="";
			boolean flag1 = Arrays.asList(flightIDs).contains("1");
			if(flag1){
				flightName="直飛航班:"+flightsService.selectFlightsNameByid(1);
				flightsNames.add(flightName);
			}
			boolean flag2 = Arrays.asList(flightIDs).contains("2");
			if(flag2){
				flightsNames.add("其他轉機航班均可");
			}else{
				for(String id : flightIDs){
					Integer idNum=Integer.parseInt(id);
					if(idNum !=1){
						flightName=flightsService.selectFlightsNameByid(idNum);
						if(flightName != null && flightName.length() !=0){
								flightsNames.add(flightName);
							}
						}
					}
				}
			orderVO.setFlightsAppend(String.join(",<br> " , flightsNames));
		}
	}



	@Override		//依據orderid查詢訂單明細表，生成訂單明細VO類
	public OrderVO selectOrderVOById(Integer orderid){
		return orderMapper.selectOrderVOById(orderid);
	}
	

	/**
	 * 修改訂單狀態（標識為已刪除99，已付款2，已反饋3, 已出團9）
	 * @param orderid
	 * @param orderStatus
	 * @return
	 */
	private void updateOrderStatusByid( Integer orderid, Integer orderStatus) throws UpdateException{
		Integer rows=orderMapper.updateOrderStatusByid(orderid, orderStatus);
		if(rows!=1){
			throw new UpdateException("修改訂單狀態時發生未知錯誤，請稍後再試或聯絡系統管理員！");
		}
		
	}

	/**
	 * 生成訂單資料表
	 * @param ScartOrder
	 *            scartOrder
	 * @return 受影響的行數(1)
	 */
	private void insertScartOrder(ScartOrder scartOrder) throws InsertException {
		Integer rows = orderMapper.insertScartOrder(scartOrder);
		if (rows != 1) {
			throw new InsertException("生成訂單時發生未知錯誤，請稍後再試或聯絡系統管理員！");
		}		
	}
	
	/**
	 * 生成訂單資料表—之景點明細
	 * @param scenicOrder
	 * @return 受影響的行數
	 */
	private void insertScenicOrder(List<ScenicOrder> scenicOrders) throws InsertException{
		Integer rows=orderMapper.insertScenicOrder(scenicOrders);
		if(rows <1){
			throw new InsertException("生成訂單景點明細時發生未知錯誤，請稍後再試或聯絡系統管理員！");
		}
	}

	/**
	 * 查詢訂單明細表，生成訂單明細VO類
	 * @param clientId
	 * @return List<OrderVO>
	 */
	private List<OrderVO> selectOrderList(Integer clientId){
		return orderMapper.selectOrderList(clientId);
	}

	/**
	 * 查詢訂單資料表—之景點明細，生成城市VO類
	 * @param orderid
	 * @return
	 */
	private String selectSidsFromScenicOrder(Integer orderid){
		List<TownVO> townVO = orderMapper.selectSidsFromScenicOrder(orderid);
		List<String> townList = new ArrayList<>();
		for(TownVO t : townVO){
			townList.add(t.getCtname()+" : "+t.getTnames());
		}
		String townDetails=String.join("<br>" , townList);		
		return townDetails;
	}

	
	

}
