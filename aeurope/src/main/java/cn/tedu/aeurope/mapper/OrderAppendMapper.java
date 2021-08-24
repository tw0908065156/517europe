package cn.tedu.aeurope.mapper;

import cn.tedu.aeurope.entity.OrderAddAppend;
import cn.tedu.aeurope.service.ex.InsertException;

public interface OrderAppendMapper {
	
	/**
	 * 在訂單補充備註表中添加資料
	 * @param OrderAddAppend
	 */
	Integer insertOrderAddappend(OrderAddAppend  orderAddAppend) throws InsertException;

}
