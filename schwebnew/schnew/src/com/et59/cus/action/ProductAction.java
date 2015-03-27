package com.et59.cus.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsArticle;
import com.et59.cus.domain.entity.BsProduct;
import com.et59.cus.domain.entity.ex.BsProductQuery;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.DateUtil;

/**
 * 产品管理
 *
 */
public class ProductAction extends BaseAction{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 产品管理首页
	 * @return
	 */
	public  String  index(){
		return  "index";
	}
	/**
	 * 分页查询产品
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  void  query(){
		String startdatacreatproduct = request.getParameter("startdatacreatproduct"); 
		String enddatacreatproduct = request.getParameter("enddatacreatproduct"); 
		String queryproductcategoryCodequery = request.getParameter("queryproductcategoryCodequery");   
		String productisactive = request.getParameter("productisactive"); 
		String productnamequery = request.getParameter("productnamequery");
		
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		try {
			BsProductQuery bsProduct = new BsProductQuery();
			if(null!=startdatacreatproduct&&!startdatacreatproduct.equals("")){
				bsProduct.setStartcreatetime(DateUtil.strToDate(startdatacreatproduct));
			}
			if(null!=enddatacreatproduct&&!enddatacreatproduct.equals("")){
				bsProduct.setEndcreatetime(DateUtil.strToDate(enddatacreatproduct));
			}
			if(null!=queryproductcategoryCodequery&&!queryproductcategoryCodequery.equals("")){
				bsProduct.setProductcategoryCode(queryproductcategoryCodequery);
			}
			if(null!=productisactive&&!productisactive.equals("")&&!productisactive.equals("all")){
				bsProduct.setIsactice(productisactive);
			}
			if(null!=productnamequery&&!productnamequery.equals("")){
				bsProduct.setProductName(productnamequery);
			}
			Pager pager =new Pager();
			Map map =localServiceProxy.queryProductInfoByPage(bsProduct, Integer.valueOf(rows),Integer.valueOf(page));
			if(ComonUtil.validateMapResult(map)){
				List<BsProduct> bsProductlist = (List<BsProduct>) map.get(Constant.PRODUCT_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount =(Integer) map.get(Constant.TOTALPAGECOUNT);
				pager.setTotal(totalCount);
				pager.setRows(bsProductlist);
			}
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 保存产品
	 */
	public  void save(){
		boolean flag =false;
		BsProduct  bsProduct =getBsProduct();
		try {
			localServiceProxy.saveBsProduct(bsProduct);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 编辑产品
	 */
	public  void update(){
		boolean flag =false;
		String id =request.getParameter("id");
		BsProduct  bsProduct =getBsProduct();
		bsProduct.setId(Integer.valueOf(id));
		try {
			localServiceProxy.udateBsProduct(bsProduct);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 公共方法
	 * @return
	 */
	public  BsProduct getBsProduct(){
		String productCode =request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productPrice = request.getParameter("productPrice");
		String productImageUrl = request.getParameter("productImageUrl");
		String supplierCode = request.getParameter("supplierCode");
		String productcategoryCode = request.getParameter("productcategoryCode");
		String isactice = request.getParameter("isactice");
		String createdate = request.getParameter("createdate");
		String content = request.getParameter("content");
		BsProduct  bsProduct = new BsProduct();
		bsProduct.setCreatedate(DateUtil.strToDate(createdate));
		bsProduct.setIsactice(isactice);
		bsProduct.setProductcategoryCode(productcategoryCode);
		bsProduct.setProductCode(productCode);
		bsProduct.setProductImageUrl(productImageUrl);
		bsProduct.setProductInfo(content);
		bsProduct.setProductName(productName);
		bsProduct.setProductPrice(new BigDecimal(productPrice));
		bsProduct.setSupplierCode(supplierCode);
		
		return bsProduct;
	}
	/**
	 * 删除产品
	 */
	public  void  deleteBsProduct(){
		boolean flag =false;
		String id =request.getParameter("id");
		try {
			localServiceProxy.deleteBsProduct(Integer.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
