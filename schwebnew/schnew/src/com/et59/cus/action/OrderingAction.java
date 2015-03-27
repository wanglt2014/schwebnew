package com.et59.cus.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.et59.cus.domain.entity.BsOrder;
import com.et59.cus.domain.entity.BsProduct;
import com.et59.cus.domain.entity.ex.BsProductQuery;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;

/**
 * <p>Title: orderproduct.java</p>
 * <p>Description: 产品订购</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2012-2-15
 * @version 2.0
 *
 */
public class OrderingAction extends BaseAction{
	Logger log =Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 1L;
	
	private List<BsProduct> productlist;
	
	private String producttype; 
	
	/**
	 * 跳转到订购首页
	 * @return
	 */
	public String toSubIndex(){
		return "toSubIndex";
	}
	/**
	 * 产品搜索页
	 * @return
	 */
	public String toProductSearch(){
		getSession().put(Constant.SUPPLIERCODE, suppliercode);
		return  "toProductSearch";
	}
	/**
	 * 产品搜索结果
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String doProductSearch(){
		if(log.isDebugEnabled()){
			log.debug("查询产品列表currentPage>>>>:"+currentPage+" <<<<<producttype>>>>>:"+producttype);
		}
		String supplier_Code = (String) getSession().get(Constant.SUPPLIERCODE);
		BsProductQuery product = new BsProductQuery();
		product.setSupplierCode(supplier_Code);
		product.setProductcategoryCode(producttype);
		product.setIsactice(Constant.ISACTIVE_YES);
		try {
			Map map =localServiceProxy.queryProductInfoByPage(product,Constant.PAGESIZE,currentPage);
			if(ComonUtil.validateMapResult(map)){
				productlist = (List<BsProduct>) map.get(Constant.PRODUCT_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount =(Integer) map.get(Constant.TOTALPAGECOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "search_result";
	}
	/**
	 * 查询产品详细信息
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String queryProductInfo(){
		String id =  request.getParameter("id");
		if(log.isDebugEnabled()){
			log.debug("将要查询的产品iD---->"+id);
		}
		try {
			Map map =localServiceProxy.queryProductDetail(Integer.valueOf(id));
			if(ComonUtil.validateMapResult(map)){
				product = (BsProduct) map.get(Constant.PRODUCT_OBJ);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "product_detailInfo";
	}
	/***
	 * 选择购买产品
	 * @return
	 */
	public String doProductChoose(){
		return  "product_choose";
	}

	public List<BsProduct> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<BsProduct> productlist) {
		this.productlist = productlist;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	

	
}
