package cn.tedu.aeurope.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.aeurope.entity.Client;
import cn.tedu.aeurope.service.IClientService;
import cn.tedu.aeurope.util.JsonResult;

@RestController
@RequestMapping("clients")
public class ClientController extends BaseController {
	
	@Autowired
	private IClientService clientService;
	
	@RequestMapping("regist")
	public JsonResult<Void> regist(Client client){
		clientService.regist(client);
		return new JsonResult<>(SUCCESS);
	}
	
	@RequestMapping("login")
	public JsonResult<Client> login(String clientEmail, String password, HttpSession session){
		Client client = clientService.login(clientEmail, password);
		session.setAttribute("clientid",client.getClientId());
		session.setAttribute("clientemail",client.getClientEmail());
		session.setAttribute("clientnickname", client.getClientNickname());
		System.err.println(session.getAttribute("clientemail"));
		return new JsonResult<>(SUCCESS, client);
	}
	
	@GetMapping("get_info")
	public JsonResult<Client> getByClientid(HttpSession session){
		Integer clientId = getClinetidFromSession(session);
		Client data = clientService.getByClientId(clientId);
		return new JsonResult<>(SUCCESS, data);
	}
	
	@RequestMapping("update_client")
	public JsonResult<Void> updateClient(HttpSession session, Client client){
		Integer clientId = getClinetidFromSession(session);
		client.setClientId(clientId);
		clientService.updateClient(client);
		return new JsonResult<>(SUCCESS);
	}
	
}