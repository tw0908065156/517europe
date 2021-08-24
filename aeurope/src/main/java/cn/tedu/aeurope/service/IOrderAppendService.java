package cn.tedu.aeurope.service;

public interface IOrderAppendService {

	/**
	 * 在訂單補充備註表中添加資料
	 * @param clientId
	 * @param orderid
	 * @param addAppend
	 */
	void addOrderAddAppend(Integer clientId, String clientEmail, Integer orderid, String addAppend);

}
