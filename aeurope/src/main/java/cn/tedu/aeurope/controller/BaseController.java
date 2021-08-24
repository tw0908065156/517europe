package cn.tedu.aeurope.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.tedu.aeurope.service.ex.CartItemNotFoundException;
import cn.tedu.aeurope.service.ex.ClientEmailDuplicateException;
import cn.tedu.aeurope.service.ex.ClientNotMatchException;
import cn.tedu.aeurope.service.ex.ClientNotfoundException;
import cn.tedu.aeurope.service.ex.DayNotfitException;
import cn.tedu.aeurope.service.ex.DayUnfixedException;
import cn.tedu.aeurope.service.ex.DeleteException;
import cn.tedu.aeurope.service.ex.EmailFormatIncorrectException;
import cn.tedu.aeurope.service.ex.EmptyDataException;
import cn.tedu.aeurope.service.ex.HotelUnfixedException;
import cn.tedu.aeurope.service.ex.InsertException;
import cn.tedu.aeurope.service.ex.NumberUnfixedException;
import cn.tedu.aeurope.service.ex.PasswordNotMatchException;
import cn.tedu.aeurope.service.ex.PaymentCompletedException;
import cn.tedu.aeurope.service.ex.ServiceException;
import cn.tedu.aeurope.service.ex.TimeExpiredException;
import cn.tedu.aeurope.service.ex.TimeNotExpiredException;
import cn.tedu.aeurope.service.ex.UpdateException;
import cn.tedu.aeurope.service.ex.VerifyCodeNotMatchException;
import cn.tedu.aeurope.util.JsonResult;

public abstract class BaseController {
	
	public static final Integer SUCCESS=100;
	
	protected final Integer getClinetidFromSession(HttpSession session){
		return Integer.valueOf(session.getAttribute("clientid").toString());
	}

	protected final String getClinetemailFromSession(HttpSession session){
		return session.getAttribute("clientemail").toString();
	}
	
	protected final String getClinetnicknamelFromSession(HttpSession session){
		return session.getAttribute("clientnickname").toString();
	}
	
	@ExceptionHandler(ServiceException.class)
	public JsonResult<Void> handlerException(Throwable e){
		JsonResult<Void> jr=new JsonResult<>();
		jr.setMessage(e.getMessage());
		
		if(e instanceof ClientEmailDuplicateException){
			jr.setState(200);
		}else if(e instanceof ClientNotfoundException){
			jr.setState(202);
		}else if(e instanceof EmailFormatIncorrectException){
			jr.setState(204);
		}else if(e instanceof PasswordNotMatchException){
			jr.setState(206);
		}else if(e instanceof HotelUnfixedException){
			jr.setState(208);
		}else if(e instanceof NumberUnfixedException){
			jr.setState(210);
		}else if(e instanceof DayUnfixedException){
			jr.setState(212);
		}else if(e instanceof DayNotfitException){
			jr.setState(214);
		}else if(e instanceof CartItemNotFoundException){
			jr.setState(216);
		}else if(e instanceof EmptyDataException){
			jr.setState(218);
		}else if(e instanceof TimeExpiredException){
			jr.setState(220);
		}else if(e instanceof TimeNotExpiredException){
			jr.setState(222);
		}else if(e instanceof VerifyCodeNotMatchException){
			jr.setState(224);
		}else if(e instanceof PaymentCompletedException){
			jr.setState(226);
		}else if(e instanceof InsertException){
			jr.setState(300);
		}else if(e instanceof UpdateException){
			jr.setState(302);
		}else if(e instanceof DeleteException){
			jr.setState(304);
		}else if(e instanceof ClientNotMatchException){
			jr.setState(306);
		}
		
		return jr;
		
	}
}
