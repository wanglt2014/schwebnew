package com.et59.cus.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsProduct;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.BsUserservice;
import com.et59.cus.domain.entity.ex.BsProductQuery;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.DateUtil;

/**
 * <p>Title: UserServiceAction.java</p>
 * <p>Description: 用户服务</p>
 * <p>Copyright: 59et Software (c) 2011</p>
 * <p>Company: 点滴工作室</p>
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-4-18 上午10:35:02
 * @version 2.0
 *
 */
public class UserServiceAction extends BaseAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 首页
	 * @return
	 */
	public  String index(){
		return "index";
	}
	/**
	 * 分页查询用户服务
	 */
	@SuppressWarnings("rawtypes")
	public void query(){
		String userserviceiccardquery = request.getParameter("userserviceiccardquery");  
		String userIdquery = request.getParameter("userIdquery");
		String page = request.getParameter("page"); // 当前页数  
	    String rows = request.getParameter("rows"); // 每页显示行数  
		try {
			BsUserservice bsUserservice  = new BsUserservice();
			if(null!=userserviceiccardquery&&!userserviceiccardquery.equals("")){
				bsUserservice.setOrderIccard(userserviceiccardquery);
			}
			if(null!=userIdquery&&!userIdquery.equals("")){
				bsUserservice.setUserId(userIdquery);
			}
			Pager pager = new Pager();
			Map map= localServiceProxy.queryUserServiceForPage(bsUserservice,Integer.valueOf(rows),Integer.valueOf(page));
			pager.setTotal((Integer)map.get(Constant.TOTALCOUNT));
			pager.setRows(map.get(Constant.BSUSERSERVICE_LIST));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新用户服务
	 */
	public  void  update(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		BsUserservice bsProductcategory = getBsUserservice();
		try {
			bsProductcategory.setId(Integer.valueOf(id));
			localServiceProxy.updateUserservice(bsProductcategory);
			flag = true;
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			response.getWriter().print(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 新增用户服务
	 */
	public void save(){
		boolean flag =false ;
		BsUserservice bsProductcategory = getBsUserservice();
		try {
			localServiceProxy.saveUserservice(bsProductcategory);
			flag = true;
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			response.getWriter().print(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除用户服务
	 */
	public void delete(){
		boolean flag =false ;
		String id = request.getParameter("id"); 
		try {
			localServiceProxy.deleteUserservice(Integer.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 得到用户服务
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BsUserservice  getBsUserservice(){
		String userId = request.getParameter("userId"); 
		String productCode = request.getParameter("productCode"); 
		String serviceEndTime = request.getParameter("serviceEndTime"); 
		BsUserservice bsUserservice  = new BsUserservice();
		BsUser user = new BsUser();
		user.setUserid(userId);
		try {
			Pager page = localServiceProxy.queryUserListByPage(user,Constant.PAGESIZE,currentPage);
			List<BsUser>  listuser=  (List<BsUser>) page.getRows();
			user = listuser.get(0);
			bsUserservice.setOrderIccard(user.getIccard());
			BsProductQuery product = new BsProductQuery();
			product.setProductCode(productCode);
			Map map = localServiceProxy.queryProductInfoByPage(product,Constant.PAGESIZE,currentPage);
			List<BsProduct>  listproduct=(List<BsProduct>) map.get(Constant.PRODUCT_LIST);
			BsProduct productparam  = new BsProduct();
			productparam=listproduct.get(0);
			bsUserservice.setProductName(productparam.getProductName());
			bsUserservice.setProductPrice(productparam.getProductPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
		bsUserservice.setUserId(userId);
		bsUserservice.setProductCode(productCode);
		bsUserservice.setServiceEndTime(DateUtil.strToDate(serviceEndTime));
		return bsUserservice;
	}
}
