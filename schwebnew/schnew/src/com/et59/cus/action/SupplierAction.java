package com.et59.cus.action;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsSupplier;
import com.et59.cus.domain.entity.ex.Pager;

/**
 * 点滴工作室
 * 供应商管理
 * @author liuhaihua
 *
 */
public class SupplierAction extends BaseAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 供应商管理首页
	 * @return
	 */
	public  String index(){
		return "index";
	}
	/**
	 * 分页查询供应商
	 */
	public void query(){
		String supplierNamequery = request.getParameter("supplierNamequery");
		String contanctnamequery = request.getParameter("contanctnamequery");
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		try {
			BsSupplier bsSupplier = new BsSupplier();
			if(null!=supplierNamequery&&!supplierNamequery.equals("")){
				bsSupplier.setSupplierName(supplierNamequery);
			}
			if(null!=contanctnamequery&&!contanctnamequery.equals("")){
				bsSupplier.setContactname(contanctnamequery);
			}
			Pager pager = localServiceProxy.querySupplierByPage(bsSupplier,Integer.valueOf(rows),Integer.valueOf(page));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新供应商
	 */
	public  void  update(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		BsSupplier bsSupplier = getBsSupplier();
		try {
			bsSupplier.setId(Integer.valueOf(id));
			localServiceProxy.udateSupplier(bsSupplier);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 新增供应商
	 */
	public void save(){
		boolean flag =false ;
		BsSupplier bsSupplier = getBsSupplier();
		try {
			localServiceProxy.saveSupplier(bsSupplier);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除供应商
	 */
	public void delete(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		try {
			localServiceProxy.deleteSupplier(Integer.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到供应商
	 * @return
	 */
	public BsSupplier  getBsSupplier(){
		String supplierCode = request.getParameter("supplierCode"); 
		String supplierName = request.getParameter("supplierName"); 
		String supplierInfo = request.getParameter("supplierInfo"); 
		String supplierUrl = request.getParameter("supplierUrl"); 
		String contactname = request.getParameter("contactname"); 
		String contactemail = request.getParameter("contactemail"); 
		String contactphone = request.getParameter("contactphone"); 
		BsSupplier  bssupplier=  new BsSupplier();
		bssupplier.setContactemail(contactemail);
		bssupplier.setContactname(contactname);
		bssupplier.setContactphone(contactphone);
		bssupplier.setSupplierCode(supplierCode);
		bssupplier.setSupplierInfo(supplierInfo);
		bssupplier.setSupplierName(supplierName);
		bssupplier.setSupplierUrl(supplierUrl);
		return bssupplier;
	}
}
