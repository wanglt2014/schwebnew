package com.et59.cus.tools;

/**
 * <p>
 * Title: Constant.java
 * </p>
 * <p>
 * Description:
 * </p>
 *
 */
public class Constant {
	public static String FILE_SAVE_PATH = "C:\\schoolfile";
	public static String ACTION_RESULT = "ACTION_RESULT"; // 结果
	public static int RESULT_SUCCESS = 0; // 结果为成功
	public static int RESULT_FAIL = 1; // 结果为失败
	public static String USER = "USER"; // 结果为失败
	public static String EMAIL = "EMAIL"; // 结果为失败
	public static String PRODUCT_LIST = "PRODUCT_LIST"; // 产品列表
	public static String SUPPLIERCODE = "SUPPLIERCODE";// 供应商代码
	public static String TOTALPAGECOUNT = "TOTALPAGECOUNT";// 总记录数
	public static String TOTALCOUNT = "TOTALCOUNT";// 总记录数
	public static int PAGESIZE = 10;// 默认分页大小
	public static String PRODUCT_OBJ = "PRODUCT_OBJ";// product对象
	public static String ORDER_OBJ = "ORDER_OBJ";// product对象
	public static String BSUSERSERVICE_OBJ = "BSUSERSERVICE_OBJ";// BSUSERSERVICE_OBJ对象
	public static int ORDER_STATUS_UNPAY = 1;// 订单未支付
	public static int ORDER_STATUS_PAY = 2;// 订单已支付支付
	public static String ORDER_LIST = "ORDER_LIST";// 订单list
	public static String BSUSERSERVICE_LIST = "BSUSERSERVICE_LIST";
	public static String KEY = "123456789";
	public static String DEFAULT_PASSWORD = "123456";
	public static String ISACTIVE_YES = "yes";
	public static String ISACTIVE_NO = "no";
	/**
	 * 是，启用
	 */
	public static String ISVALID_1 = "1";//

	/**
	 * 否，未启用
	 */
	public static String ISVALID_0 = "0";//

	public static String PATH_TEACHER = "uploadFile\\teacher";
	public static String PATH_OTHER = "uploadFile\\other";
	public static String PATH_ARTICLE = "uploadFile\\article";
	public static String PATH_DOWNLOADINFO = "uploadFile\\downloadinfo";

	public static String DOWNLOAD_LIST = "DOWNLOAD_LIST"; // 资料下载列表
	public static String SUBJECT_LIST = "SUBJECT_LIST"; // 课程列表
	/**
	 * 过期时间2个月
	 */
	public static long TOKEN_EXPIRES = 2 * 30 * 24 * 60 * 60;
	/**
	 * 咨询
	 */
	public static String ARTICLE_TYPE_NEWS = "news";
	/**
	 * 教务教学通知
	 */
	public static String ARTICLE_TYPE_NOTICE = "notice";

	/**
	 * 教务教学制度
	 */
	public static String ARTICLE_TYPE_REGULATION = "regulation";
	/**
	 * 行业新闻
	 */
	public static String ARTICLE_TYPE_MEDIA = "media";

	/**
	 * 教学获奖
	 */
	public static String ARTICLE_TYPE_TEACH = "teach";

	/**
	 * 教改立项
	 */
	public static String ARTICLE_TYPE_REFORM = "reform";

	/**
	 * 教材建设
	 */
	public static String ARTICLE_TYPE_CONSTRUCTION = "construction";

	/**
	 * 精品课程
	 */
	public static String ARTICLE_TYPE_COURSE = "course";

	/**
	 * 国际共建课程
	 */
	public static String ARTICLE_TYPE_BUILD_COURSE = "build_course";

	/**
	 * 学生展示（含历届学生保送学校、获得奖学金等）
	 */
	public static String ARTICLE_TYPE_STUDENT = "student";
	/**
	 * 文章类表
	 */
	public static String ARTICLE_LIST = "ARTICLE_LIST";

	/**
	 * 师资队伍
	 */
	public static String TEACHER_LIST = "TEACHER_LIST";

	/**
	 * 文章详情
	 */
	public static String ARTICLE_DETAIL = "ARTICLE_DETAIL";
	/**
	 * 公共资源
	 */
	public static String RESOURCE_PUBLIC = "public";
	/**
	 * 私有资源
	 */
	public static String RESOURCE_PRIVATE = "private";
	/**
	 * 受保护的资源
	 */
	public static String RESOURCE_PROTECT = "protect";
	/**
	 * 购物车
	 */
	public static String SHOP_CART = "shop_cart";
}
