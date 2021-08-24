package cn.tedu.aeurope.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.aeurope.entity.AboutFAQ;
import cn.tedu.aeurope.mapper.AboutFAQMapper;
import cn.tedu.aeurope.service.IAboutFAQService;

@Service
public class AboutFAQServiceImp implements IAboutFAQService {
	
	@Autowired
	AboutFAQMapper aboutFAQMapper;

	@Override
	public List<AboutFAQ> selectAboutFAQ() {
		return aboutFAQMapper.selectAboutFAQ();
	}
	

}
