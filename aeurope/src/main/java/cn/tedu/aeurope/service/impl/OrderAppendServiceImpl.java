package cn.tedu.aeurope.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.OrderAddAppend;
import cn.tedu.aeurope.mapper.OrderAppendMapper;
import cn.tedu.aeurope.service.IOrderAppendService;
import cn.tedu.aeurope.service.IOrderService;
import cn.tedu.aeurope.service.ex.EmptyDataException;
import cn.tedu.aeurope.service.ex.InsertException;

@Service
public class OrderAppendServiceImpl implements IOrderAppendService{
	
	@Autowired
	OrderAppendMapper orderAppendMapper;
	
	@Autowired
	IOrderService orderService;

	@Override		//在訂單補充備註表中添加資料
	public void addOrderAddAppend(Integer clientId, String clientEmail, Integer orderid, String addAppend) {
		if(addAppend == null || addAppend.length()==0){
			throw new EmptyDataException("您尚未填寫任何信息~請在對應訂單下填寫備註或任何意見和建議，謝謝您！");
		}
		orderService.selectClientidByOrderid(orderid, clientId);
		OrderAddAppend orderAddAppend = new OrderAddAppend();
		orderAddAppend.setOrderid(orderid);
		orderAddAppend.setAddAppend(addAppend);
		Date now = new Date();
		orderAddAppend.setCreatedTime(now);
		orderAddAppend.setCreatedUser(clientEmail);
		orderAddAppend.setModifiedTime(now);
		orderAddAppend.setModifiedUser(clientEmail);
		insertOrderAddappend(orderAddAppend);
		
	}

	/**
	 * 在訂單補充備註表中添加資料
	 * @param OrderAddAppend
	 */
	private void insertOrderAddappend(OrderAddAppend orderAddAppend) {
		Integer rows=orderAppendMapper.insertOrderAddappend(orderAddAppend);
		if(rows<1){
			throw new InsertException("寫入備註時發生未知錯誤，請稍後再試或聯絡系統管理員.");
		}		
	}
}
