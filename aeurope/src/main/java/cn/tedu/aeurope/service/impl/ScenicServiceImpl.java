package cn.tedu.aeurope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.Scenic;
import cn.tedu.aeurope.mapper.ScenicMapper;
import cn.tedu.aeurope.service.IScenicService;

@Service
public class ScenicServiceImpl implements IScenicService {
	
	@Autowired
	private ScenicMapper scenicMapper;

	@Override
	public List<Scenic> getByCcode(String ccode) {
		return findByCcode(ccode);
	}


	
	/**
	 * 根據國家代碼獲取城市和景點明細
	 * @param ccode
	 * @return List<Scenic>
	 */
	private List<Scenic> findByCcode(String ccode){
		return scenicMapper.findByCcode(ccode);		
	}
	

}
