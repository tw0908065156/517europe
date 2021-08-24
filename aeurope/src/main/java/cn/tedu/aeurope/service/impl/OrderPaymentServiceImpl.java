package cn.tedu.aeurope.service.impl;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.OrderPayment;
import cn.tedu.aeurope.mapper.OrderPaymentMapper;
import cn.tedu.aeurope.service.IOrderPaymentService;
import cn.tedu.aeurope.service.IOrderService;
import cn.tedu.aeurope.service.ex.PaymentCompletedException;
import cn.tedu.aeurope.vo.OrderVO;

@Service
public class OrderPaymentServiceImpl implements IOrderPaymentService {
	
	@Autowired
	OrderPaymentMapper orderPaymentMapper;
	
	@Autowired
	IOrderService orderService;
	

	@Override	//根據訂單id查詢應付款金額
	public Integer selectPayableAmountByid(Integer orderid) throws PaymentCompletedException{
		List<OrderPayment> orderPayments=selectOrderPaymentByid(orderid);
		Integer sumPayableAmout=0; //應付款金額合計
		Integer sumPaymentAmout=0;	//已付款金額合計
		List<String> listPaymentTime = new ArrayList<>();	//已付款時間列表
		for(OrderPayment ops : orderPayments){
			if(ops.getPayableAmount() != null){
				sumPayableAmout += ops.getPayableAmount();
			}
			if( ops.getPaymentAmount() != null && ops.getPaymentAmount() != 0){
				sumPaymentAmout += ops.getPaymentAmount();
				if(ops.getPaymentTime() != null){
					SimpleDateFormat myFmt=(SimpleDateFormat)DateFormat.getDateInstance();
					myFmt.applyPattern("yyyy/MM/dd");
					listPaymentTime.add(myFmt.format(ops.getPaymentTime()));
				}
			}
		}
		if((sumPayableAmout-sumPaymentAmout) <= 0){
			if(listPaymentTime.size()>0){
				throw new PaymentCompletedException("您的訂單已於下列日期付款完畢。如有疑問，請聯絡您的業務員。\n"
						+listPaymentTime.toString());
			}
			throw new PaymentCompletedException("這筆訂單目前沒有待付款金額。如有疑問，請聯絡您的業務員。");
		}
		return (sumPayableAmout-sumPaymentAmout);
	}

	
	@Override	//依據orderid查詢訂單明細表，生成訂單明細VO類
	public OrderVO selectOrderVOById(Integer orderid, String clientEmail) throws PaymentCompletedException{
		OrderVO orderVO = orderService.selectOrderVOById(orderid);
		orderService.addOrderVODetails(orderVO);
		Integer payableAmout = selectPayableAmountByid(orderid);
		orderVO.setPayableAmount("新臺幣" + new DecimalFormat(",###").format(payableAmout) + "元");
		orderVO.setClientEmail(clientEmail);
		return orderVO;
	}
	
	
	/**
	 * 根據訂單id查詢付款資料
	 * @param orderid
	 * @return
	 */
	private List<OrderPayment> selectOrderPaymentByid(Integer orderid) {
		return orderPaymentMapper.selectOrderPaymentByid(orderid);
	}
}
