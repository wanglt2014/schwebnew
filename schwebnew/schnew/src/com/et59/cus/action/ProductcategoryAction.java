package com.et59.cus.action;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsProductcategory;
import com.et59.cus.domain.entity.BsSupplier;
import com.et59.cus.domain.entity.ex.Pager;

/**
 * 点滴工作室
 * 产品分类管理
 * @author liuhaihua
 *
 */
public class ProductcategoryAction extends BaseAction{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 产品分类管理首页
	 * @return
	 */
	public  String index(){
		return "index";
	}
	/**
	 * 分页查询产品分类
	 */
	public void query(){
		String productcategoryNamequery = request.getParameter("productcategoryNamequery");  
		String supplierCodequery = request.getParameter("supplierCodequery"); 
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		try {
			BsProductcategory bsProductcategory  = new BsProductcategory();
			if(null!=productcategoryNamequery&&!productcategoryNamequery.equals("")){
				bsProductcategory.setProductcategoryName(productcategoryNamequery);
			}
			if(null!=supplierCodequery&&!supplierCodequery.equals("")){
				bsProductcategory.setSupplierCode(supplierCodequery);
			}
			Pager pager = localServiceProxy.queryProductcategoryBypage(bsProductcategory,Integer.valueOf(rows),Integer.valueOf(page));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新产品分类
	 */
	public  void  update(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		BsProductcategory bsProductcategory = getBsProductcategory();
		try {
			bsProductcategory.setId(Integer.valueOf(id));
			localServiceProxy.udateBsProductcategory(bsProductcategory);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 新增产品分类
	 */
	public void save(){
		boolean flag =false ;
		BsProductcategory bsProductcategory = getBsProductcategory();
		try {
			localServiceProxy.saveBsProductcategory(bsProductcategory);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除产品分类
	 */
	public void delete(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		try {
			localServiceProxy.deleteBsProductcategory(Integer.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到产品分类
	 * @return
	 */
	public BsProductcategory  getBsProductcategory(){
		String productcategoryCode = request.getParameter("productcategoryCode"); 
		String productcategoryName = request.getParameter("productcategoryName"); 
		String productcategoryRemark = request.getParameter("productcategoryRemark"); 
		String supplierCode = request.getParameter("supplierCode"); 
		BsProductcategory  bsProductcategory=  new BsProductcategory();
		bsProductcategory.setProductcategoryCode(productcategoryCode);
		bsProductcategory.setProductcategoryName(productcategoryName);
		bsProductcategory.setProductcategoryRemark(productcategoryRemark);
		bsProductcategory.setSupplierCode(supplierCode);
		return bsProductcategory;
	}
	/**
	 * 分页查询供应商
	 */
	public void querySupplierCode(){
		try {
			BsSupplier bsSupplier = new BsSupplier();
			Pager pager = localServiceProxy.querySupplierByPage(bsSupplier,100000,1);
			super.reponseWriter(JSON.toJSONString(pager.getRows()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询供应商名字
	 */
	public void querySupplierNameByCode(){
		String code = request.getParameter("code"); 
		try {
			String name = localServiceProxy.querySupplierNameByCode(code);
			super.reponseWriter(name);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询产品分类名字
	 */
	public void queryproductcategroyNameByCode(){
		String code = request.getParameter("code"); 
		try {
			String name = localServiceProxy.queryBsProductcategoryByCode(code);
			super.reponseWriter(name);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有产品分类
	 */
	public void queryproductcategory(){
		try {
			BsProductcategory bsProductcategory  = new BsProductcategory();
			Pager pager = localServiceProxy.queryProductcategoryBypage(bsProductcategory,10000,1);
			super.reponseWriter(JSON.toJSONString(pager.getRows()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

