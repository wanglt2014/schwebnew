package com.et59.cus.job;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.et59.cus.domain.entity.BsPagestatic;
import com.et59.cus.domain.entity.OpenOauth;
import com.et59.cus.service.LocalService;
import com.et59.cus.staticize.StaticUtil;
import com.et59.cus.test.ThreadPoolTask;
import com.et59.cus.tools.Constant;

public class QuartzJob {
	private Logger log = Logger.getLogger(QuartzJob.class);
	@Autowired
	protected LocalService localServiceProxy;
	/**
	 * corePoolSize： 线程池维护线程的最少数量
	 * maximumPoolSize：线程池维护线程的最大数量
	 * keepAliveTime： 线程池维护线程所允许的空闲时间
	 * unit： 线程池维护线程所允许的空闲时间的单位
	 * workQueue： 线程池所使用的缓冲队列
	 * handler： 线程池对拒绝任务的处理策略
	 */
	ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 3,
			TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(15),
			new ThreadPoolExecutor.DiscardOldestPolicy());

	/**
	 * 清除accessToken过期是否失效
	 */
	public void cleanAccessToken() {
		log.info("Quartz的任务调度！！！凌晨1：00启动，清理AccessToken启用……");
		OpenOauth openOauth = new OpenOauth();
		try {
			openOauth.setTokenIsactive(Constant.ISACTIVE_YES);
			List<OpenOauth> list = localServiceProxy.queryOpenOauth(openOauth);
			for (OpenOauth row : list) {
				Date starttime = row.getUptime();
				Date nowtime = new Date();
				long secondtime = (nowtime.getTime() - starttime.getTime()) / 1000;
				log.info("secondtime:" + secondtime);
				if (secondtime > row.getTokenExpires()) {
					log.info("AccessToken[" + row.getAccessToken() + "]失效了!");
					row.setTokenIsactive(Constant.ISACTIVE_NO);
					localServiceProxy.updateOpenOauth(row);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 静态页面生成
	 */
	public void genenateStaticPage() {
		log.info("Quartz的任务调度！！！凌晨2：00启动，静态页面生成page启用……");
		BsPagestatic bspagestatic = new BsPagestatic();
		try {
			List<BsPagestatic> list = localServiceProxy.querypagestatic(bspagestatic);
			for (BsPagestatic row : list) {
				GenenateStaticPageTask task =new GenenateStaticPageTask(row);
				threadPool.execute(task);  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}