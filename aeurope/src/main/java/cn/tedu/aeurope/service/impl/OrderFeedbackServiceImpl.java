package cn.tedu.aeurope.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.OrderFeedback;
import cn.tedu.aeurope.mapper.OrderFeedbackMapper;
import cn.tedu.aeurope.service.IOrderFeedbackService;

@Service
public class OrderFeedbackServiceImpl implements IOrderFeedbackService {
	
	@Autowired
	OrderFeedbackMapper orderFeedbackMapper;

	@Override		//查詢訂單資料表—之行程反饋
	public OrderFeedback selectOrderFeedbackByid(Integer orderid) {
		return orderFeedbackMapper.selectOrderFeedbackByid(orderid);
	}

}
