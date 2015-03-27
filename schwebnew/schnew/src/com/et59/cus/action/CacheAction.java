package com.et59.cus.action;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.et59.cus.cache.Cache;
import com.et59.cus.domain.entity.BsSystem;

/**
 * 
 * <p>Title: CacheAction.java</p>
 * <p>Description: 缓存类管理</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-6-5 下午06:03:35
 * @version 2.0
 *
 */
public class CacheAction extends BaseAction{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 8242075258533946799L;
	public  String index(){
		return  "index";
	}
	/**
	 * 清除系统变量
	 */
	public  void  clearSystemConstant(){
		boolean flag = false;
		try {
			List<BsSystem> list = localServiceProxy.queryBsSystem();
			for(BsSystem row:list){
				log.info("***清除缓存常量***key["+row.getSystemKey()+"]");
				Cache.getInstance().remove(row.getSystemKey());
			}
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
