package cn.tedu.aeurope.service;

import java.util.List;

import cn.tedu.aeurope.entity.AboutFAQ;

public interface IAboutFAQService {
	
	/**
	 * 顯示Q&A列表
	 * @return
	 */
	List<AboutFAQ> selectAboutFAQ();
}
