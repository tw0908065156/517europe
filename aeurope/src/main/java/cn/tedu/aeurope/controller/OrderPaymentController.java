package cn.tedu.aeurope.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.service.IOrderPaymentService;
import cn.tedu.aeurope.util.JsonResult;
import cn.tedu.aeurope.vo.OrderVO;

@RestController
@RequestMapping("order_payment")
public class OrderPaymentController extends BaseController {
	
	@Autowired 
	IOrderPaymentService orderPaymentService;
	
	@GetMapping("payable")
	public JsonResult<Void> selectPayableAmountByid(Integer orderid){
		orderPaymentService.selectPayableAmountByid(orderid);
		return new JsonResult<Void>(SUCCESS);
	}
	
	@GetMapping("{orderid}/get_order_details")
	public JsonResult<OrderVO> selectOrderVOById(@PathVariable("orderid") Integer orderid, HttpSession session){
		String clientEmail = getClinetemailFromSession(session);
		OrderVO data= orderPaymentService.selectOrderVOById(orderid, clientEmail);
		return new JsonResult<OrderVO>(SUCCESS, data);
	}

}
