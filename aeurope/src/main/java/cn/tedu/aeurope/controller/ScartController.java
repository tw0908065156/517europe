package cn.tedu.aeurope.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.service.IScartService;
import cn.tedu.aeurope.service.ex.DeleteException;
import cn.tedu.aeurope.service.ex.InsertException;
import cn.tedu.aeurope.util.JsonResult;
import cn.tedu.aeurope.vo.ScartVO;

@RestController
@RequestMapping("scarts")
public class ScartController extends BaseController {

	@Autowired
	private IScartService scartService;

	@RequestMapping("add-scenic-to-cart")
	public JsonResult<Void> addScenicToCart(String[]  sCodes, HttpSession session) throws InsertException {
		String clientEmail=getClinetemailFromSession(session);
		Integer clientId = getClinetidFromSession(session);
		scartService.addScenicToCart(sCodes, clientEmail, clientId);		
		return new JsonResult<>(SUCCESS);

	}
	
	@GetMapping("{cartid}/delete_by_cartid")
	public JsonResult<Void> deleteFromCartByid(@PathVariable("cartid") Integer cartid, HttpSession session)
			throws DeleteException{
		Integer clientId=getClinetidFromSession(session);
		scartService.deleteFromCartByid(cartid,clientId);
		return new JsonResult<>(SUCCESS);
	}
	
	@GetMapping("list-scart")
	public JsonResult<List<ScartVO>> getScartByclientEmail( HttpSession session){
		Integer clientId=getClinetidFromSession(session);
		List<ScartVO> data = scartService.getScartByclientId(clientId);
		return new JsonResult<List<ScartVO>>(SUCCESS, data);
	}
	
	@GetMapping("not_empty")
	public JsonResult<Void> queryCountRows(HttpSession session){
		Integer clientId = getClinetidFromSession(session);
		scartService.queryCountRows(clientId);
		return new JsonResult<>(SUCCESS);
	}
	
}
