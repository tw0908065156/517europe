package cn.tedu.aeurope.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.tedu.aeurope.entity.ForgotPassword;

public interface ForgotPasswordMapper {
	
	/**
	 * 插入email驗證碼資料
	 * @param forgortPassword
	 * @return
	 */
	Integer insertForgotPassword(ForgotPassword forgortPassword);
	
	/**
	 * 更改驗證碼效期為失效
	 * @param verifyId
	 * @param expiredTime
	 * @return
	 */
	Integer updateExpiredTime(@Param("verifyId") Integer verifyId, @Param("expiredTime") Date expiredTime);
	
	
	/**
	 * 查詢忘記密碼表email對應的最新一條數據
	 * @param clientEmail
	 * @return
	 */
	ForgotPassword selectByClientEmail(String clientEmail);
	
	

}
