package com.et59.cus.job;

import java.io.IOException;
import java.io.Serializable;

import org.apache.log4j.Logger;

import com.et59.cus.domain.entity.BsPagestatic;
import com.et59.cus.staticize.StaticUtil;

public class GenenateStaticPageTask implements Runnable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(GenenateStaticPageTask.class);
	private BsPagestatic bspagestatic;

	GenenateStaticPageTask(BsPagestatic bspagestatic) {
		this.bspagestatic = bspagestatic;
	}

	public void run() {
		log.info("开始执行任务：" + bspagestatic.getHtmname());
		try {
			StaticUtil.convert2Html(bspagestatic.getDynamicurl(), "UTF-8",bspagestatic.getFilepath(), bspagestatic.getHtmname());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}