package com.et59.cus.action;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * 
 */
public class AdminAction extends BaseAction {
	private static final Logger log = Logger.getLogger(AdminAction.class);
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 登陆
	 */
	@SuppressWarnings({ "rawtypes" })
	public String dologin() {
		Map<String, Object> session =context.getSession();
		if (log.isDebugEnabled()) {
			log.debug("后台登陆方法!");
		}
		String str ="login";
		BsUser sessionuser = (BsUser) session.get("user");
		//if(null==sessionuser||sessionuser.getIsadmin().equals("no")){
		if(null==sessionuser){
			BsUser userobj = new BsUser();
			try {
				userobj.setUsername(idNumber);
				userobj.setPassword(password);
				userobj.setIsadmin(usertype);
				String randomcode = (String) session.get("RANDOMIMAGES");
				log.info("checkcode|randomcode:"+checkcode+"|"+randomcode);
				//临时注释 验证码
//				if(randomcode.equalsIgnoreCase(checkcode)){
						Map map = localServiceProxy.queryUsername(userobj);
						if (ComonUtil.validateMapResult(map)) {
							BsUser user1 = (BsUser) map.get(Constant.USER);
								log.debug("登录成功");
								//admin用户跳转
//								if(user1.getIsadmin().equals("yes")){
//									str = "adminindex";
//								}else{
//									super.commonquery();
//									String url =(String) session.get("GOTO_URL_KEY");
//									log.info("url:"+url);
//									if(null==url||url.equals("")){
//										response.sendRedirect("index");
//									}else{
//										if(url.contains("OpenApp_index")){
//											response.sendRedirect("OpenApi_index");
//											//response.sendRedirect(url);
//										}else{
//											response.sendRedirect(url);
//										}
//									}
//								}
								str = "adminindex";
								showMessage = "";
								session.put("user", user1);
						} else {
							 log.debug("登陆失败!");
							 showMessage = "用户名或者密码不正确!";
						}
//					}else{
//						showMessage = "验证码不正确!";
//					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			str = "adminindex";
		}
		return str;
	}
	/**
	 * 测试数据加载
	 * 
	 * @return
	 */
	public String login() {
		return "login";
	}
	/**
	 * 退出登陆
	 * 
	 * @return
	 */
	public String logout() {
		if (log.isDebugEnabled()) {
			log.debug("logout 退出。。。");
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("user");
		showMessage = "";
		return "login";
	}
	/**
	 * 得到list的josn数据
	 */
	public void getdatalistjson() {
		String jsonstr = "{\"total\":28,\"rows\":["
				+ "{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"}, "
				+ "{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},"
				+ "{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},"
				+ "{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},"
				+ "{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},"
				+ "{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":158.50,\"attr1\":\"Tailless\",\"itemid\":\"EST-14\"},"
				+ "{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":83.50,\"attr1\":\"With tail\",\"itemid\":\"EST-15\"},"
				+ "{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":23.50,\"attr1\":\"Adult Female\",\"itemid\":\"EST-16\"},"
				+ "{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":89.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-17\"}, "
				+ "{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"}, "
				+ "{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},"
				+ "{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},"
				+ "{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},"
				+ "{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},"
				+ "{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"}, "
				+ "{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},"
				+ "{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},"
				+ "{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":158.50,\"attr1\":\"Tailless\",\"itemid\":\"EST-14\"},"
				+ "{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":83.50,\"attr1\":\"With tail\",\"itemid\":\"EST-15\"},"
				+ "{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":23.50,\"attr1\":\"Adult Female\",\"itemid\":\"EST-16\"},"
				+ "{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":89.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-17\"}, "
				+ "{\"productid\":\"AV-CB-01\",\"productname\":\"Amazon Parrot\",\"unitcost\":92.00,\"status\":\"P\",\"listprice\":63.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-18\"}]}";
			reponseWriter(jsonstr);
		
	}

}
