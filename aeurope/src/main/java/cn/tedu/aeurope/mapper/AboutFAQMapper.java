package cn.tedu.aeurope.mapper;

import java.util.List;

import cn.tedu.aeurope.entity.AboutFAQ;

public interface AboutFAQMapper {

	/**
	 * 顯示Q&A列表
	 * @return
	 */
	List<AboutFAQ> selectAboutFAQ();
}
