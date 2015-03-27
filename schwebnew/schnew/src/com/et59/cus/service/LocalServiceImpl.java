package com.et59.cus.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.et59.cus.cache.Cache;
import com.et59.cus.domain.dao.BsAddressDAO;
import com.et59.cus.domain.dao.BsArticleDAO;
import com.et59.cus.domain.dao.BsEmailDAO;
import com.et59.cus.domain.dao.BsLeavemessageDAO;
import com.et59.cus.domain.dao.BsMarkingDAO;
import com.et59.cus.domain.dao.BsMenuDAO;
import com.et59.cus.domain.dao.BsOrderDAO;
import com.et59.cus.domain.dao.BsPagestaticDAO;
import com.et59.cus.domain.dao.BsProductDAO;
import com.et59.cus.domain.dao.BsProductcategoryDAO;
import com.et59.cus.domain.dao.BsResourceDAO;
import com.et59.cus.domain.dao.BsRoleDAO;
import com.et59.cus.domain.dao.BsRoleResourceDAO;
import com.et59.cus.domain.dao.BsSupplierDAO;
import com.et59.cus.domain.dao.BsSystemDAO;
import com.et59.cus.domain.dao.BsUserDAO;
import com.et59.cus.domain.dao.BsUserRoleDAO;
import com.et59.cus.domain.dao.BsUserserviceDAO;
import com.et59.cus.domain.dao.OpenApiDAO;
import com.et59.cus.domain.dao.OpenAppDAO;
import com.et59.cus.domain.dao.OpenLogDAO;
import com.et59.cus.domain.dao.OpenOauthDAO;
import com.et59.cus.domain.dao.TCollegeDAO;
import com.et59.cus.domain.dao.TDictionaryDAO;
import com.et59.cus.domain.dao.TDownloadDAO;
import com.et59.cus.domain.dao.TRoleMenuDAO;
import com.et59.cus.domain.dao.TTeacherDAO;
import com.et59.cus.domain.dao.TjActiontimeDAO;
import com.et59.cus.domain.dao.ex.CommonDAOEx;
import com.et59.cus.domain.entity.BsAddress;
import com.et59.cus.domain.entity.BsAddressExample;
import com.et59.cus.domain.entity.BsArticle;
import com.et59.cus.domain.entity.BsArticleExample;
import com.et59.cus.domain.entity.BsEmail;
import com.et59.cus.domain.entity.BsEmailExample;
import com.et59.cus.domain.entity.BsEmailExample.Criteria;
import com.et59.cus.domain.entity.BsLeavemessage;
import com.et59.cus.domain.entity.BsLeavemessageExample;
import com.et59.cus.domain.entity.BsMarking;
import com.et59.cus.domain.entity.BsMarkingExample;
import com.et59.cus.domain.entity.BsMenu;
import com.et59.cus.domain.entity.BsMenuExample;
import com.et59.cus.domain.entity.BsOrder;
import com.et59.cus.domain.entity.BsOrderExample;
import com.et59.cus.domain.entity.BsPagestatic;
import com.et59.cus.domain.entity.BsPagestaticExample;
import com.et59.cus.domain.entity.BsProduct;
import com.et59.cus.domain.entity.BsProductExample;
import com.et59.cus.domain.entity.BsProductcategory;
import com.et59.cus.domain.entity.BsProductcategoryExample;
import com.et59.cus.domain.entity.BsResource;
import com.et59.cus.domain.entity.BsResourceExample;
import com.et59.cus.domain.entity.BsRole;
import com.et59.cus.domain.entity.BsRoleExample;
import com.et59.cus.domain.entity.BsRoleResource;
import com.et59.cus.domain.entity.BsRoleResourceExample;
import com.et59.cus.domain.entity.BsSupplier;
import com.et59.cus.domain.entity.BsSupplierExample;
import com.et59.cus.domain.entity.BsSystem;
import com.et59.cus.domain.entity.BsSystemExample;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.BsUserExample;
import com.et59.cus.domain.entity.BsUserRole;
import com.et59.cus.domain.entity.BsUserRoleExample;
import com.et59.cus.domain.entity.BsUserservice;
import com.et59.cus.domain.entity.BsUserserviceExample;
import com.et59.cus.domain.entity.OpenApi;
import com.et59.cus.domain.entity.OpenApiExample;
import com.et59.cus.domain.entity.OpenApp;
import com.et59.cus.domain.entity.OpenAppExample;
import com.et59.cus.domain.entity.OpenLog;
import com.et59.cus.domain.entity.OpenLogExample;
import com.et59.cus.domain.entity.OpenOauth;
import com.et59.cus.domain.entity.OpenOauthExample;
import com.et59.cus.domain.entity.TCollege;
import com.et59.cus.domain.entity.TCollegeExample;
import com.et59.cus.domain.entity.TDictionary;
import com.et59.cus.domain.entity.TDictionaryExample;
import com.et59.cus.domain.entity.TRoleMenu;
import com.et59.cus.domain.entity.TRoleMenuExample;
import com.et59.cus.domain.entity.TTeacher;
import com.et59.cus.domain.entity.TTeacherExample;
import com.et59.cus.domain.entity.TjActiontime;
import com.et59.cus.domain.entity.TjActiontimeExample;
import com.et59.cus.domain.entity.ex.BsArticleQuery;
import com.et59.cus.domain.entity.ex.BsEmailquery;
import com.et59.cus.domain.entity.ex.BsProductQuery;
import com.et59.cus.domain.entity.ex.BsProductVo;
import com.et59.cus.domain.entity.ex.Item;
import com.et59.cus.domain.entity.ex.MenuNode;
import com.et59.cus.domain.entity.ex.OpenApiNode;
import com.et59.cus.domain.entity.ex.OpenLogQuery;
import com.et59.cus.domain.entity.ex.OrderVo;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.domain.entity.ex.Shopcart;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.UUIDGenerator;

/**
 * <p>
 * Title: LocalServiceImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 */
public class LocalServiceImpl implements LocalService {
	Logger log = Logger.getLogger(LocalServiceImpl.class);
	@Autowired
	private BsUserDAO userDAO;
	@Autowired
	private BsProductcategoryDAO productcategoryDAO;
	@Autowired
	private CommonDAOEx commonDAOEx;
	@Autowired
	private BsProductDAO productDAO;
	@Autowired
	private BsSupplierDAO supplierDAO;
	@Autowired
	private BsOrderDAO orderDAO;
	@Autowired
	private BsUserserviceDAO bsUserserviceDAO;
	@Autowired
	private BsEmailDAO bsEmailDAO;
	@Autowired
	private BsArticleDAO bsArticleDAO;
	@Autowired
	private BsMenuDAO bsMenuDAO;
	@Autowired
	private BsMarkingDAO bsMarkingDAO;
	@Autowired
	private BsRoleResourceDAO bsRoleResourceDAO;
	@Autowired
	private BsUserRoleDAO bsUserRoleDAO;
	@Autowired
	private BsRoleDAO bsRoleDAO;
	@Autowired
	private BsResourceDAO bsResourceDAO;
	@Autowired
	private OpenApiDAO openApiDAO;
	@Autowired
	private OpenAppDAO openAppDAO;
	@Autowired
	private OpenLogDAO openLogDAO;
	@Autowired
	private OpenOauthDAO openOauthDAO;
	@Autowired
	private BsPagestaticDAO bsPagestaticDAO;
	@Autowired
	private BsLeavemessageDAO bsLeavemessageDAO;
	@Autowired
	private BsSystemDAO bsSystemDAO;
	@Autowired
	private TjActiontimeDAO tjActiontimeDAO;
	@Autowired
	private BsAddressDAO bsAddressDAO;

	@Autowired
	private TCollegeDAO tCollegeDAO;
	@Autowired
	private TRoleMenuDAO tRoleMenuDAO;
	@Autowired
	private TDictionaryDAO tDictionaryDAO;
	@Autowired
	private TTeacherDAO tTeacherDAO;

	@Autowired
	private TDownloadDAO tdownloadDAO;

	/**
	 * 查询用户信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map queryUsername(BsUser user) throws Exception {
		Map map = new HashMap();
		if (ComonUtil.validateEmptyForString(user.getUsername())) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			throw new Exception("用户名字为空!");
		} else {
			BsUserExample example = new BsUserExample();
			example.createCriteria().andUsernameEqualTo(user.getUsername())
					.andPasswordEqualTo(user.getPassword())
					.andIsadminEqualTo(user.getIsadmin());
			List<BsUser> list = userDAO.selectByExample(example);
			if (null != list && list.size() == 1) {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面存在该用户，校验成功");
				}
				map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
				map.put(Constant.USER, list.get(0));
			} else {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面不存在该用户，校验失败");
				}
				map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			}
		}
		return map;
	}

	/**
	 * 修改用户会员卡号
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map updateUser(BsUser user, String roleid) throws Exception {
		Map map = new HashMap();
		int aa = userDAO.updateByPrimaryKey(user);
		// 删除
		BsUserRoleExample example = new BsUserRoleExample();
		example.createCriteria().andUseridEqualTo(user.getUserid());
		bsUserRoleDAO.deleteByExample(example);
		// 添加
		String[] roleidarray = roleid.split(",");
		for (int i = 0; i < roleidarray.length; i++) {
			if (!roleidarray[i].equals("")) {
				BsUserRole bsUserRole = new BsUserRole();
				bsUserRole.setRoleid(Integer.valueOf(roleidarray[i]));
				bsUserRole.setUserid(user.getUserid());
				bsUserRoleDAO.insert(bsUserRole);
			}
		}
		if (aa == 1) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
			if (log.isDebugEnabled()) {
				log.debug("修改用户信息成功!");
			}
		} else if (aa > 1) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			if (log.isDebugEnabled()) {
				log.debug("修改多条用户信息");
			}
		} else {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			if (log.isDebugEnabled()) {
				log.debug("修改用户信息失败");
			}
		}
		return map;
	}

	/***
	 * 查询产品信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map queryProductInfoByPage(BsProductQuery product, int pagesize,
			int currentpage) throws Exception {
		Map map = new HashMap();
		BsProductExample pe = new BsProductExample();
		com.et59.cus.domain.entity.BsProductExample.Criteria criteria = pe
				.createCriteria();
		pe.setOrderByClause(" createdate desc ");
		if (null != product.getIsactice() && !product.getIsactice().equals("")) {
			criteria.andIsacticeEqualTo(product.getIsactice());
		}
		if (null != product.getStartcreatetime()
				&& null == product.getEndcreatetime()) {
			criteria.andCreatedateGreaterThan(product.getStartcreatetime());
		} else if (null != product.getStartcreatetime()
				&& null != product.getEndcreatetime()) {
			criteria.andCreatedateBetween(product.getStartcreatetime(),
					product.getEndcreatetime());
		} else if (null == product.getStartcreatetime()
				&& null != product.getEndcreatetime()) {
			criteria.andCreatedateLessThan(product.getEndcreatetime());
		}
		if (null != product.getProductName()) {
			criteria.andProductNameLike("%" + product.getProductName() + "%");
		}
		if (null != product.getSupplierCode()) {
			criteria.andSupplierCodeEqualTo(product.getSupplierCode());
		}
		if (null != product.getProductcategoryCode()) {
			criteria.andProductcategoryCodeEqualTo(product
					.getProductcategoryCode());
		}
		if (null != product.getProductCode()) {
			criteria.andProductCodeEqualTo(product.getProductCode());
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsProduct> list = commonDAOEx.queryProductForListByPage(pe,
				startrecord, pagesize);
		int totalCount = productDAO.countByExample(pe);
		map.put(Constant.TOTALCOUNT, totalCount);
		map.put(Constant.TOTALPAGECOUNT,
				ComonUtil.computusTotalPage(totalCount, pagesize));
		map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		map.put(Constant.PRODUCT_LIST, list);
		return map;
	}

	/**
	 * 查询用户详细信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map queryProductDetail(int id) throws Exception {
		Map map = new HashMap();
		BsProduct product = productDAO.selectByPrimaryKey(id);
		if (null != product) {
			if (log.isDebugEnabled()) {
				log.debug("查询产品详情成功!");
			}
			map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
			map.put(Constant.PRODUCT_OBJ, product);
		} else {
			if (log.isDebugEnabled()) {
				log.debug("查询产品详情结果为空!");
			}
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
		}
		return map;
	}

	/**
	 * 保存订单状态
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map insertOrder(BsOrder order) throws Exception {
		Map map = new HashMap();
		orderDAO.insert(order);
		map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		return map;
	}

	/***
	 * 更新订单
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map updateOrder(BsOrder order) throws Exception {
		Map map = new HashMap();
		int sss = orderDAO.updateByPrimaryKeySelective(order);
		if (sss > 0) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		} else {
			if (log.isDebugEnabled()) {
				log.debug("更新订单失败!");
			}
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
		}
		return map;
	}

	/**
	 * 分页查询
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map queryOrderForPage(BsOrder order, int pagesize, int currentpage)
			throws Exception {
		Map map = new HashMap();
		BsOrderExample bo = new BsOrderExample();
		com.et59.cus.domain.entity.BsOrderExample.Criteria criteria = bo
				.createCriteria();
		if (null != order.getUserId() && !order.getUserId().equals("")) {
			criteria.andUserIdEqualTo(order.getUserId());
		}
		if (!StringUtils.isEmpty(order.getOrderId())) {
			criteria.andOrderIdEqualTo(order.getOrderId());
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsOrder> list = commonDAOEx.queryOrderForListByPage(bo,
				startrecord, pagesize);
		int totalCount = orderDAO.countByExample(bo);
		map.put(Constant.TOTALCOUNT, totalCount);
		map.put(Constant.TOTALPAGECOUNT,
				ComonUtil.computusTotalPage(totalCount, pagesize));
		map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		map.put(Constant.ORDER_LIST, list);

		return map;
	}

	/**
	 * 查询订单号通过订单
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map queryOrderByorderId(String orderid) throws Exception {
		Map map = new HashMap();
		if (null == orderid) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			throw new Exception("用户编号为空!");
		} else {
			BsOrderExample example = new BsOrderExample();
			example.createCriteria().andOrderIdEqualTo(orderid);
			BsOrder order = new BsOrder();
			List<BsOrder> list = orderDAO.selectByExample(example);
			if (null != list && list.size() > 0) {
				order = list.get(0);
				map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
				map.put(Constant.ORDER_OBJ, order);
			} else {
				map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			}
		}
		return map;
	}

	/**
	 * 创建用户
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map createUser(BsUser user, String roleid) throws Exception {
		Map map = new HashMap();
		if (null == user) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			throw new Exception("用户编号为空!");
		} else {
			BsUserExample example = new BsUserExample();
			example.createCriteria().andEmailEqualTo(user.getEmail());
			List<BsUser> list = userDAO.selectByExample(example);
			if (null == list || list.size() == 0) {
				userDAO.insert(user);
				List<BsUser> userlist = userDAO.selectByExample(example);
				String[] roleidarray = roleid.split(",");
				for (int i = 0; i < roleidarray.length; i++) {
					if (!roleidarray[i].equals("")) {
						BsUserRole bsUserRole = new BsUserRole();
						bsUserRole.setRoleid(Integer.valueOf(roleidarray[i]));
						bsUserRole.setUserid(userlist.get(0).getUserid());
						bsUserRoleDAO.insert(bsUserRole);
					}
				}
				map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
			} else {
				map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
				throw new Exception("注册用户失败!");
			}

		}
		return map;
	}

	/**
	 * 通过令牌号查找用户信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map queryUserByTokenId(BsUser user) throws Exception {
		Map map = new HashMap();
		if (ComonUtil.validateEmptyForString(user.getTokenid())) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			throw new Exception("TokeID(令牌号)为空!");
		} else {
			BsUserExample example = new BsUserExample();
			example.createCriteria().andTokenidEqualTo(user.getTokenid());
			List<BsUser> list = userDAO.selectByExample(example);
			if (null != list && list.size() == 1) {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面存在该令牌号，校验成功");
				}
				map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
				map.put(Constant.USER, list.get(0));
			} else {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面不存在令牌号，校验失败");
				}
				map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			}
		}
		return map;
	}

	/***
	 * 插入用户订购的服务
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map insertUserService(BsUserservice bsUserservice) throws Exception {
		Map map = new HashMap();
		bsUserserviceDAO.insert(bsUserservice);
		map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		return map;
	}

	/**
	 * 查询用户订购的服务
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map queryUserServiceByPrimaryKey(BsUserservice bsUserservice)
			throws Exception {
		Map map = new HashMap();
		if (ComonUtil.validateEmptyForString(bsUserservice.getOrderIccard())) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			throw new Exception("iccard不能为空!");
		}
		if (ComonUtil.validateEmptyForString(bsUserservice.getProductCode())) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			throw new Exception("产品代码不能为空!");
		}
		BsUserserviceExample bse = new BsUserserviceExample();
		bse.createCriteria()
				.andOrderIccardEqualTo(bsUserservice.getOrderIccard())
				.andProductCodeEqualTo(bsUserservice.getProductCode());
		// BsUserservice aaa =
		// bsUserserviceDAO.selectByPrimaryKey(bsUserservice.getOrderIccard(),
		// bsUserservice.getProductCode());
		List<BsUserservice> aaa = bsUserserviceDAO.selectByExample(bse);
		if (null != aaa && aaa.size() > 0) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
			map.put(Constant.BSUSERSERVICE_OBJ, aaa.get(0));
		} else {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
		}
		return map;
	}

	/**
	 * 更新用户服务
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map updateUserService(BsUserservice bsUserservice) throws Exception {
		Map map = new HashMap();
		int sss = bsUserserviceDAO.updateByPrimaryKeySelective(bsUserservice);
		if (sss > 0) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		} else {
			if (log.isDebugEnabled()) {
				log.debug("更新用户订购服务失败!");
			}
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
		}
		return map;
	}

	/**
	 * 查询用户订购服务
	 * 
	 * @param order
	 * @param pagesize
	 * @param currentpage
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map queryUserServiceForPage(BsUserservice bsUserservice,
			int pagesize, int currentpage) throws Exception {
		Map map = new HashMap();
		BsUserserviceExample be = new BsUserserviceExample();
		com.et59.cus.domain.entity.BsUserserviceExample.Criteria criteria = be
				.createCriteria();
		if (null != bsUserservice.getOrderIccard()
				&& !bsUserservice.getOrderIccard().equals("")) {
			criteria.andOrderIccardEqualTo(bsUserservice.getOrderIccard());
		}
		if (null != bsUserservice.getUserId()) {
			criteria.andUserIdEqualTo(bsUserservice.getUserId());
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsUserservice> list = commonDAOEx.queryUserServiceForListByPage(
				be, startrecord, pagesize);
		int totalCount = bsUserserviceDAO.countByExample(be);
		map.put(Constant.TOTALCOUNT, totalCount);
		map.put(Constant.TOTALPAGECOUNT,
				ComonUtil.computusTotalPage(totalCount, pagesize));
		map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		map.put(Constant.BSUSERSERVICE_LIST, list);
		return map;
	}

	/**
	 * 查询数据库是否存在该邮箱
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map queryUserbyEmail(BsUser user) throws Exception {
		Map map = new HashMap();
		if (ComonUtil.validateEmptyForString(user.getEmail())) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			throw new Exception("用户邮箱为空!");
		} else {
			BsUserExample example = new BsUserExample();
			example.createCriteria().andEmailEqualTo(user.getEmail());
			List<BsUser> list = userDAO.selectByExample(example);
			if (null != list && list.size() == 1) {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面存在该邮箱，校验成功");
				}
				map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
				map.put(Constant.USER, list.get(0));
			} else {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面不存在该邮箱，校验失败");
				}
				map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			}
		}
		return map;
	}

	/**
	 * 插入邮件
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map insertEmail(BsEmail bsEmail) throws Exception {
		Map map = new HashMap();
		bsEmailDAO.insert(bsEmail);
		map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		return map;
	}

	/**
	 * 查询邮件
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map queryEmail(BsEmail bsEmail) throws Exception {
		Map map = new HashMap();
		if (ComonUtil.validateEmptyForString(bsEmail.getMailto())) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			throw new Exception("邮箱为空!");
		} else if (ComonUtil.validateEmptyForString(bsEmail.getCode())) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			throw new Exception("code为空!");
		} else {
			BsEmailExample example = new BsEmailExample();
			example.createCriteria().andCodeEqualTo(bsEmail.getCode())
					.andMailtoEqualTo(bsEmail.getMailto())
					.andIsactiveEqualTo(Constant.ISACTIVE_NO);
			List<BsEmail> list = bsEmailDAO.selectByExample(example);
			if (null != list && list.size() == 1) {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面存在该邮件，校验成功");
				}
				map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
				map.put(Constant.EMAIL, list.get(0));
			} else {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面不存在该邮件，校验失败");
				}
				map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
			}
		}
		return map;
	}

	/**
	 * 更新邮件
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map updateEmail(BsEmail bsEmail) throws Exception {
		Map map = new HashMap();
		int sss = bsEmailDAO.updateByPrimaryKeySelective(bsEmail);
		if (sss > 0) {
			map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		} else {
			if (log.isDebugEnabled()) {
				log.debug("更新邮件失败!");
			}
			map.put(Constant.ACTION_RESULT, Constant.RESULT_FAIL);
		}
		return map;
	}

	/**
	 * 按文章分类查询 (分页)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map queryArticleByTypeForPage(BsArticleQuery bsArticle,
			int pagesize, int currentpage) throws Exception {
		Map map = new HashMap();
		BsArticleExample bae = new BsArticleExample();
		com.et59.cus.domain.entity.BsArticleExample.Criteria criteria = bae
				.createCriteria();
		bae.setOrderByClause(" createdate desc ");
		if (null != bsArticle.getArticletype()
				&& !bsArticle.getArticletype().equals("")) {
			criteria.andArticletypeEqualTo(bsArticle.getArticletype());
		} else {
			// 只查询通知和制度
			List typeList = new ArrayList();
			String menuType = bsArticle.getMenuType();
			typeList.add(Constant.ARTICLE_TYPE_NOTICE);
			typeList.add(Constant.ARTICLE_TYPE_REGULATION);
			if (menuType != null && "result".equals(menuType)) {
				criteria.andArticletypeNotIn(typeList);
			}
			// else {
			// criteria.andArticletypeIn(typeList);
			// }
		}
		// if (null != bsArticle.getStartdatacreatenew()
		// && null == bsArticle.getEnddatacreatenew()) {
		// criteria.andCreatedateGreaterThan(bsArticle.getStartdatacreatenew());
		// } else if (null != bsArticle.getStartdatacreatenew()
		// && null != bsArticle.getEnddatacreatenew()) {
		// criteria.andCreatedateBetween(bsArticle.getStartdatacreatenew(),
		// bsArticle.getEnddatacreatenew());
		// } else if (null == bsArticle.getStartdatacreatenew()
		// && null != bsArticle.getEnddatacreatenew()) {
		// criteria.andCreatedateLessThan(bsArticle.getEnddatacreatenew());
		// }
		if (null != bsArticle.getAuthor()) {
			criteria.andAuthorLike("%" + bsArticle.getAuthor() + "%");
		}
		if (null != bsArticle.getArticletitle()) {
			criteria.andArticletitleLike("%" + bsArticle.getArticletitle()
					+ "%");
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsArticle> list = commonDAOEx.queryArticleByTypeForPage(bae,
				startrecord, pagesize);
		int totalCount = bsArticleDAO.countByExample(bae);
		map.put(Constant.TOTALCOUNT, totalCount);
		map.put(Constant.TOTALPAGECOUNT,
				ComonUtil.computusTotalPage(totalCount, pagesize));
		map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		map.put(Constant.ARTICLE_LIST, list);
		return map;
	}

	/**
	 * 查询文章byid
	 */
	@Override
	public BsArticle queryArticleById(long id) throws Exception {
		BsArticle article = new BsArticle();
		if (id == 0) {
			throw new Exception("id错误!");
		} else {
			article = bsArticleDAO.selectByPrimaryKey(id);
			if (null != article) {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面存在该文章！");
				}
			} else {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面不存在该文章，校验失败");
				}
			}
		}
		return article;
	}

	/**
	 * 得到菜单的json串 构造多叉树来实现一次加载多级所有的菜单
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public String getMenuJsonstr(BsUser user) throws Exception {
		BsMenuExample example = new BsMenuExample();
		example.setOrderByClause(" menulevel  desc ,menuorder  desc ");
		// 修改
		// List<BsMenu> dataList = bsMenuDAO.selectByExample(example);
		HashMap map = new HashMap();
		map.put("userId", user.getUserid());
		List<BsMenu> dataList = null;
		if (user.getIsadmin().equals("no")) {
			dataList = bsMenuDAO.selectByExampleByUserid(example, map);
		} else {
			dataList = bsMenuDAO.selectByExample(example);
		}

		// 节点列表（散列表，用于临时存储节点对象）
		HashMap<Integer, MenuNode> nodeList = new HashMap<Integer, MenuNode>();
		// 根节点
		MenuNode root = null;
		if (dataList != null || dataList.size() > 0) {
			// 根据结果集构造节点列表（存入散列表）
			for (BsMenu dataRecord : dataList) {
				MenuNode node = new MenuNode();
				node.setId(dataRecord.getId());
				BeanUtils.copyProperties(dataRecord, node);
				nodeList.put(node.getId().intValue(), node);
			}
			// 构造无序的多叉树
			Set entrySet = nodeList.entrySet();
			for (Iterator it = entrySet.iterator(); it.hasNext();) {
				MenuNode node = (MenuNode) ((Map.Entry) it.next()).getValue();
				if (node.getMenuparent() == null
						|| node.getMenuparent().equals("")
						|| node.getMenuparent().equals(0)) {
					root = node;
				} else {
					((MenuNode) nodeList.get(node.getMenuparent()))
							.getChildren().add(node);
				}
			}
		}

		String json = JSON.toJSONString(root);
		return "[" + json + "]";
	}

	/**
	 * 更新菜单或者添加菜单
	 */
	@Override
	public void updateOrAddMenu(BsMenu bsMenu) throws Exception {
		if (null == bsMenu.getId() || bsMenu.getId() == 0) {
			bsMenu.setId(null);
			bsMenuDAO.insert(bsMenu);
		} else {
			bsMenuDAO.updateByPrimaryKey(bsMenu);
		}
	}

	/**
	 * 递归删除菜单
	 */
	@Override
	public void deleteMenu(long id) throws Exception {
		BsMenuExample example = new BsMenuExample();
		example.createCriteria().andMenuparentEqualTo((int) id);
		List<BsMenu> list = bsMenuDAO.selectByExample(example);
		for (BsMenu obj : list) {
			deleteMenu(obj.getId());
			bsMenuDAO.deleteByPrimaryKey(obj.getId());
		}
		bsMenuDAO.deleteByPrimaryKey(id);
	}

	/**
	 * 查询邮件
	 */
	@Override
	public Pager queryEmailJsonForpage(BsEmailquery bsemail, int pagesize,
			int currentpage) throws Exception {
		BsEmailExample example = new BsEmailExample();
		Criteria criteria = example.createCriteria();
		Pager page = new Pager();
		if (null != bsemail.getStartdate() && null == bsemail.getEnddate()) {
			criteria.andCreatetimeGreaterThanOrEqualTo(bsemail.getStartdate());
		} else if (null != bsemail.getStartdate()
				&& null != bsemail.getEnddate()) {
			criteria.andCreatetimeBetween(bsemail.getStartdate(),
					bsemail.getEnddate());
		} else if (null == bsemail.getStartdate()
				&& null != bsemail.getEnddate()) {
			criteria.andCreatetimeLessThanOrEqualTo(bsemail.getEnddate());
		}
		if (null != bsemail.getIsactive()) {
			criteria.andIsactiveEqualTo(bsemail.getIsactive());
		}
		if (null != bsemail.getMailto()) {
			criteria.andMailtoLike("%" + bsemail.getMailto() + "%");
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsEmail> list = commonDAOEx.selectEmailByExampleForPage(example,
				startrecord, pagesize);
		int totalCount = bsEmailDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		// String json =JSON.toJSONString(list);
		return page;
	}

	/**
	 * 通过id查询邮件
	 */
	@Override
	public BsEmail queryEmailByIdJson(long id) throws Exception {
		BsEmail email = new BsEmail();
		email = bsEmailDAO.selectByPrimaryKey(id);
		return email;
	}

	/**
	 * 分页查询用户信息
	 */
	@Override
	public Pager queryUserListByPage(BsUser user, int pagesize, int currentpage)
			throws Exception {
		Pager page = new Pager();
		BsUserExample example = new BsUserExample();
		com.et59.cus.domain.entity.BsUserExample.Criteria criteria = example
				.createCriteria();
		int startrecord = (currentpage - 1) * pagesize;
		if (null != user.getEmail()) {
			criteria.andEmailLike("%" + user.getEmail() + "%");
		}
		if (null != user.getIsadmin()) {
			criteria.andIsadminEqualTo(user.getIsadmin());
		}
		if (null != user.getUserid() && !user.getUserid().equals("")) {
			criteria.andUseridEqualTo(user.getUserid());
		}
		List<BsUser> list = commonDAOEx.selectUserByExampleForPage(example,
				startrecord, pagesize);
		int totalCount = userDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 查询用户通过主键
	 */
	@Override
	public BsUser queryUserByKey(int id) throws Exception {
		return userDAO.selectByPrimaryKey(id);
	}

	/**
	 * 删除用户
	 */
	@Override
	public void deleteUserBykey(int id) throws Exception {
		userDAO.deleteByPrimaryKey(id);
		BsUserRoleExample example = new BsUserRoleExample();
		example.createCriteria().andUseridEqualTo(String.valueOf(id));
		bsUserRoleDAO.deleteByExample(example);
	}

	/**
	 * 保存文章
	 */
	@Override
	public void saveArticle(BsArticle bsArticle) throws Exception {
		bsArticleDAO.insert(bsArticle);
	}

	/**
	 * 编辑文章
	 */
	@Override
	public void updateArticle(BsArticle bsArticle) throws Exception {
		bsArticleDAO.updateByPrimaryKeySelective(bsArticle);
	}

	/**
	 * 删除文章
	 */
	@Override
	public void deleteArticle(long id) throws Exception {
		// 删除关联表和文件表
		try {
			BsArticle bsArticle = bsArticleDAO.selectByPrimaryKey(id);
			Long downloadId = bsArticle.getDownloadid();
			if (downloadId != null) {
				tdownloadDAO.deleteByPrimaryKey(downloadId);
			}

			bsArticleDAO.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 分页查询供应商
	 */
	@Override
	public Pager querySupplierByPage(BsSupplier bsSupplier, int pagesize,
			int currentpage) throws Exception {
		Pager page = new Pager();
		BsSupplierExample example = new BsSupplierExample();
		com.et59.cus.domain.entity.BsSupplierExample.Criteria criteria = example
				.createCriteria();
		if (null != bsSupplier.getSupplierName()) {
			criteria.andSupplierNameLike("%" + bsSupplier.getSupplierName()
					+ "%");
		}
		if (null != bsSupplier.getContactname()) {
			criteria.andContactnameLike("%" + bsSupplier.getContactname() + "%");
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsSupplier> list = commonDAOEx.selectBsSupplierByExampleForPage(
				example, startrecord, pagesize);
		int totalCount = supplierDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 返回供应商名字
	 */
	public String querySupplierNameByCode(String code) throws Exception {
		BsSupplierExample example = new BsSupplierExample();
		example.createCriteria().andSupplierCodeEqualTo(code);
		List<BsSupplier> list = supplierDAO.selectByExample(example);
		if (null == list || list.size() == 0) {
			return code;
		} else {
			return list.get(0).getSupplierName();
		}

	}

	/**
	 * 删除供应商
	 */
	@Override
	public void deleteSupplier(int id) throws Exception {
		supplierDAO.deleteByPrimaryKey(id);

	}

	/**
	 * 保存供应商
	 * 
	 * @param bsSupplier
	 * @throws Exception
	 */
	@Override
	public void saveSupplier(BsSupplier bsSupplier) throws Exception {
		supplierDAO.insert(bsSupplier);
	}

	/**
	 * 更新供应商
	 */
	@Override
	public void udateSupplier(BsSupplier bsSupplier) throws Exception {
		supplierDAO.updateByPrimaryKey(bsSupplier);
	}

	/**
	 * 分类查询分类
	 */
	@Override
	public Pager queryProductcategoryBypage(
			BsProductcategory bsProductcategory, int pagesize, int currentpage)
			throws Exception {
		Pager page = new Pager();
		BsProductcategoryExample example = new BsProductcategoryExample();
		com.et59.cus.domain.entity.BsProductcategoryExample.Criteria criteria = example
				.createCriteria();
		if (null != bsProductcategory.getProductcategoryName()) {
			criteria.andProductcategoryNameLike("%"
					+ bsProductcategory.getProductcategoryName() + "%");
		}
		if (null != bsProductcategory.getSupplierCode()) {
			criteria.andSupplierCodeEqualTo(bsProductcategory.getSupplierCode());
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsProductcategory> list = commonDAOEx
				.selectBsProductcategoryForPage(example, startrecord, pagesize);
		int totalCount = productcategoryDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 删除分类
	 */
	@Override
	public void deleteBsProductcategory(int id) throws Exception {
		productcategoryDAO.deleteByPrimaryKey(id);
	}

	/**
	 * 保存分类
	 */
	@Override
	public void saveBsProductcategory(BsProductcategory bsProductcategory)
			throws Exception {
		productcategoryDAO.insert(bsProductcategory);
	}

	/**
	 * 更新分类
	 */
	@Override
	public void udateBsProductcategory(BsProductcategory bsProductcategory)
			throws Exception {
		productcategoryDAO.updateByPrimaryKey(bsProductcategory);
	}

	/**
	 * 查询产品分类名称
	 */
	@Override
	public String queryBsProductcategoryByCode(String code) throws Exception {
		BsProductcategoryExample example = new BsProductcategoryExample();
		example.createCriteria().andProductcategoryCodeEqualTo(code);
		List<BsProductcategory> list = productcategoryDAO
				.selectByExample(example);
		if (null == list || list.size() == 0) {
			return code;
		} else {
			return list.get(0).getProductcategoryName();
		}
	}

	/**
	 * 删除产品
	 */
	@Override
	public void deleteBsProduct(int id) throws Exception {
		productDAO.deleteByPrimaryKey(id);
	}

	/**
	 * 添加产品
	 */
	@Override
	public void saveBsProduct(BsProduct bsProduct) throws Exception {
		productDAO.insert(bsProduct);
	}

	/**
	 * 更新产品
	 */
	@Override
	public void udateBsProduct(BsProduct bsProduct) throws Exception {
		productDAO.updateByPrimaryKey(bsProduct);
	}

	/**
	 * 删除用户服务
	 */
	@Override
	public void deleteUserservice(int id) throws Exception {
		bsUserserviceDAO.deleteByPrimaryKey(id);
	}

	/**
	 * 保存服务
	 */
	@Override
	public void saveUserservice(BsUserservice bsUserservice) throws Exception {
		bsUserserviceDAO.insert(bsUserservice);

	}

	/**
	 * 修改服务
	 */
	@Override
	public void updateUserservice(BsUserservice bsUserservice) throws Exception {
		bsUserserviceDAO.updateByPrimaryKey(bsUserservice);
	}

	/**
	 * 删除订单
	 */
	@Override
	public void deleteOrder(int id) throws Exception {
		orderDAO.deleteByPrimaryKey(id);
	}

	/**
	 * 分页查询市场销售
	 */
	@Override
	public Pager queryBsMarkingByPage(BsMarking bsMarking, int pagesize,
			int currentpage) throws Exception {
		Pager page = new Pager();
		BsMarkingExample example = new BsMarkingExample();
		com.et59.cus.domain.entity.BsMarkingExample.Criteria criteria = example
				.createCriteria();
		if (null != bsMarking.getSaleName()
				&& !bsMarking.getSaleName().equals("")) {
			criteria.andSaleNameLike("%" + bsMarking.getSaleName() + "%");
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsMarking> list = commonDAOEx.selectBsMarkingForPage(example,
				startrecord, pagesize);
		int totalCount = bsMarkingDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 删除市场
	 */
	@Override
	public void deleteBsMarking(int id) throws Exception {
		bsMarkingDAO.deleteByPrimaryKey(id);
	}

	/**
	 * 保存
	 */
	@Override
	public void saveBsMarking(BsMarking bsMarking) throws Exception {
		bsMarkingDAO.insert(bsMarking);

	}

	/**
	 * 更新
	 */

	@Override
	public void updateBsMarking(BsMarking bsMarking) throws Exception {
		bsMarkingDAO.updateByPrimaryKey(bsMarking);
	}

	/**
	 * 更具用户查询拥有的权限 用户权限=公共资源+受保护的资源+授权的资源
	 */
	@Override
	public List<BsResource> queryResourcebyuserId(String userid)
			throws Exception {
		List<BsResource> alllist = new ArrayList<BsResource>();
		try {
			alllist.clear();
			// 查询公共资源
			BsResourceExample example = new BsResourceExample();
			com.et59.cus.domain.entity.BsResourceExample.Criteria criteria = example
					.createCriteria();
			criteria.andResourceTypeEqualTo(Constant.RESOURCE_PUBLIC);
			List<BsResource> publiclist = bsResourceDAO
					.selectByExample(example);
			alllist.addAll(publiclist);

			// 查询资源
			if (null != userid) {
				// 受保护的资源
				BsResourceExample protectexample = new BsResourceExample();
				com.et59.cus.domain.entity.BsResourceExample.Criteria protectecriteria = protectexample
						.createCriteria();
				protectecriteria
						.andResourceTypeEqualTo(Constant.RESOURCE_PROTECT);
				List<BsResource> protectlist = bsResourceDAO
						.selectByExample(protectexample);
				alllist.addAll(protectlist);
				// 私有资源
				BsUserRoleExample bre = new BsUserRoleExample();
				bre.createCriteria().andUseridEqualTo(userid);
				List<BsUserRole> userrolelist = bsUserRoleDAO
						.selectByExample(bre);
				List<Integer> roleidlist = new ArrayList<Integer>();
				roleidlist.clear();
				for (BsUserRole bsUserRole : userrolelist) {
					roleidlist.add(bsUserRole.getRoleid());
				}
				if (null != roleidlist && roleidlist.size() > 0) {
					BsRoleResourceExample bbre = new BsRoleResourceExample();
					bbre.createCriteria().andRoleidIn(roleidlist);
					List<BsRoleResource> bsRoleResourcelist = bsRoleResourceDAO
							.selectByExample(bbre);

					for (BsRoleResource bsRoleResource : bsRoleResourcelist) {
						BsResource bsResource = bsResourceDAO
								.selectByPrimaryKey(bsRoleResource
										.getResourceid());
						alllist.add(bsResource);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alllist;
	}

	/**
	 * 查询资源分页
	 */
	@Override
	public Pager queryBsResourceByPage(BsResource bsResource, int pagesize,
			int currentpage) throws Exception {
		Pager page = new Pager();
		BsResourceExample example = new BsResourceExample();
		com.et59.cus.domain.entity.BsResourceExample.Criteria criteria = example
				.createCriteria();
		if (null != bsResource.getResourceUrl()
				&& !bsResource.getResourceUrl().equals("")) {
			criteria.andResourceUrlLike("%" + bsResource.getResourceUrl() + "%");
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsResource> list = commonDAOEx.selectBsResourceForPage(example,
				startrecord, pagesize);
		int totalCount = bsResourceDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteBsResource(int id) throws Exception {
		bsResourceDAO.deleteByPrimaryKey(id);
	}

	/**
	 * 添加资源
	 */
	@Override
	public void saveBsResource(BsResource bsResource) throws Exception {
		bsResourceDAO.insert(bsResource);

	}

	/**
	 * 更新资源
	 */
	@Override
	public void updateBsResource(BsResource bsResource) throws Exception {
		bsResourceDAO.updateByPrimaryKey(bsResource);

	}

	/**
	 * 分页查询
	 */
	@Override
	public Pager queryBsRoleByPage(BsRole bsRole, int pagesize, int currentpage)
			throws Exception {
		Pager page = new Pager();
		BsRoleExample example = new BsRoleExample();
		com.et59.cus.domain.entity.BsRoleExample.Criteria criteria = example
				.createCriteria();
		if (null != bsRole.getName() && !bsRole.getName().equals("")) {
			criteria.andNameLike("%" + bsRole.getName() + "%");
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsRole> list = commonDAOEx.selectBsRoleForPage(example,
				startrecord, pagesize);
		int totalCount = bsRoleDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 删除角色
	 */
	@Override
	public void deleteBsRole(int id) throws Exception {
		bsRoleDAO.deleteByPrimaryKey(id);
		TRoleMenuExample example = new TRoleMenuExample();
		example.createCriteria().andRoleidEqualTo(id);
		tRoleMenuDAO.deleteByExample(example);
	}

	/**
	 * 插入角色
	 */
	@Override
	public void saveBsRole(BsRole bsRole, String menuid) throws Exception {
		bsRoleDAO.insert(bsRole);
		BsRoleExample example = new BsRoleExample();
		example.createCriteria().andIsactiveEqualTo(bsRole.getIsactive())
				.andNameEqualTo(bsRole.getName());
		List<BsRole> bsRoleparam = bsRoleDAO.selectByExample(example);
		TRoleMenu tRoleMenu = new TRoleMenu();
		String[] resourceidarray = menuid.split(",");
		for (int i = 0; i < resourceidarray.length; i++) {
			if (!resourceidarray[i].equals("")) {
				tRoleMenu.setMenuid(Integer.valueOf(resourceidarray[i]));
				tRoleMenu.setRoleid(bsRole.getId());
				tRoleMenu.setRoleid(bsRoleparam.get(0).getId());
				tRoleMenuDAO.insert(tRoleMenu);
			}
		}

	}

	// /**
	// * 插入角色
	// */
	// @Override
	// public void saveBsRole(BsRole bsRole, String resourceid) throws Exception
	// {
	// bsRoleDAO.insert(bsRole);
	// BsRoleExample example = new BsRoleExample();
	// example.createCriteria().andIsactiveEqualTo(bsRole.getIsactive())
	// .andNameEqualTo(bsRole.getName());
	// List<BsRole> bsRoleparam = bsRoleDAO.selectByExample(example);
	// BsRoleResource bsRoleResource = new BsRoleResource();
	// String[] resourceidarray = resourceid.split(",");
	// for (int i = 0; i < resourceidarray.length; i++) {
	// if (!resourceidarray[i].equals("")) {
	// bsRoleResource.setResourceid(Integer
	// .valueOf(resourceidarray[i]));
	// bsRoleResource.setRoleid(bsRole.getId());
	// bsRoleResource.setRoleid(bsRoleparam.get(0).getId());
	// bsRoleResourceDAO.insert(bsRoleResource);
	// }
	// }
	//
	// }

	/**
	 * 更新角色
	 */
	@Override
	public void updateBsRole(BsRole bsRole, String menuid) throws Exception {
		bsRoleDAO.updateByPrimaryKey(bsRole);
		// 先删除
		TRoleMenuExample example = new TRoleMenuExample();
		example.createCriteria().andRoleidEqualTo(bsRole.getId());
		tRoleMenuDAO.deleteByExample(example);
		// 后新增
		TRoleMenu tRoleMenu = new TRoleMenu();
		String[] resourceidarray = menuid.split(",");
		for (int i = 0; i < resourceidarray.length; i++) {
			if (!resourceidarray[i].equals("")) {
				tRoleMenu.setMenuid(Integer.valueOf(resourceidarray[i]));
				tRoleMenu.setRoleid(bsRole.getId());
				tRoleMenuDAO.insert(tRoleMenu);
			}
		}

	}

	/**
	 * 查询角色对应的资源
	 */
	@Override
	public List<BsRoleResource> queryBsRoleResourceByroleid(int roleid)
			throws Exception {
		BsRoleResourceExample example = new BsRoleResourceExample();
		example.createCriteria().andRoleidEqualTo(roleid);
		return bsRoleResourceDAO.selectByExample(example);
	}

	/**
	 * 更具用户id查询角色
	 */
	@Override
	public List<BsUserRole> queryroleByuserid(String userid) throws Exception {
		BsUserRoleExample example = new BsUserRoleExample();
		example.createCriteria().andUseridEqualTo(userid);
		return bsUserRoleDAO.selectByExample(example);
	}

	/**
	 * 查询api
	 */
	@Override
	public String getOpenApiJsonstr() throws Exception {
		OpenApiExample example = new OpenApiExample();
		List<OpenApi> dataList = openApiDAO.selectByExampleWithBLOBs(example);
		// 节点列表（散列表，用于临时存储节点对象）
		HashMap<Long, OpenApiNode> nodeList = new HashMap<Long, OpenApiNode>();
		// 根节点
		OpenApiNode root = null;
		// 根据结果集构造节点列表（存入散列表）
		for (OpenApi dataRecord : dataList) {
			OpenApiNode node = new OpenApiNode();
			node.setId(dataRecord.getId());
			BeanUtils.copyProperties(dataRecord, node);
			nodeList.put(node.getId(), node);
		}
		// 构造无序的多叉树
		Set entrySet = nodeList.entrySet();
		for (Iterator it = entrySet.iterator(); it.hasNext();) {
			OpenApiNode node = (OpenApiNode) ((Map.Entry) it.next()).getValue();
			if (node.getParent() == null || node.getParent().equals("")) {
				root = node;
			} else {
				((OpenApiNode) nodeList.get(node.getParent())).getChildren()
						.add(node);
			}
		}
		String json = JSON.toJSONString(root);
		return "[" + json + "]";
	}

	/**
	 * 查询详细API
	 */
	@Override
	public OpenApi queryApiDetailByID(long id) throws Exception {
		OpenApi openApi = openApiDAO.selectByPrimaryKey(id);
		return openApi;
	}

	/**
	 * 分页查询查询
	 */
	@Override
	public Pager queryAppbyPage(OpenApp openApp, int pagesize, int currentpage)
			throws Exception {
		Pager page = new Pager();
		OpenAppExample example = new OpenAppExample();
		com.et59.cus.domain.entity.OpenAppExample.Criteria criteria = example
				.createCriteria();
		if (null != openApp.getUserid() && !openApp.getUserid().equals("")) {
			criteria.andUseridEqualTo(openApp.getUserid());
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<OpenApp> list = commonDAOEx.selectOpenAppForPage(example,
				startrecord, pagesize);
		int totalCount = openAppDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 删除应用
	 */
	@Override
	public void deleteApp(long id) throws Exception {
		openAppDAO.deleteByPrimaryKey(id);

	}

	/**
	 * 添加应用
	 */
	@Override
	public void addApp(OpenApp openApp) throws Exception {
		openAppDAO.insert(openApp);

	}

	/**
	 * 编辑应用
	 */
	@Override
	public void editApp(OpenApp openApp) throws Exception {
		openAppDAO.updateByPrimaryKey(openApp);

	}

	/**
	 * 插入日志
	 */
	@Override
	public void insertOpenLog(String accesstoken, String apiUrl)
			throws Exception {
		OpenOauthExample example = new OpenOauthExample();
		List<OpenOauth> authlist = openOauthDAO.selectByExample(example);
		if (null != authlist && authlist.size() > 0) {
			OpenOauth openOauth = authlist.get(0);
			OpenLog record = new OpenLog();
			record.setAccesstime(new Date());
			record.setApiurl(apiUrl);
			record.setAppid(openOauth.getAppid());
			openLogDAO.insert(record);
		} else {
			throw new Exception("授权不存在!");
		}

	}

	/**
	 * 分页查询日志
	 */
	@Override
	public Pager queryopenLogbyPage(OpenLogQuery openLog, int pagesize,
			int currentpage) throws Exception {
		Pager page = new Pager();
		OpenLogExample example = new OpenLogExample();
		com.et59.cus.domain.entity.OpenLogExample.Criteria criteria = example
				.createCriteria();
		if (null != openLog.getAppid() && openLog.getAppid() > 0) {
			criteria.andAppidEqualTo(openLog.getAppid());
		}
		if (null != openLog.getStarttime() && null == openLog.getEndtime()) {
			criteria.andAccesstimeGreaterThan(openLog.getStarttime());
		} else if (null != openLog.getStarttime()
				&& null != openLog.getEndtime()) {
			criteria.andAccesstimeBetween(openLog.getStarttime(),
					openLog.getEndtime());
		} else if (null == openLog.getStarttime()
				&& null != openLog.getEndtime()) {
			criteria.andAccesstimeLessThanOrEqualTo(openLog.getEndtime());
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<OpenLog> list = commonDAOEx.selectOpenLogForPage(example,
				startrecord, pagesize);
		int totalCount = openLogDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 分页查询api
	 */
	@Override
	public Pager queryApibyPage(OpenApi openApi, int pagesize, int currentpage)
			throws Exception {
		Pager page = new Pager();
		OpenApiExample example = new OpenApiExample();
		com.et59.cus.domain.entity.OpenApiExample.Criteria criteria = example
				.createCriteria();
		if (null != openApi.getText() && !openApi.getText().equals("")) {
			criteria.andTextLike("%" + openApi.getText() + "%");
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<OpenApi> list = commonDAOEx.selectOpenApiForPage(example,
				startrecord, pagesize);
		int totalCount = openApiDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 保存openapi
	 */
	@Override
	public void saveOpenApi(OpenApi openApi) throws Exception {
		openApiDAO.insert(openApi);
	}

	/**
	 * 更新api
	 */
	@Override
	public void updateOpenApi(OpenApi openApi) throws Exception {
		openApiDAO.updateByPrimaryKeyWithBLOBs(openApi);

	}

	/**
	 * 删除api
	 */
	@Override
	public void deleteOpenApi(long id) throws Exception {
		openApiDAO.deleteByPrimaryKey(id);
	}

	/**
	 * 查询应用
	 */
	@Override
	public OpenApp queryApp(long id) throws Exception {
		return openAppDAO.selectByPrimaryKey(id);
	}

	/**
	 * 插入openoauth
	 */
	@Override
	public void insertOpenOauth(OpenOauth openOauth) throws Exception {
		openOauthDAO.insert(openOauth);
	}

	/**
	 * 查询是否有已经授权了
	 */
	@Override
	public List<OpenOauth> queryOpenOauth(OpenOauth openOauth) throws Exception {
		OpenOauthExample ooe = new OpenOauthExample();
		com.et59.cus.domain.entity.OpenOauthExample.Criteria criteria = ooe
				.createCriteria();
		if (null != openOauth.getAppid() && !openOauth.getAppid().equals("")) {
			criteria.andAppidEqualTo(openOauth.getAppid());
		}
		if (null != openOauth.getUserid() && !openOauth.getUserid().equals("")) {
			criteria.andUseridEqualTo(openOauth.getUserid());
		}
		if (null != openOauth.getCodeIsactive()
				&& !openOauth.getCodeIsactive().equals("")) {
			criteria.andCodeIsactiveEqualTo(openOauth.getCodeIsactive());
		}
		if (null != openOauth.getAccessToken()
				&& !openOauth.getAccessToken().equals("")) {
			criteria.andAccessTokenEqualTo(openOauth.getAccessToken());
		}
		if (null != openOauth.getCode() && !openOauth.getCode().equals("")) {
			criteria.andCodeEqualTo(openOauth.getCode());
		}
		if (null != openOauth.getTokenIsactive()
				&& !openOauth.getTokenIsactive().equals("")) {
			criteria.andTokenIsactiveEqualTo(openOauth.getTokenIsactive());
		}
		List<OpenOauth> list = openOauthDAO.selectByExample(ooe);
		return list;
	}

	/**
	 * 更新授权
	 */
	@Override
	public void updateOpenOauth(OpenOauth openOauth) throws Exception {
		openOauthDAO.updateByPrimaryKey(openOauth);
	}

	/**
	 * 查询授权通过分页
	 */
	@Override
	public Pager queryOpenOauthbyPage(OpenOauth openoauth, int pagesize,
			int currentpage) throws Exception {
		Pager page = new Pager();
		OpenOauthExample example = new OpenOauthExample();
		com.et59.cus.domain.entity.OpenOauthExample.Criteria criteria = example
				.createCriteria();
		if (null != openoauth.getAppid() && !openoauth.getAppid().equals("")) {
			criteria.andAppidEqualTo(openoauth.getAppid());
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<OpenOauth> list = commonDAOEx.selectOpenOauthForPage(example,
				startrecord, pagesize);
		int totalCount = openOauthDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 插入静态文件
	 */
	@Override
	public void insertpagestatic(BsPagestatic bsPagestatic) throws Exception {
		List<BsPagestatic> list = querypagestatic(bsPagestatic);
		if (null == list || list.size() == 0) {
			bsPagestaticDAO.insert(bsPagestatic);
		}
	}

	/**
	 * 查询静态文件
	 */
	@Override
	public List<BsPagestatic> querypagestatic(BsPagestatic bsPagestatic)
			throws Exception {
		BsPagestaticExample example = new BsPagestaticExample();
		com.et59.cus.domain.entity.BsPagestaticExample.Criteria criteria = example
				.createCriteria();
		if (!StringUtils.isEmpty(bsPagestatic.getDynamicurl())) {
			criteria.andDynamicurlEqualTo(bsPagestatic.getDynamicurl());
		}
		if (!StringUtils.isEmpty(bsPagestatic.getHtmname())) {
			criteria.andHtmnameEqualTo(bsPagestatic.getHtmname());
		}
		if (!StringUtils.isEmpty(bsPagestatic.getFilepath())) {
			criteria.andFilepathEqualTo(bsPagestatic.getFilepath());
		}

		return bsPagestaticDAO.selectByExample(example);
	}

	/**
	 * 删除授权
	 */
	@Override
	public void deleteOpenOauth(long id) throws Exception {
		openOauthDAO.deleteByPrimaryKey(id);
	}

	/**
	 * 插入留言
	 */
	@Override
	public void insertleavemessage(BsLeavemessage bsLeavemessage)
			throws Exception {
		bsLeavemessageDAO.insert(bsLeavemessage);
	}

	/**
	 * 分页查询留言
	 */
	@Override
	public Pager queryleavemessagebyPage(BsLeavemessage bsLeavemessage,
			int pagesize, int currentpage) throws Exception {
		Pager page = new Pager();
		BsLeavemessageExample example = new BsLeavemessageExample();
		com.et59.cus.domain.entity.BsLeavemessageExample.Criteria criteria = example
				.createCriteria();
		if (!StringUtils.isEmpty(bsLeavemessage.getMessage())) {
			criteria.andMessageLike("%" + bsLeavemessage.getMessage() + "%");
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsLeavemessage> list = commonDAOEx.selectleavemessageForPage(
				example, startrecord, pagesize);
		int totalCount = bsLeavemessageDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 查询变量
	 */
	@Override
	public List<BsSystem> queryBsSystem() throws Exception {
		BsSystemExample example = new BsSystemExample();
		return bsSystemDAO.selectByExample(example);
	}

	/**
	 * 缓存常量
	 */
	@Override
	public void cacheSystemConstatnt() throws Exception {
		try {
			List<BsSystem> list = this.queryBsSystem();
			for (BsSystem row : list) {
				log.info("***加载缓存常量***key[" + row.getSystemKey() + "]---value["
						+ row.getSystemValue() + "]***");
				Cache.getInstance().put(row.getSystemKey(),
						row.getSystemValue());
			}
			TCollegeExample example = new TCollegeExample();
			example.createCriteria().andCollegelevelEqualTo("1");
			TCollege college = (TCollege) Cache.getInstance().get("summary");
			if (null == college) {
				college = (TCollege) tCollegeDAO.selectByExample(example)
						.get(0);
				Cache.getInstance().put("summary", college);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 查询结果
	 */
	@Override
	public List<TjActiontime> queryActionTime(TjActiontime tjActiontime)
			throws Exception {
		TjActiontimeExample example = new TjActiontimeExample();
		com.et59.cus.domain.entity.TjActiontimeExample.Criteria criteria = example
				.createCriteria();
		example.setOrderByClause(" excute_time desc limit 20 ");
		if (null != tjActiontime.getCreatetime()) {
			criteria.andCreatetimeEqualTo(tjActiontime.getCreatetime());
		}
		return tjActiontimeDAO.selectByExample(example);
	}

	/**
	 * 插入统计结果
	 */
	@Override
	public void insertActionTime(TjActiontime tjActiontime) throws Exception {
		tjActiontimeDAO.insert(tjActiontime);
	}

	/**
	 * 更具实现接口
	 */
	@Override
	public void insertBsAddress(BsAddress bsAddress) throws Exception {
		bsAddressDAO.insert(bsAddress);
	}

	/**
	 * 查询
	 * 
	 * @param bsAddress
	 * @throws Exception
	 */
	public List<BsAddress> queryBsAddress(BsAddress bsAddress) throws Exception {
		BsAddressExample example = new BsAddressExample();
		com.et59.cus.domain.entity.BsAddressExample.Criteria criteria = example
				.createCriteria();
		if (!StringUtils.isEmpty(bsAddress.getAddressHead())) {
			criteria.andAddressHeadEqualTo(bsAddress.getAddressHead());
		}
		if (!StringUtils.isEmpty(bsAddress.getAddressDetail())) {
			criteria.andAddressDetailEqualTo(bsAddress.getAddressDetail());
		}
		if (!StringUtils.isEmpty(bsAddress.getConsignee())) {
			criteria.andConsigneeEqualTo(bsAddress.getConsignee());
		}
		if (!StringUtils.isEmpty(bsAddress.getPostcode())) {
			criteria.andPostcodeEqualTo(bsAddress.getPostcode());
		}
		if (!StringUtils.isEmpty(bsAddress.getTelephone())) {
			criteria.andTelephoneEqualTo(bsAddress.getTelephone());
		}
		if (!StringUtils.isEmpty(bsAddress.getUserid())) {
			criteria.andUseridEqualTo(bsAddress.getUserid());
		}

		List<BsAddress> list = bsAddressDAO.selectByExample(example);
		return list;
	}

	/**
	 * 1创建订单 2插入地址 3支付
	 */
	@Override
	public OrderVo Pay(BsAddress bsAddress, Shopcart shopCart, String identity)
			throws Exception {
		if (identity.equals("new")) {
			bsAddressDAO.insert(bsAddress);
			List<BsAddress> list = queryBsAddress(bsAddress);
			if (null != list && list.size() > 0) {
				bsAddress = list.get(0);
			}
		} else {
			bsAddress = bsAddressDAO.selectByPrimaryKey(new Long(identity));
		}
		BsOrder order = new BsOrder();
		String orderid = UUIDGenerator.getOrderNo();// 唯一的数据库主键
		order.setOrderId(orderid);
		order.setOrderStatus(Constant.ORDER_STATUS_UNPAY);
		order.setOrderCreateTime(new Date());
		order.setAddressId(bsAddress.getId());
		order.setUserId(bsAddress.getUserid());
		order.setOrderTotalPrice(shopCart.getTotalPrice());
		List<Item> listitem = shopCart.getList();
		for (Item row : listitem) {
			order.setProductId(row.getBsProduct().getId());
			order.setProductNumber(row.getProductnumber());
			orderDAO.insert(order);
		}
		OrderVo orderVo = new OrderVo();
		orderVo.setBsAddress(bsAddress);
		orderVo.setOrder(order);
		return orderVo;
	}

	/**
	 * 分页查询发货地址
	 */
	@Override
	public Pager queryaddressbyPage(BsAddress bsAddress, int pagesize,
			int currentpage) throws Exception {
		Pager page = new Pager();
		BsAddressExample example = new BsAddressExample();
		com.et59.cus.domain.entity.BsAddressExample.Criteria criteria = example
				.createCriteria();
		if (!StringUtils.isEmpty(bsAddress.getUserid())) {
			criteria.andUseridEqualTo(bsAddress.getUserid());
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<BsAddress> list = commonDAOEx.selectBsAddressForPage(example,
				startrecord, pagesize);
		int totalCount = bsAddressDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 删除地址
	 */
	@Override
	public void deleteBsAddress(long id) throws Exception {
		bsAddressDAO.deleteByPrimaryKey(id);

	}

	/**
	 * 更新地址
	 */
	@Override
	public void updateBsAddress(BsAddress bsAddress) throws Exception {
		bsAddressDAO.updateByPrimaryKey(bsAddress);
	}

	/**
	 * 订单详情
	 */
	@Override
	public OrderVo getOrderDetail(String orderid) throws Exception {
		OrderVo orderVo = new OrderVo();
		BsOrderExample bo = new BsOrderExample();
		com.et59.cus.domain.entity.BsOrderExample.Criteria criteria = bo
				.createCriteria();
		if (null != orderid && !orderid.equals("")) {
			criteria.andOrderIdEqualTo(orderid);
		}
		List<BsOrder> list = orderDAO.selectByExample(bo);
		List<BsProductVo> listproduct = new ArrayList<BsProductVo>();
		BsOrder bsOrder = new BsOrder();
		for (BsOrder row : list) {
			BsProduct bsProduct = (BsProduct) productDAO.selectByPrimaryKey(row
					.getProductId());
			BsProductVo bsProductVo = new BsProductVo();
			BeanUtils.copyProperties(bsProduct, bsProductVo);
			bsProductVo.setNumber(row.getProductNumber());
			bsProductVo.setTotalprice(bsProduct.getProductPrice().multiply(
					new BigDecimal(row.getProductNumber())));
			listproduct.add(bsProductVo);
			bsOrder = row;
		}
		BsAddress bsAddress = bsAddressDAO.selectByPrimaryKey(bsOrder
				.getAddressId());
		orderVo.setOrder(bsOrder);
		orderVo.setList(listproduct);
		orderVo.setBsAddress(bsAddress);
		return orderVo;
	}

	/**
	 * 更新订单
	 */
	@Override
	public void updateOrder(String out_trade_no, String trade_no,
			int trade_status) throws Exception {
		// 查询订单，更新订单，
		BsOrderExample bo = new BsOrderExample();
		com.et59.cus.domain.entity.BsOrderExample.Criteria criteria = bo
				.createCriteria();
		if (null != out_trade_no && !out_trade_no.equals("")) {
			criteria.andOrderIdEqualTo(out_trade_no);
		}
		List<BsOrder> list = orderDAO.selectByExample(bo);
		if (null != list && list.size() > 0) {
			for (BsOrder row : list) {
				row.setOrderUpdateTime(new Date());
				row.setPayTradeNo(trade_no);
				row.setOrderStatus(trade_status);
				orderDAO.updateByPrimaryKey(row);
			}
		}
	}

	/**
	 * 查询Menu分页
	 */
	@Override
	public Pager queryBsMenuByPage(BsMenu bsMenu, int pagesize,
			int currentpage, BsUser user) throws Exception {
		Pager page = new Pager();
		BsMenuExample example = new BsMenuExample();
		com.et59.cus.domain.entity.BsMenuExample.Criteria criteria = example
				.createCriteria();
		criteria.andMenulevelGreaterThan(2);
		int startrecord = (currentpage - 1) * pagesize;
		List<BsResource> list = commonDAOEx.selectBsMenuForPage(example,
				startrecord, pagesize);
		int totalCount = 0;
		// if ("yes".equals(user.getIsadmin())) {
		totalCount = bsMenuDAO.countByExample(example);
		// } else {
		// totalCount = bsMenuDAO.countByExampleByUserid(map);
		// }
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 查询角色对应的菜单
	 */
	@Override
	public List<TRoleMenu> queryTRoleMenuByroleid(int roleid) throws Exception {
		TRoleMenuExample example = new TRoleMenuExample();
		example.createCriteria().andRoleidEqualTo(roleid);
		return tRoleMenuDAO.selectByExample(example);
	}

	/**
	 * 数据字典查询
	 */
	@Override
	public Pager queryDictionaryBypage(TDictionary tDictionary, int pagesize,
			int currentpage) throws Exception {
		Pager page = new Pager();
		TDictionaryExample example = new TDictionaryExample();
		com.et59.cus.domain.entity.TDictionaryExample.Criteria criteria = example
				.createCriteria();
		String type = tDictionary.getDictionarytype();
		if (null != tDictionary.getDictionarytype()) {
			criteria.andDictionarytypeEqualTo(type);
		}
		// if (null != bsProductcategory.getSupplierCode()) {
		// criteria.andSupplierCodeEqualTo(bsProductcategory.getSupplierCode());
		// }
		int startrecord = (currentpage - 1) * pagesize;
		List<TDictionary> list = commonDAOEx.selectDictionaryForPage(example,
				startrecord, pagesize);
		int totalCount = tDictionaryDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 删除字典
	 */
	@Override
	public void deleteDictionary(int id) throws Exception {
		tDictionaryDAO.deleteByPrimaryKey(id);
	}

	/**
	 * 保存字典
	 */
	@Override
	public void saveDictionary(TDictionary tDictionary) throws Exception {
		tDictionaryDAO.insert(tDictionary);
	}

	/**
	 * 更新字典
	 */
	@Override
	public void udateDictionary(TDictionary tDictionary) throws Exception {
		tDictionaryDAO.updateByPrimaryKey(tDictionary);
	}

	/**
	 * 师资队伍查询
	 */
	@Override
	public Pager queryTeacherBypage(TTeacher tTeacher, int pagesize,
			int currentpage) throws Exception {
		Pager page = new Pager();
		TTeacherExample example = new TTeacherExample();
		com.et59.cus.domain.entity.TTeacherExample.Criteria criteria = example
				.createCriteria();
		String teacherName = tTeacher.getTeachername();
		String department = tTeacher.getDepartment();
		if (null != teacherName) {
			criteria.andTeachernameLike(teacherName);
		}
		if (null != department && department != "") {
			criteria.andDepartmentEqualTo(department);
		}
		int startrecord = (currentpage - 1) * pagesize;
		List<TTeacher> list = commonDAOEx.selectTeacherForPage(example,
				startrecord, pagesize);
		int totalCount = tTeacherDAO.countByExample(example);
		page.setRows(list);
		page.setTotal(totalCount);
		return page;
	}

	/**
	 * 师资队伍删除
	 * 
	 * @return
	 */
	@Override
	public Integer deleteTeacher(long id) throws Exception {
		return tTeacherDAO.deleteByProc(id);
	}

	/**
	 * 保存教师信息
	 * 
	 * @param tTeacher
	 * @return
	 * @throws Exception
	 */
	public Long saveTeacher(TTeacher tTeacher) throws Exception {
		return tTeacherDAO.insert(tTeacher);
	}

	/**
	 * 更新教师信息
	 * 
	 * @param tTeacher
	 * @return
	 * @throws Exception
	 */
	public int updateTeacher(TTeacher tTeacher) throws Exception {
		return tTeacherDAO.updateByPrimaryKeySelective(tTeacher);
	}

	/**
	 * 按师资队伍查询 (分页)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map queryTeacherByTypeForPage(TTeacher tTeacher, int pagesize,
			int currentpage) throws Exception {
		Map map = new HashMap();
		TTeacherExample example = new TTeacherExample();
		com.et59.cus.domain.entity.TTeacherExample.Criteria criteria = example
				.createCriteria();
		example.setOrderByClause(" department ");
		// if (null != tTeacher.getArticletype()
		// && !tTeacher.getArticletype().equals("")) {
		// criteria.andArticletypeEqualTo(tTeacher.getArticletype());
		// }
		// if (null != bsArticle.getStartdatacreatenew()
		// && null == bsArticle.getEnddatacreatenew()) {
		// criteria.andCreatedateGreaterThan(bsArticle.getStartdatacreatenew());
		// } else if (null != bsArticle.getStartdatacreatenew()
		// && null != bsArticle.getEnddatacreatenew()) {
		// criteria.andCreatedateBetween(bsArticle.getStartdatacreatenew(),
		// bsArticle.getEnddatacreatenew());
		// } else if (null == bsArticle.getStartdatacreatenew()
		// && null != bsArticle.getEnddatacreatenew()) {
		// criteria.andCreatedateLessThan(bsArticle.getEnddatacreatenew());
		// }
		// if (null != bsArticle.getAuthor()) {
		// criteria.andAuthorLike("%" + bsArticle.getAuthor() + "%");
		// }
		// if (null != bsArticle.getArticletitle()) {
		// criteria.andArticletitleLike("%" + bsArticle.getArticletitle()
		// + "%");
		// }
		int startrecord = (currentpage - 1) * pagesize;
		List<TTeacher> list = commonDAOEx.selectTeacherForPage(example,
				startrecord, pagesize);
		int totalCount = tTeacherDAO.countByExample(example);
		map.put(Constant.TOTALCOUNT, totalCount);
		map.put(Constant.TOTALPAGECOUNT,
				ComonUtil.computusTotalPage(totalCount, pagesize));
		map.put(Constant.ACTION_RESULT, Constant.RESULT_SUCCESS);
		map.put(Constant.TEACHER_LIST, list);
		return map;
	}

	/**
	 * 查询教师byid
	 */
	@Override
	public TTeacher queryTeacherById(long id) throws Exception {
		TTeacher tTeacher = new TTeacher();
		if (id == 0) {
			throw new Exception("id错误!");
		} else {
			tTeacher = tTeacherDAO.selectByPrimaryKey(id);
			if (null != tTeacher) {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面存在该文章！");
				}
			} else {
				if (log.isDebugEnabled()) {
					log.debug("数据库里面不存在该文章，校验失败");
				}
			}
		}
		return tTeacher;
	}

}
