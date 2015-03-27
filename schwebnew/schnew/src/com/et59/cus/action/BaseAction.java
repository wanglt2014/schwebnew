package com.et59.cus.action;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.et59.cus.cache.Cache;
import com.et59.cus.domain.entity.BsArticle;
import com.et59.cus.domain.entity.BsOrder;
import com.et59.cus.domain.entity.BsProduct;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.TDepartmentWithBLOBs;
import com.et59.cus.domain.entity.TDictionary;
import com.et59.cus.domain.entity.TDownload;
import com.et59.cus.domain.entity.TSubject;
import com.et59.cus.domain.entity.TTeacher;
import com.et59.cus.domain.entity.ex.BsArticleQuery;
import com.et59.cus.domain.entity.ex.ReturnMsg;
import com.et59.cus.domain.entity.ex.Shopcart;
import com.et59.cus.domain.entity.ex.SuccessFailPage;
import com.et59.cus.mail.MailSenderInfo;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.XMLUtil;
import com.opensymphony.xwork2.ActionContext;

public abstract class BaseAction extends SystemAction {
	Logger log = Logger.getLogger(BaseAction.class);
	private static final long serialVersionUID = 2062125784349246762L;
	ActionContext context = ActionContext.getContext();
	protected HttpServletRequest request = (HttpServletRequest) context
			.get(ServletActionContext.HTTP_REQUEST);
	protected HttpServletResponse response = (HttpServletResponse) context
			.get(ServletActionContext.HTTP_RESPONSE);
	protected BsUser user;
	protected String idNumber;
	protected Shopcart shopcart = (Shopcart) getSession().get(
			Constant.SHOP_CART);
	/** 显示信息 */
	protected String showMessage;
	protected String password;
	HttpSession httpsession = request.getSession();
	private Map<String, Object> session;
	protected BsOrder order;
	protected String suppliercode;
	protected String checkcode;
	protected String usertype;
	protected String productcode;
	protected BsProduct product;

	protected SuccessFailPage successFailPage;
	protected int totalPageCount;// 总页数
	protected int totalCount;// 总记录数
	protected int currentPage;// 当前页数

	/**
	 * 资讯
	 */
	protected List<BsArticle> bsArticlelist;
	/**
	 * 教务教学通知
	 */
	protected List<BsArticle> notifylist;
	/**
	 * 公司媒体
	 */
	protected List<BsArticle> medialist;
	/**
	 * 教学动态
	 */
	protected List<BsArticle> teachList;
	/**
	 * 教务教学制度
	 */
	protected List<BsArticle> regulationList;
	/**
	 * 课程列表
	 */
	protected List<TSubject> subjectList;
	/**
	 * 资料下载列表
	 */
	protected List<TDownload> downloadlist;
	/**
	 * 文章详情
	 */
	protected BsArticle bsArticledetail;

	/**
	 * 文件表
	 */
	protected TDownload downloaddetail;

	/**
	 * 教师列表
	 */
	protected List<TTeacher> teacherList;

	/**
	 * 文章详情
	 */
	protected TTeacher tTeacherdetail;

	/**
	 * 数据字典列表
	 */
	protected List<TDictionary> dictionaryList;

	/**
	 * 专业列表
	 */
	protected List<TDepartmentWithBLOBs> tdepartmentList;

	@Override
	public String execute() {
		return SUCCESS;
	}

	protected Date getDateForReq(int num) {
		Calendar c = Calendar.getInstance();
		if (num == 1) {// week
			c.add(Calendar.WEEK_OF_MONTH, -1);
		} else if (num == 2) {// 1 month
			c.add(Calendar.MONTH, -1);
		} else if (num == 3) {// 3 month
			c.add(Calendar.MONTH, -3);
		}

		Date date = c.getTime();
		return date;
	}

	/**
	 * 得到默认的MailSenderInfo
	 * 
	 * @return
	 */
	public MailSenderInfo getDefaultMailSenderInfo() {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost(Cache.getCache("mail_host").toString());
		mailInfo.setMailServerPort(Cache.getCache("mail_port").toString());
		mailInfo.setValidate(true);
		mailInfo.setUserName(Cache.getCache("mail_username").toString());
		mailInfo.setPassword(Cache.getCache("mail_password").toString());// 您的邮箱密码
		mailInfo.setFromAddress(Cache.getCache("mail_username").toString());
		mailInfo.setNick(Cache.getCache("mail_nickname").toString());
		return mailInfo;
	}

	/**
	 * 公共查询新闻中心左侧信息,首页使用
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void commonquery() {
		try {
			BsArticleQuery bsArticle = new BsArticleQuery();
			bsArticle.setArticletype(Constant.ARTICLE_TYPE_REGULATION);
			Map map1 = localServiceProxy.queryArticleByTypeForPage(bsArticle,
					9, 1);
			if (ComonUtil.validateMapResult(map1)) {
				regulationList = (List<BsArticle>) map1
						.get(Constant.ARTICLE_LIST);
			}
			bsArticle.setArticletype(Constant.ARTICLE_TYPE_NOTICE);
			Map map2 = localServiceProxy.queryArticleByTypeForPage(bsArticle,
					5, 1);
			if (ComonUtil.validateMapResult(map2)) {
				notifylist = (List<BsArticle>) map2.get(Constant.ARTICLE_LIST);
			}

			TDownload download = new TDownload();
			download.setFileisvalid(Constant.ISVALID_1);// 可用
			Map map3 = localServiceEXProxy.queryDownloadInfoForLimit(download,
					5, 1);
			if (ComonUtil.validateMapResult(map3)) {
				downloadlist = (List<TDownload>) map3
						.get(Constant.DOWNLOAD_LIST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 公共查询资料下载左侧信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void commonqueryDownload() {
		try {
			TDownload download = new TDownload();
			download.setFileisvalid(Constant.ISVALID_1);// 可用
			Map map1 = localServiceEXProxy.queryDownloadInfoForLimit(download,
					5, 1);
			if (ComonUtil.validateMapResult(map1)) {
				downloadlist = (List<TDownload>) map1
						.get(Constant.DOWNLOAD_LIST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 公共查询教务教学通知左侧信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void commonQueryForArticle(int type) {
		try {
			BsArticleQuery bsArticle = new BsArticleQuery();
			if (1 == type) {
				bsArticle.setArticletype(Constant.ARTICLE_TYPE_NOTICE);
			} else if (2 == type) {
				bsArticle.setArticletype(Constant.ARTICLE_TYPE_REGULATION);
			} else if (3 == type) {
			}
			Map map1 = localServiceProxy.queryArticleByTypeForPage(bsArticle,
					5, 1);
			if (ComonUtil.validateMapResult(map1)) {
				notifylist = (List<BsArticle>) map1.get(Constant.ARTICLE_LIST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 公共查询课程列表左侧信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void commonQueryForSubject() {
		try {
			TSubject subject = new TSubject();
			subject.setSubjectisvalid(Constant.ISVALID_1);
			Map map1 = localServiceEXProxy.querySubjectForLimit(subject, 9, 1);
			if (ComonUtil.validateMapResult(map1)) {
				subjectList = (List<TSubject>) map1.get(Constant.ARTICLE_LIST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 公共的reponseWriter
	 * 
	 * @param jsonstr
	 */
	public void reponseWriter(String jsonstr) {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(jsonstr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 检查是否登录
	 * 
	 * @return
	 */
	public boolean isLogin() {
		try {
			BsUser bsUser = (BsUser) getSession().get("user");
			if (null != bsUser) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 公共的reponseWriter
	 * 
	 * @param jsonstr
	 */
	public void reponseWriterXml(String jsonstr) {
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(jsonstr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 客户端方法选择
	 * 
	 * @param jsonstr
	 */
	public void reponseWriterMobile(ReturnMsg returnMsg) {
		log.info("sessionid:" + request.getSession().getId());
		String type = request.getParameter("type");
		if (null != type && type.equals("xml")) {
			reponseWriterXml(XMLUtil.ReturnMsgChangeTOXml(returnMsg));
		} else {
			reponseWriter(JSON.toJSONString(returnMsg));
		}
	}

	/**
	 * 公共查询教师
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void commonQueryForTeacher(String department) {
		try {
			TTeacher tTeacher = new TTeacher();
			// if (department!=null && !department.equals("")) {
			// tTeacher.setArticletype(Constant.ARTICLE_TYPE_NOTICE);
			// }
			Map map1 = localServiceProxy.queryTeacherByTypeForPage(tTeacher, 9,
					1);
			if (ComonUtil.validateMapResult(map1)) {
				teacherList = (List<TTeacher>) map1.get(Constant.TEACHER_LIST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BsUser getUser() {
		user = (BsUser) ActionContext.getContext().getSession().get("user");
		return user;
	}

	public void setUser(BsUser user) {
		this.user = user;
	}

	public String getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		session = ActionContext.getContext().getSession();
		return session;
	}

	public SuccessFailPage getSuccessFailPage() {
		return successFailPage;
	}

	public void setSuccessFailPage(SuccessFailPage successFailPage) {
		this.successFailPage = successFailPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public BsOrder getOrder() {
		return order;
	}

	public void setOrder(BsOrder order) {
		this.order = order;
	}

	public String getSuppliercode() {
		return suppliercode;
	}

	public void setSuppliercode(String suppliercode) {
		this.suppliercode = suppliercode;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public BsProduct getProduct() {
		return product;
	}

	public void setProduct(BsProduct product) {
		this.product = product;
	}

	public List<BsArticle> getBsArticlelist() {
		return bsArticlelist;
	}

	public void setBsArticlelist(List<BsArticle> bsArticlelist) {
		this.bsArticlelist = bsArticlelist;
	}

	public List<BsArticle> getNotifylist() {
		return notifylist;
	}

	public void setNotifylist(List<BsArticle> notifylist) {
		this.notifylist = notifylist;
	}

	public List<BsArticle> getMedialist() {
		return medialist;
	}

	public void setMedialist(List<BsArticle> medialist) {
		this.medialist = medialist;
	}

	public BsArticle getBsArticledetail() {
		return bsArticledetail;
	}

	public void setBsArticledetail(BsArticle bsArticledetail) {
		this.bsArticledetail = bsArticledetail;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Shopcart getShopcart() {
		return shopcart;
	}

	public void setShopcart(Shopcart shopcart) {
		this.shopcart = shopcart;
	}

	public List<TDownload> getDownloadlist() {
		return downloadlist;
	}

	public void setDownloadlist(List<TDownload> downloadlist) {
		this.downloadlist = downloadlist;
	}

	public List<BsArticle> getTeachList() {
		return teachList;
	}

	public void setTeachList(List<BsArticle> teachList) {
		this.teachList = teachList;
	}

	public List<TSubject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<TSubject> subjectList) {
		this.subjectList = subjectList;
	}

	public TDownload getDownloaddetail() {
		return downloaddetail;
	}

	public void setDownloaddetail(TDownload downloaddetail) {
		this.downloaddetail = downloaddetail;
	}

	public List<BsArticle> getRegulationList() {
		return regulationList;
	}

	public void setRegulationList(List<BsArticle> regulationList) {
		this.regulationList = regulationList;
	}

	public List<TTeacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<TTeacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<TDictionary> getDictionaryList() {
		return dictionaryList;
	}

	public void setDictionaryList(List<TDictionary> dictionaryList) {
		this.dictionaryList = dictionaryList;
	}

	public TTeacher gettTeacherdetail() {
		return tTeacherdetail;
	}

	public void settTeacherdetail(TTeacher tTeacherdetail) {
		this.tTeacherdetail = tTeacherdetail;
	}

	public List<TDepartmentWithBLOBs> getTdepartmentList() {
		return tdepartmentList;
	}

	public void setTdepartmentList(List<TDepartmentWithBLOBs> tdepartmentList) {
		this.tdepartmentList = tdepartmentList;
	}

}
