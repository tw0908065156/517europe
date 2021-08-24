package cn.tedu.aeurope.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.mapper.OrderStatusMapper;
import cn.tedu.aeurope.service.IOrderStatusService;

@Service
public class OrderStatusServiceImpl implements IOrderStatusService {
	
	@Autowired
	OrderStatusMapper orderStatusMapper;

	@Override		//查詢訂單狀態描述
	public String selectOrderStatusDesc(Integer orderStatus) {
		return orderStatusMapper.selectOrderStatusDesc(orderStatus);
	}

}
