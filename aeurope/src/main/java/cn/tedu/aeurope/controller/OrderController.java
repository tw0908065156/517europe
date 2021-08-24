package cn.tedu.aeurope.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.ScartOrder;
import cn.tedu.aeurope.service.IOrderService;
import cn.tedu.aeurope.util.JsonResult;
import cn.tedu.aeurope.vo.OrderVO;

@RestController
@RequestMapping("orders")
public class OrderController extends BaseController {
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("add_cart_order")
	public JsonResult<Void> addScartOrder(HttpSession session, ScartOrder scartOrder){
		String clientEmail = getClinetemailFromSession(session);
		Integer clientId=getClinetidFromSession(session);
		orderService.addScartOrder(clientEmail, clientId, scartOrder);
		return new JsonResult<>(SUCCESS);
	}
	
	@GetMapping("get_order_list")
	public JsonResult<List<OrderVO>> listOrderList(HttpSession session){
		Integer clientId=getClinetidFromSession(session);
		List<OrderVO> data= orderService.listOrderList(clientId);
		return new JsonResult<List<OrderVO>>(SUCCESS, data);
	}
	
	
	@GetMapping("{orderid}/delete_order")
	public JsonResult<Void> deleteScartOrderByid(@PathVariable("orderid") Integer orderid, HttpSession session){
		Integer clientId=getClinetidFromSession(session);
		orderService.deleteScartOrderByid(orderid, clientId);
		return new JsonResult<Void>(SUCCESS);
	}


}
