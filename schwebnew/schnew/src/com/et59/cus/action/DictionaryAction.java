package com.et59.cus.action;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsProductcategory;
import com.et59.cus.domain.entity.BsSupplier;
import com.et59.cus.domain.entity.TDictionary;
import com.et59.cus.domain.entity.ex.Pager;

/**
 * 数据字典
 *
 */
public class DictionaryAction extends BaseAction{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 数据字典首页
	 * @return
	 */
	public  String index(){
		return "index";
	}
	/**
	 * 分页查询产品分类
	 */
	public void query(){
//		String productcategoryNamequery = request.getParameter("productcategoryNamequery");  
//		String supplierCodequery = request.getParameter("supplierCodequery"); 
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		try {
//			BsProductcategory bsProductcategory  = new BsProductcategory();
//			if(null!=productcategoryNamequery&&!productcategoryNamequery.equals("")){
//				bsProductcategory.setProductcategoryName(productcategoryNamequery);
//			}
//			if(null!=supplierCodequery&&!supplierCodequery.equals("")){
//				bsProductcategory.setSupplierCode(supplierCodequery);
//			}
			Pager pager = localServiceProxy.queryDictionaryBypage(new TDictionary(),Integer.valueOf(rows),Integer.valueOf(page));
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
		TDictionary tDictionary = getDictionary();
		try {
			tDictionary.setDictionaryid(Integer.valueOf(id));
			localServiceProxy.udateDictionary(tDictionary);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 新增数据字典
	 */
	public void save(){
		boolean flag =false ;
		TDictionary tDictionary = getDictionary();
		try {
			localServiceProxy.saveDictionary(tDictionary);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除数据字典
	 */
	public void delete(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		try {
			localServiceProxy.deleteDictionary(Integer.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到数据字典
	 * @return
	 */
	public TDictionary  getDictionary(){
		String dictionarycode = request.getParameter("dictionarycode"); 
		String dictionaryvalue = request.getParameter("dictionaryvalue"); 
		String dictionarytype = request.getParameter("dictionarytype"); 
		String dictionaryremark = request.getParameter("dictionaryremark"); 
		TDictionary tDictionary = new TDictionary();
		tDictionary.setDictionarycode(dictionarycode);
		tDictionary.setDictionaryvalue(dictionaryvalue);
		tDictionary.setDictionarytype(dictionarytype);
		tDictionary.setDictionaryremark(dictionaryremark);
		return tDictionary;
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
	 * 通过类别查询数据字典
	 */
	public void queryDictionaryByType(){
		String type = request.getParameter("type"); 
		try {
//			String name = localServiceProxy.querySupplierNameByCode(type);
			TDictionary tDictionary = new TDictionary();
			tDictionary.setDictionarytype(type);
			Pager pager = localServiceProxy.queryDictionaryBypage(tDictionary,100000,1);
			super.reponseWriter(JSON.toJSONString(pager.getRows()));
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

