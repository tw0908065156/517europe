package cn.tedu.aeurope;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.aeurope.entity.Client;
import cn.tedu.aeurope.entity.Scenic;
import cn.tedu.aeurope.mapper.ClientMapper;
import cn.tedu.aeurope.mapper.ScenicMapper;
import cn.tedu.aeurope.service.IClientService;
import cn.tedu.aeurope.service.IScenicService;
import cn.tedu.aeurope.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class AeuropeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	DataSource dataSource;
	@MockBean 
	
	/**
 	@Autowired
	private ClientMapper mapper;
	
	@Test
	public void update(){
		Client client = new Client();
		client.setClientId(47);
		client.setClientEmail("aaa@gmail.com");
		client.setClientPassword("1234");
		client.setClientNickname("白富美");
		client.setClientPhone("13487954");
		client.setClientGender(5);
		Integer rows=mapper.updateClient(client);
		System.err.println("rows="+rows);
	}
	
	@Test
	public void findByCcode(){
		String ccode="1001";
		List<Scenic> scenic=mapper.findByCcode(ccode);
		System.err.println("BEGIN");
		for(Scenic item : scenic){
			System.err.println(item);
	}
		System.err.println("END");
	}
*/	

	
/**
	@Test
	public void getByClientId(){
		Integer clientId=37;
		Client client = service.getByClientId(clientId);
		System.err.println(client);
	}

	*/
	@Autowired
	IScenicService service;
	
	@Test
	public void findbyccode(){
		String ccode="1001";
		List<Scenic> scenic=service.getByCcode(ccode);
		System.err.println("BEGIN");
		for(Scenic item : scenic){
			System.err.println(item);
	}
		System.err.println("END");
	}
/**	
	@Test
	public void updateClient(){
		try{
		Client client = new Client();
		client.setClientId(32);
		client.setClientEmail("bai0614i@gmail.com");
		client.setClientPassword("5678");
		client.setClientNickname("白1057");
		client.setClientPhone("5678");
		client.setClientGender(1);
		service.updateClient(client);
		 System.err.println("ok....");
		}catch(ServiceException e){
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
*/	
/**	
	@Test
	public void login(){
		try{
			String clientEmail="abcd@gmail.com";
			String password="1234";
			Client result=service.login(clientEmail, password);
			System.err.println(result);
		}catch(ServiceException e){
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
*/
}



