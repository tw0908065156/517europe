package cn.tedu.aeurope.mapper;

import java.util.List;

import cn.tedu.aeurope.entity.Scenic;

public interface ScenicMapper {
	
	/**
	 * 根據國家代碼獲取城市和景點明細
	 * @param ccode
	 * @return List<Scenic>
	 */
	List<Scenic> findByCcode(String ccode);
	
}
