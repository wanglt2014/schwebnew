package com.et59.cus.action;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.BsUserRole;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.ExportExcel;

/**
 * 用户管理
 * @author liuhaihua
 *
 */
public class UserAction extends BaseAction {
	Logger log = Logger.getLogger(this.getClass());
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户管理
	 * @return
	 */
	public  String  index(){
		return "index";
	}
	/**
	 * 查询用户
	 */
	public  void  query(){
		String usermail = request.getParameter("usermail");
		String isadminquery = request.getParameter("isadminquery");
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		try {
			BsUser user = new BsUser();
			if(null!=usermail&&!usermail.equals("")){
				user.setEmail(usermail);
			}
			if(null!=isadminquery&&!isadminquery.equals("")){
				user.setIsadmin(isadminquery);
			}
			Pager pager = localServiceProxy.queryUserListByPage(user,Integer.valueOf(rows),Integer.valueOf(page));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Title: regUser
	 * @Description: (注册用户)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	public void save() {
		String roleid = request.getParameter("roleid");
		boolean flag = false;
		BsUser param = new BsUser();
		user =getBsUser(param);
		try {
			Map result = localServiceProxy.createUser(user,roleid);
			if (ComonUtil.validateMapResult(result)) {
				flag = true;
			}
			response.getWriter().print(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 编辑用户
	 */
	public   void update(){
		boolean flag = false;
		String id = request.getParameter("id");
		String roleid = request.getParameter("roleid");
		BsUser param = new BsUser();
		try {
			param =localServiceProxy.queryUserByKey(Integer.valueOf(id));
			user = getBsUser(param);
			localServiceProxy.updateUser(user,roleid);
			flag = true;
			response.getWriter().print(flag);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 公用获取参数部分
	 * @param user1
	 * @return
	 */
	public  BsUser   getBsUser(BsUser user1){
		String username = request.getParameter("username");
		String realname = request.getParameter("realname");
		String mobilephone = request.getParameter("mobilephone");
		String email = request.getParameter("email");
		String iccard = request.getParameter("iccard");
		String tokenid = request.getParameter("tokenid");
		String isadmin = request.getParameter("isadmin");
		String password = request.getParameter("password");
		user1.setMobilephone(mobilephone);
		user1.setEmail(email);
		user1.setUserid(ComonUtil.getUserId());
		user1.setPassword(password);
		user1.setUsername(username);
		user1.setIccard(iccard);
		user1.setRealname(realname);
		if(null!=tokenid&&!tokenid.equals("")){
			user1.setTokenid(tokenid);
		}
		user1.setIsadmin(isadmin);
		return user1;
	}
	/**
	 * 删除用户
	 */
	public   void delete(){
		boolean flag = false;
		String id = request.getParameter("id");
		try {
			localServiceProxy.deleteUserBykey(Integer.valueOf(id));
			flag = true;
			response.getWriter().print(flag);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询角色
	 */
	public void queryroleByuserid(){
		String userid = request.getParameter("userid"); 
		try {
			List<BsUserRole>  list =localServiceProxy.queryroleByuserid(userid);
			String json ="";
			if(null!=list&&list.size()>0){
				for(BsUserRole row:list){
					json = json+row.getRoleid()+",";
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
	/**
	 * 导出Excel
	 */
	@SuppressWarnings("unchecked")
	public  void  ExportExcel(){
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		try {
			String usermail=new String(request.getParameter("usermail").getBytes("ISO8859-1"), "UTF-8");  
			String isadminquery=new String(request.getParameter("isadminquery").getBytes("ISO8859-1"), "UTF-8"); 
			BsUser user = new BsUser();
			if(null!=usermail&&!usermail.equals("")){
				user.setEmail(usermail);
			}
			if(null!=isadminquery&&!isadminquery.equals("")){
				user.setIsadmin(isadminquery);
			}
			Pager pager = localServiceProxy.queryUserListByPage(user,Integer.valueOf(rows),Integer.valueOf(page));
			List<BsUser> dataset = (List<BsUser>) pager.getRows();
			String[] hearders = new String[] {"序号","用户编号", "会员卡号", "登陆账号", "真实姓名", "手机号","令牌号", "邮箱","是否为管理员","密码"};//表头数组        
		    ExportExcel<BsUser> ex = new ExportExcel<BsUser>();  
		    SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
		    String filename = timeFormat.format(new Date())+".xls";  
		    response.setContentType("application/ms-excel;charset=UTF-8");  
		    response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));  
		    OutputStream out = response.getOutputStream();  
		    ex.exportExcel(hearders, dataset, out);  
		    out.close();  
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
	}
}
