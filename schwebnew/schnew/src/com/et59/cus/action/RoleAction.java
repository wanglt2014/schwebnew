package com.et59.cus.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsRole;
import com.et59.cus.domain.entity.BsRoleResource;
import com.et59.cus.domain.entity.TRoleMenu;
import com.et59.cus.domain.entity.ex.Pager;

/**
 * 
 * <p>Title: RoleAction.java</p>
 * <p>Description: 角色管理</p>
 * @date 2014-4-23 下午05:43:18
 * @version 2.0
 *
 */
public class RoleAction extends BaseAction {
	Logger log = Logger.getLogger(this.getClass());
	/**
	 *角色管理
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主页
	 * @return
	 */
	public  String    index(){
		return "index";
	}
	/**
	 * 查询主页
	 */
	public  void query(){
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		String roleNamequery = request.getParameter("roleNamequery"); 

		try {
			BsRole bsRole  = new BsRole();
			bsRole.setName(roleNamequery);
			Pager pager = localServiceProxy.queryBsRoleByPage(bsRole,Integer.valueOf(rows),Integer.valueOf(page));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新角色
	 */
	public  void  update(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		String menuid = request.getParameter("menuid"); 
		BsRole role = getBsRole();
		try {
			role.setId(Integer.valueOf(id));
			localServiceProxy.updateBsRole(role,menuid);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 新增角色
	 */
	public void save(){
		boolean flag =false ;
		BsRole role = getBsRole();
		String menuid = request.getParameter("menuid"); 
		try {
			localServiceProxy.saveBsRole(role,menuid);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除角色
	 */
	public void delete(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		try {
			localServiceProxy.deleteBsRole(Integer.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到角色
	 * @return
	 */
	public BsRole  getBsRole(){
		String name = request.getParameter("name"); 
		String isactive = request.getParameter("isactive"); 
		BsRole  role=  new BsRole();
		role.setIsactive(isactive);
		role.setName(name);
		return role;
	}
	/**
	 * 删除角色资源
	 */
	public void queryTRoleMenuByroleid(){
		String roleid = request.getParameter("roleid"); 
		try {
			List<TRoleMenu>  list =localServiceProxy.queryTRoleMenuByroleid(Integer.valueOf(roleid));
			String json ="";
			if(null!=list&&list.size()>0){
				for(TRoleMenu row:list){
					json = json+row.getMenuid().toString()+",";
				}
				json = json.substring(0, json.length()-1);
				log.info(json);
			}
			super.reponseWriter(json);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	/**
//	 * 删除角色资源
//	 */
//	public void queryresourceByroleid(){
//		String roleid = request.getParameter("roleid"); 
//		try {
//			List<BsRoleResource>  list =localServiceProxy.queryBsRoleResourceByroleid(Integer.valueOf(roleid));
//			String json ="";
//			if(null!=list&&list.size()>0){
//				for(BsRoleResource row:list){
//					json = json+row.getResourceid()+",";
//				}
//				json = json.substring(0, json.length()-1);
//				log.info(json);
//			}
//			super.reponseWriter(json);
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
