package cn.tedu.aeurope.service;

import cn.tedu.aeurope.service.ex.ClientNotfoundException;
import cn.tedu.aeurope.service.ex.EmptyDataException;
import cn.tedu.aeurope.service.ex.TimeExpiredException;
import cn.tedu.aeurope.service.ex.UpdateException;
import cn.tedu.aeurope.service.ex.VerifyCodeNotMatchException;

public interface IForgotPasswordService {

		/**
		 * 給email地址發送驗證碼
		 * @param clientEmail
		 * @throws ClientNotfoundException
		 * @throws EmptyDataException
		 */
		public void sendVerifyCode(String clientEmail) throws ClientNotfoundException, EmptyDataException;
		
		/**
		 * 重置密碼
		 * @param verifyCode
		 * @param newPassword
		 */
		public void updatePassword(String clientEmail, String verifyCode, String newPassword) 
				throws TimeExpiredException, VerifyCodeNotMatchException, UpdateException, EmptyDataException;
		

}
