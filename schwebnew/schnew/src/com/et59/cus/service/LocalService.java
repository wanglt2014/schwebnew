package com.et59.cus.service;

import java.util.List;
import java.util.Map;

import com.et59.cus.domain.entity.BsAddress;
import com.et59.cus.domain.entity.BsArticle;
import com.et59.cus.domain.entity.BsEmail;
import com.et59.cus.domain.entity.BsLeavemessage;
import com.et59.cus.domain.entity.BsMarking;
import com.et59.cus.domain.entity.BsMenu;
import com.et59.cus.domain.entity.BsOrder;
import com.et59.cus.domain.entity.BsPagestatic;
import com.et59.cus.domain.entity.BsProduct;
import com.et59.cus.domain.entity.BsProductcategory;
import com.et59.cus.domain.entity.BsResource;
import com.et59.cus.domain.entity.BsRole;
import com.et59.cus.domain.entity.BsRoleResource;
import com.et59.cus.domain.entity.BsSupplier;
import com.et59.cus.domain.entity.BsSystem;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.BsUserRole;
import com.et59.cus.domain.entity.BsUserservice;
import com.et59.cus.domain.entity.OpenApi;
import com.et59.cus.domain.entity.OpenApp;
import com.et59.cus.domain.entity.OpenOauth;
import com.et59.cus.domain.entity.TDictionary;
import com.et59.cus.domain.entity.TRoleMenu;
import com.et59.cus.domain.entity.TTeacher;
import com.et59.cus.domain.entity.TjActiontime;
import com.et59.cus.domain.entity.ex.BsArticleQuery;
import com.et59.cus.domain.entity.ex.BsEmailquery;
import com.et59.cus.domain.entity.ex.BsProductQuery;
import com.et59.cus.domain.entity.ex.OpenLogQuery;
import com.et59.cus.domain.entity.ex.OrderVo;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.domain.entity.ex.Shopcart;

/**
 * <p>
 * Title: LocalService.java
 * </p>
 * <p>
 * Description:
 * </p>
 *
 */
public interface LocalService {
	// 用户表
	@SuppressWarnings("rawtypes")
	public Map queryUsername(BsUser user) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map queryUserByTokenId(BsUser user) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map updateUser(BsUser user, String roleid) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map createUser(BsUser user, String roleid) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map queryUserbyEmail(BsUser user) throws Exception;

	public Pager queryUserListByPage(BsUser user, int pagesize, int currentpage)
			throws Exception;

	public BsUser queryUserByKey(int id) throws Exception;

	public void deleteUserBykey(int id) throws Exception;

	// 产品表
	@SuppressWarnings("rawtypes")
	public Map queryProductInfoByPage(BsProductQuery product, int pagesize,
			int currentpage) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map queryProductDetail(int id) throws Exception;

	public void deleteBsProduct(int id) throws Exception;

	public void saveBsProduct(BsProduct bsProduct) throws Exception;

	public void udateBsProduct(BsProduct bsProduct) throws Exception;

	// 订单表
	@SuppressWarnings("rawtypes")
	public Map insertOrder(BsOrder order) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map updateOrder(BsOrder order) throws Exception;

	public void updateOrder(String out_trade_no, String trade_no,
			int trade_status) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map queryOrderForPage(BsOrder order, int pagesize, int currentpage)
			throws Exception;

	@SuppressWarnings("rawtypes")
	public Map queryOrderByorderId(String orderid) throws Exception;

	public void deleteOrder(int id) throws Exception;

	public OrderVo getOrderDetail(String orderid) throws Exception;

	// 用户订购服务表
	@SuppressWarnings("rawtypes")
	public Map insertUserService(BsUserservice bsUserservice) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map queryUserServiceByPrimaryKey(BsUserservice bsUserservice)
			throws Exception;

	@SuppressWarnings("rawtypes")
	public Map updateUserService(BsUserservice bsUserservice) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map queryUserServiceForPage(BsUserservice bsUserservice,
			int pagesize, int currentpage) throws Exception;

	public void deleteUserservice(int id) throws Exception;

	public void saveUserservice(BsUserservice bsUserservice) throws Exception;

	public void updateUserservice(BsUserservice bsUserservice) throws Exception;

	// 邮件表
	@SuppressWarnings("rawtypes")
	public Map insertEmail(BsEmail bsEmail) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map queryEmail(BsEmail bsEmail) throws Exception;

	@SuppressWarnings("rawtypes")
	public Map updateEmail(BsEmail bsEmail) throws Exception;

	public Pager queryEmailJsonForpage(BsEmailquery bsemail, int startrecord,
			int endrecord) throws Exception;

	public BsEmail queryEmailByIdJson(long id) throws Exception;

	// 文章表
	@SuppressWarnings("rawtypes")
	public Map queryArticleByTypeForPage(BsArticleQuery bsArticle,
			int pagesize, int currentpage) throws Exception;

	public BsArticle queryArticleById(long id) throws Exception;

	public void saveArticle(BsArticle bsArticle) throws Exception;

	public void updateArticle(BsArticle bsArticle) throws Exception;

	public void deleteArticle(long id) throws Exception;

	// 菜单表
	public String getMenuJsonstr(BsUser user) throws Exception;

	public void updateOrAddMenu(BsMenu bsMenu) throws Exception;

	public void deleteMenu(long id) throws Exception;

	// 供应商
	public Pager querySupplierByPage(BsSupplier bsSupplier, int pagesize,
			int currentpage) throws Exception;

	public void deleteSupplier(int id) throws Exception;

	public void saveSupplier(BsSupplier bsSupplier) throws Exception;

	public void udateSupplier(BsSupplier bsSupplier) throws Exception;

	public String querySupplierNameByCode(String code) throws Exception;

	// 产品分类
	public Pager queryProductcategoryBypage(
			BsProductcategory bsProductcategory, int pagesize, int currentpage)
			throws Exception;

	public void deleteBsProductcategory(int id) throws Exception;

	public void saveBsProductcategory(BsProductcategory bsProductcategory)
			throws Exception;

	public void udateBsProductcategory(BsProductcategory bsProductcategory)
			throws Exception;

	public String queryBsProductcategoryByCode(String code) throws Exception;

	// 市场表
	public Pager queryBsMarkingByPage(BsMarking bsMarking, int pagesize,
			int currentpage) throws Exception;

	public void deleteBsMarking(int id) throws Exception;

	public void saveBsMarking(BsMarking bsMarking) throws Exception;

	public void updateBsMarking(BsMarking bsMarking) throws Exception;

	// 查询资源表
	public List<BsResource> queryResourcebyuserId(String userid)
			throws Exception;

	public Pager queryBsResourceByPage(BsResource bsResource, int pagesize,
			int currentpage) throws Exception;

	public void deleteBsResource(int id) throws Exception;

	public void saveBsResource(BsResource bsResource) throws Exception;

	public void updateBsResource(BsResource bsResource) throws Exception;

	// 角色查询
	public Pager queryBsRoleByPage(BsRole bsRole, int pagesize, int currentpage)
			throws Exception;

	public void deleteBsRole(int id) throws Exception;

	public void saveBsRole(BsRole bsRole, String resourceid) throws Exception;

	public void updateBsRole(BsRole bsRole, String resourceid) throws Exception;

	// 查询角色对应的资源
	public List<BsRoleResource> queryBsRoleResourceByroleid(int roleid)
			throws Exception;

	public List<BsUserRole> queryroleByuserid(String userid) throws Exception;

	// 开放api
	public String getOpenApiJsonstr() throws Exception;

	public OpenApi queryApiDetailByID(long id) throws Exception;

	public Pager queryApibyPage(OpenApi openApi, int pagesize, int currentpage)
			throws Exception;

	public void saveOpenApi(OpenApi openApi) throws Exception;

	public void updateOpenApi(OpenApi openApi) throws Exception;

	public void deleteOpenApi(long id) throws Exception;

	// 应用管理
	public Pager queryAppbyPage(OpenApp openApp, int pagesize, int currentpage)
			throws Exception;

	public void deleteApp(long id) throws Exception;

	public void addApp(OpenApp openApp) throws Exception;

	public void editApp(OpenApp openApp) throws Exception;

	public OpenApp queryApp(long id) throws Exception;

	// 開放日志
	public void insertOpenLog(String accesstoken, String apiUrl)
			throws Exception;

	public Pager queryopenLogbyPage(OpenLogQuery openLog, int pagesize,
			int currentpage) throws Exception;

	// 访问权限表
	public void insertOpenOauth(OpenOauth openOauth) throws Exception;

	public List<OpenOauth> queryOpenOauth(OpenOauth openOauth) throws Exception;

	public Pager queryOpenOauthbyPage(OpenOauth openoauth, int pagesize,
			int currentpage) throws Exception;

	public void updateOpenOauth(OpenOauth openOauth) throws Exception;

	public void deleteOpenOauth(long id) throws Exception;

	// 静态化表
	public void insertpagestatic(BsPagestatic bsPagestatic) throws Exception;

	public List<BsPagestatic> querypagestatic(BsPagestatic bsPagestatic)
			throws Exception;

	// 留言
	public void insertleavemessage(BsLeavemessage bsLeavemessage)
			throws Exception;

	public Pager queryleavemessagebyPage(BsLeavemessage bsLeavemessage,
			int pagesize, int currentpage) throws Exception;

	// 系统变量
	public List<BsSystem> queryBsSystem() throws Exception;

	public void cacheSystemConstatnt() throws Exception;

	// action执行时间统计
	public List<TjActiontime> queryActionTime(TjActiontime tjActiontime)
			throws Exception;

	public void insertActionTime(TjActiontime tjActiontime) throws Exception;

	// 收货地址
	public void insertBsAddress(BsAddress bsAddress) throws Exception;

	public void deleteBsAddress(long id) throws Exception;

	public void updateBsAddress(BsAddress bsAddress) throws Exception;

	public List<BsAddress> queryBsAddress(BsAddress bsAddress) throws Exception;

	public Pager queryaddressbyPage(BsAddress bsAddress, int pagesize,
			int currentpage) throws Exception;

	// 支付
	public OrderVo Pay(BsAddress bsAddress, Shopcart shopCart, String identity)
			throws Exception;

	/**
	 * 查询Menu分页
	 */
	public Pager queryBsMenuByPage(BsMenu bsMenu, int pagesize,
			int currentpage, BsUser user) throws Exception;

	/**
	 * 查询角色对应的菜单
	 */
	public List<TRoleMenu> queryTRoleMenuByroleid(int roleid) throws Exception;

	/**
	 * 数据字典查询
	 */
	public Pager queryDictionaryBypage(TDictionary tDictionary, int pagesize,
			int currentpage) throws Exception;

	/**
	 * 删除字典
	 */
	public void deleteDictionary(int id) throws Exception;

	/**
	 * 保存字典
	 */
	public void saveDictionary(TDictionary tDictionary) throws Exception;

	/**
	 * 更新字典
	 */
	public void udateDictionary(TDictionary tDictionary) throws Exception;

	/**
	 * 师资队伍查询
	 */
	public Pager queryTeacherBypage(TTeacher tTeacher, int pagesize,
			int currentpage) throws Exception;

	/**
	 * 师资队伍删除
	 */
	public Integer deleteTeacher(long id) throws Exception;

	/**
	 * 保存教师信息
	 * 
	 * @param tTeacher
	 * @return
	 * @throws Exception
	 */
	public Long saveTeacher(TTeacher tTeacher) throws Exception;

	/**
	 * 更新教师信息
	 * 
	 * @param tTeacher
	 * @return
	 * @throws Exception
	 */
	public int updateTeacher(TTeacher tTeacher) throws Exception;
	
	/**
	 * 按师资队伍查询 (分页)
	 */
	public Map queryTeacherByTypeForPage(TTeacher tTeacher,
			int pagesize, int currentpage) throws Exception;
	
	/**
	 * 查询教师byid
	 */
	public TTeacher queryTeacherById(long id) throws Exception;
}
