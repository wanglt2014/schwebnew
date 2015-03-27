package com.et59.cus.action;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.et59.cus.domain.entity.BsArticle;
import com.et59.cus.domain.entity.BsMarking;
import com.et59.cus.domain.entity.BsOrder;
import com.et59.cus.domain.entity.BsProduct;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.BsUserservice;
import com.et59.cus.domain.entity.ex.BsArticleQuery;
import com.et59.cus.domain.entity.ex.BsProductQuery;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.domain.entity.ex.ReturnMsg;
import com.et59.cus.tools.CodeMsgUtil;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.UUIDGenerator;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * <p>
 * Title: MobileAction.java
 * </p>
 * <p>
 * Description: 移动客户端接口
 * </p>
 * <p>
 * Copyright: 59et Software (c) 2011
 * </p>
 * <p>
 * Company: 点滴工作室
 * </p>
 * 
 * @author Liuhh(jxausea@gmail.com)
 * @date 2014-5-4 下午02:03:25
 * @version 2.0
 * 
 */
public class MobileAction extends BaseAction {
	public String client() {
		return "mobile";
	}

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 手机端登陆
	 */
	@SuppressWarnings("rawtypes")
	public void login() {
		ReturnMsg returnMsg = new ReturnMsg();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (ComonUtil.validateEmptyForString(username)) {
			returnMsg.setMsgAndCode(CodeMsgUtil.USERNAME_NULL_CODE,
					CodeMsgUtil.USERNAME_NULL_MSG);
		} else if (ComonUtil.validateEmptyForString(password)) {
			returnMsg.setMsgAndCode(CodeMsgUtil.PASSWORD_NULL_CODE,
					CodeMsgUtil.PASSWORD_NULL_MSG);
		} else {
			BsUser userobj = new BsUser();
			try {
				userobj.setUsername(username);
				userobj.setPassword(password);
				userobj.setIsadmin("no");
				Map map = localServiceProxy.queryUsername(userobj);
				if (ComonUtil.validateMapResult(map)) {
					BsUser user1 = (BsUser) map.get(Constant.USER);
					BsUser sessionuser = (BsUser) BeanUtils.cloneBean(user1);
					getSession().put("user", sessionuser);
					user1.setPassword("******");// 保护密码不被泄露
					returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
							CodeMsgUtil.SUCCESS_MSG, user1);
				} else {
					returnMsg.setMsgAndCode(
							CodeMsgUtil.USERNAMEPAAWORD_ERROR_CODE,
							CodeMsgUtil.USERNAMEPAAWORD_ERROR_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
						CodeMsgUtil.ERROR_MSG);
			}
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 手机端注销
	 */
	public void loginout() {

		ReturnMsg returnMsg = new ReturnMsg();
		try {
			getSession().remove("user");
			returnMsg.setMsgAndCode(CodeMsgUtil.SUCCESS_CODE,
					CodeMsgUtil.SUCCESS_MSG);
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 新闻列表
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void newslist() {
		ReturnMsg returnMsg = new ReturnMsg();
		String newtype = request.getParameter("newtype");// 新闻类型
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			if (ComonUtil.validateEmptyForString(page)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.PAGE_NULL_CODE,
						CodeMsgUtil.PAGE_NULL_MSG);
			} else if (ComonUtil.validateEmptyForString(rows)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.ROWS_NULL_CODE,
						CodeMsgUtil.ROWS_NULL_MSG);
			} else {
				BsArticleQuery bsArticle = new BsArticleQuery();
				if (null != newtype && !newtype.equals("")) {
					bsArticle.setArticletype(newtype);
				}
				Pager pager = new Pager();
				Map map = localServiceProxy
						.queryArticleByTypeForPage(bsArticle,
								Integer.valueOf(rows), Integer.valueOf(page));
				if (ComonUtil.validateMapResult(map)) {
					bsArticlelist = (List<BsArticle>) map
							.get(Constant.ARTICLE_LIST);
					totalCount = (Integer) map.get(Constant.TOTALCOUNT);
					totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
					pager.setTotal(totalCount);
					pager.setRows(bsArticlelist);
					returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
							CodeMsgUtil.SUCCESS_MSG, pager);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 单条新闻
	 */
	public void singlenew() {
		ReturnMsg returnMsg = new ReturnMsg();
		String id = request.getParameter("id");
		if (ComonUtil.validateEmptyForString(id)) {
			returnMsg.setMsgAndCode(CodeMsgUtil.ID_NULL_CODE,
					CodeMsgUtil.ID_NULL_MSG);
		} else {
			try {
				bsArticledetail = localServiceProxy.queryArticleById(Long
						.valueOf(id));
				returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
						CodeMsgUtil.SUCCESS_MSG, bsArticledetail);
			} catch (Exception e) {
				e.printStackTrace();
				returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
						CodeMsgUtil.ERROR_MSG);
			}
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 市场联系人类表
	 */
	public void marketcontact() {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			BsMarking bsMarking = new BsMarking();
			Pager pager = localServiceProxy.queryBsMarkingByPage(bsMarking,
					Integer.valueOf(100), 1);
			@SuppressWarnings("unchecked")
			List<BsMarking> list = (List<BsMarking>) pager.getRows();
			returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
					CodeMsgUtil.SUCCESS_MSG, list);
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 查询个人资料
	 */
	public void userinfo() {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			if (super.isLogin()) {
				BsUser bsUser = (BsUser) getSession().get("user");
				bsUser.setPassword("******");
				returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
						CodeMsgUtil.SUCCESS_MSG, bsUser);
			} else {
				returnMsg.setMsgAndCode(CodeMsgUtil.SESSION_NULL_CODE,
						CodeMsgUtil.SESSION_NULL_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 修改用户信息
	 */
	@SuppressWarnings("rawtypes")
	public void updateuser() {
		String realname = request.getParameter("realname");
		String telphone = request.getParameter("telphone");
		String email = request.getParameter("email");
		String iccard = request.getParameter("iccard");
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			if (super.isLogin()) {
				if (ComonUtil.validateEmptyForString(realname)) {
					returnMsg.setMsgAndCode(CodeMsgUtil.REALNAM_NULL_CODE,
							CodeMsgUtil.REALNAME_NULL_MSG);
				} else if (ComonUtil.validateEmptyForString(telphone)) {
					returnMsg.setMsgAndCode(CodeMsgUtil.TELPHONE_NULL_CODE,
							CodeMsgUtil.TELPHONE_NULL_MSG);
				} else if (ComonUtil.validateEmptyForString(email)) {
					returnMsg.setMsgAndCode(CodeMsgUtil.EMAIL_NULL_CODE,
							CodeMsgUtil.EMAIL_NULL_MSG);
				} else if (ComonUtil.validateEmptyForString(iccard)) {
					returnMsg.setMsgAndCode(CodeMsgUtil.ICCARD_NULL_CODE,
							CodeMsgUtil.ICCARD_NULL_MSG);
				} else {
					user = (BsUser) getSession().get("user");
					user.setEmail(email);
					user.setIccard(iccard);
					user.setMobilephone(telphone);
					user.setRealname(realname);
					Map result = localServiceProxy.updateUser(user, "");
					if (ComonUtil.validateMapResult(result)) {
						// 重置session user
						Map map = localServiceProxy.queryUsername(user);
						if (ComonUtil.validateMapResult(map)) {
							BsUser user1 = (BsUser) map.get(Constant.USER);
							Map<String, Object> session = ActionContext
									.getContext().getSession();
							session.put("user", user1);
						}
						user.setPassword("******");// 保护密码不要被泄露出去
						returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
								CodeMsgUtil.SUCCESS_MSG, user);
					}

				}
			} else {
				returnMsg.setMsgAndCode(CodeMsgUtil.SESSION_NULL_CODE,
						CodeMsgUtil.SESSION_NULL_MSG);
			}

		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 更改密码
	 */
	@SuppressWarnings("rawtypes")
	public void changepwd() {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			if (super.isLogin()) {
				String password = request.getParameter("newpassword");
				String defaultpassword = request.getParameter("defaultpasswd");
				if (ComonUtil.validateEmptyForString(defaultpassword)) {
					returnMsg.setMsgAndCode(CodeMsgUtil.DEFAULTPWD_NUll_CODE,
							CodeMsgUtil.DEFAULTPWD_NULL_MSG);
				} else if (ComonUtil.validateEmptyForString(password)) {
					returnMsg.setMsgAndCode(CodeMsgUtil.PASSWORD_NULL_CODE,
							CodeMsgUtil.PASSWORD_NULL_MSG);
				} else {
					user = (BsUser) getSession().get("user");
					if (user.getPassword().equals(defaultpassword)) {
						user.setPassword(password);
						Map map = localServiceProxy.updateUser(user, "");
						if (ComonUtil.validateMapResult(map)) {
							user.setPassword("******");
							returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
									CodeMsgUtil.SUCCESS_MSG, user);
						} else {
							returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
									CodeMsgUtil.ERROR_MSG);
						}
					} else {
						returnMsg.setMsgAndCode(
								CodeMsgUtil.DEFAULTPWD_NOTSAME_CODE,
								CodeMsgUtil.DEFAULTPWD_NOTSAME_MSG);
					}
				}
			} else {
				returnMsg.setMsgAndCode(CodeMsgUtil.SESSION_NULL_CODE,
						CodeMsgUtil.SESSION_NULL_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 查询订单
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void querytrade() {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			if (super.isLogin()) {
				String page = request.getParameter("page");
				String rows = request.getParameter("rows");
				if (ComonUtil.validateEmptyForString(page)) {
					returnMsg.setMsgAndCode(CodeMsgUtil.PAGE_NULL_CODE,
							CodeMsgUtil.PAGE_NULL_MSG);
				} else if (ComonUtil.validateEmptyForString(rows)) {
					returnMsg.setMsgAndCode(CodeMsgUtil.ROWS_NULL_CODE,
							CodeMsgUtil.ROWS_NULL_MSG);
				} else {
					BsOrder orderobj = new BsOrder();
					orderobj.setUserId(getUser().getUserid());
					Pager pager = new Pager();
					Map map = localServiceProxy.queryOrderForPage(orderobj,
							Integer.valueOf(rows), Integer.valueOf(page));
					if (ComonUtil.validateMapResult(map)) {
						List<BsOrder> orderlist = (List<BsOrder>) map
								.get(Constant.ORDER_LIST);
						totalCount = (Integer) map.get(Constant.TOTALCOUNT);
						pager.setTotal(totalCount);
						pager.setRows(orderlist);
						returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
								CodeMsgUtil.SUCCESS_MSG, pager);
					}
				}
			} else {
				returnMsg.setMsgAndCode(CodeMsgUtil.SESSION_NULL_CODE,
						CodeMsgUtil.SESSION_NULL_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 产品列表
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void productlist() {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			String producttype = request.getParameter("producttype");
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			if (ComonUtil.validateEmptyForString(page)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.PAGE_NULL_CODE,
						CodeMsgUtil.PAGE_NULL_MSG);
			} else if (ComonUtil.validateEmptyForString(rows)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.ROWS_NULL_CODE,
						CodeMsgUtil.ROWS_NULL_MSG);
			} else if (ComonUtil.validateEmptyForString(producttype)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.PRODUCTTYPE_NULL_CODE,
						CodeMsgUtil.PRODUCTTYPE_NULL_MSG);
			} else {
				BsProductQuery product = new BsProductQuery();
				product.setProductcategoryCode(producttype);
				product.setIsactice(Constant.ISACTIVE_YES);
				Map map = localServiceProxy.queryProductInfoByPage(product,
						Integer.valueOf(rows), Integer.valueOf(page));
				if (ComonUtil.validateMapResult(map)) {
					Pager pager = new Pager();
					List<BsProduct> productlist = (List<BsProduct>) map
							.get(Constant.PRODUCT_LIST);
					totalCount = (Integer) map.get(Constant.TOTALCOUNT);
					pager.setTotal(totalCount);
					pager.setRows(productlist);
					returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
							CodeMsgUtil.SUCCESS_MSG, pager);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 产品详细
	 */
	@SuppressWarnings("rawtypes")
	public void productdetail() {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			String id = request.getParameter("id");
			if (ComonUtil.validateEmptyForString(id)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.ID_NULL_CODE,
						CodeMsgUtil.ID_NULL_MSG);
			} else {
				Map map = localServiceProxy.queryProductDetail(Integer
						.valueOf(id));
				if (ComonUtil.validateMapResult(map)) {
					product = (BsProduct) map.get(Constant.PRODUCT_OBJ);
					getSession().put(Constant.PRODUCT_OBJ, product);
					returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
							CodeMsgUtil.SUCCESS_MSG, product);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 创建订单
	 */
	@SuppressWarnings("rawtypes")
	public void createorder() {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			String iccard = request.getParameter("iccard");
			String productnumber = request.getParameter("productnumber");
			String telephone = request.getParameter("telephone");
			if (ComonUtil.validateEmptyForString(iccard)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.ICCARD_NULL_CODE,
						CodeMsgUtil.ICCARD_NULL_MSG);
			} else if (ComonUtil.validateEmptyForString(productnumber)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.PRODUCTNUMBER_NULL_CODE,
						CodeMsgUtil.PRODUCTNUMBER_NULL_MSG);
			} else if (ComonUtil.validateEmptyForString(telephone)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.TELPHONE_NULL_CODE,
						CodeMsgUtil.TELPHONE_NULL_MSG);
			} else {
				product = (BsProduct) getSession().get(Constant.PRODUCT_OBJ);
				BsOrder order1 = new BsOrder();
				order1.setProductNumber(Integer.valueOf(productnumber));
				order1.setOrderTotalPrice(product.getProductPrice().multiply(
						new BigDecimal(productnumber)));
				String orderid = UUIDGenerator.getOrderNo();// 唯一的数据库主键
				order1.setOrderId(orderid);
				order1.setOrderStatus(Constant.ORDER_STATUS_UNPAY);
				order1.setOrderCreateTime(ComonUtil.getDate(0));

				if (null != getUser()) {
					order1.setUserId(String.valueOf(getUser().getUserid()));
				}
				Map map = localServiceProxy.insertOrder(order1);
				if (ComonUtil.validateMapResult(map)) {
					Map map2 = localServiceProxy.queryOrderByorderId(orderid);
					if (ComonUtil.validateMapResult(map2)) {
						order1 = (BsOrder) map2.get(Constant.ORDER_OBJ);
						getSession().put(Constant.ORDER_OBJ, order1);
						returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
								CodeMsgUtil.SUCCESS_MSG, order1);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 更新订单
	 */
	@SuppressWarnings("rawtypes")
	public void updateorder() {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			String orderstatus = request.getParameter("orderstatus");
			String orderid = request.getParameter("orderid");
			if (ComonUtil.validateEmptyForString(orderstatus)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.ORDERSTATUS_NULL_CODE,
						CodeMsgUtil.ORDERSTATUS_NULL_MSG);
			} else if (ComonUtil.validateEmptyForString(orderid)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.ORDERID_NULL_CODE,
						CodeMsgUtil.ORDERID_NULL_MSG);
			} else {
				Map map2 = localServiceProxy.queryOrderByorderId(orderid);
				if (ComonUtil.validateMapResult(map2)) {
					order = (BsOrder) map2.get(Constant.ORDER_OBJ);
					order.setOrderStatus(Integer.valueOf(orderstatus));
					Map map = localServiceProxy.updateOrder(order);
					if (ComonUtil.validateMapResult(map)) {
						returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
								CodeMsgUtil.SUCCESS_MSG, order);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}

	/**
	 * 更具会员卡号查询用户服务
	 */
	@SuppressWarnings("rawtypes")
	public void queryorderbyiccard() {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			String iccard = request.getParameter("iccard");
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			if (ComonUtil.validateEmptyForString(page)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.PAGE_NULL_CODE,
						CodeMsgUtil.PAGE_NULL_MSG);
			} else if (ComonUtil.validateEmptyForString(rows)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.ROWS_NULL_CODE,
						CodeMsgUtil.ROWS_NULL_MSG);
			} else if (ComonUtil.validateEmptyForString(iccard)) {
				returnMsg.setMsgAndCode(CodeMsgUtil.ICCARD_NULL_CODE,
						CodeMsgUtil.ICCARD_NULL_MSG);
			} else {
				BsUserservice bsUserservice = new BsUserservice();
				bsUserservice.setOrderIccard(iccard);
				Map map = localServiceProxy.queryUserServiceForPage(
						bsUserservice, Integer.valueOf(rows),
						Integer.valueOf(page));
				if (ComonUtil.validateMapResult(map)) {
					Pager pager = new Pager();
					List<BsUserservice> userServicelist = (List<BsUserservice>) map
							.get(Constant.BSUSERSERVICE_LIST);
					totalCount = (Integer) map.get(Constant.TOTALCOUNT);
					pager.setTotal(totalCount);
					pager.setRows(userServicelist);
					returnMsg.setAllReturnMsg(CodeMsgUtil.SUCCESS_CODE,
							CodeMsgUtil.SUCCESS_MSG, pager);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setMsgAndCode(CodeMsgUtil.ERROR_CODE,
					CodeMsgUtil.ERROR_MSG);
		}
		reponseWriterMobile(returnMsg);
	}
}
