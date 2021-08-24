package cn.tedu.aeurope.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.aeurope.entity.Client;

public interface ClientMapper {
	
	/**
	 * 插入新客戶
	 * @param client
	 * @return 影響行數，值為1
	 */
	Integer insert(Client client);
	
	/**
	 * 修改客戶資料
	 * @param client
	 * @return
	 */
	Integer updateClient(Client client);
	
	/**
	 * 更改密碼
	 * @param clientEmail
	 * @param newPassword
	 * @return
	 */
	Integer updatePassword(@Param("clientEmail") String clientEmail, 
			@Param("newPasswordMd5")  String newPasswordMd5);
	
	/**
	 * 通過email查找客戶資料
	 * @param clientEmail
	 * @return
	 */
	Client findByClientEmail(String clientEmail);
	
	/**
	 * 通過客戶Id 查找客戶資料
	 * @param clientId
	 * @return
	 */
	Client findByClientId(Integer clientId);	
	

	
}
