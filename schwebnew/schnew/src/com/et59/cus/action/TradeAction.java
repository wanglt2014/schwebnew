package com.et59.cus.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.et59.cus.domain.entity.BsOrder;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;

/**
 * <p>Title: TradeAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2012-2-16
 * @version 2.0
 *
 */
public class TradeAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass());
	private List<BsOrder> orderlist;
	/**
	 * 交易查询首页
	 * @return
	 */
	public String toTradeQuery(){
		return "toTradeSearch";
	}
	/**
	 * 交易查询
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String doTradeSearch(){
		
		if(log.isDebugEnabled()){
			log.debug("查询交易信息currentPage>>>>:"+currentPage);
		}
		BsOrder orderobj = new BsOrder();
		if(null==getUser()){
			orderobj.setUserId("");//测试用以后删掉
		}else{
			orderobj.setUserId(getUser().getUserid());
		}
		try {
			Map map =localServiceProxy.queryOrderForPage(orderobj, Constant.PAGESIZE,currentPage);
			if(ComonUtil.validateMapResult(map)){
				orderlist = (List<BsOrder>) map.get(Constant.ORDER_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount =(Integer) map.get(Constant.TOTALPAGECOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "search_result";
	}
	public List<BsOrder> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<BsOrder> orderlist) {
		this.orderlist = orderlist;
	}
	
}
