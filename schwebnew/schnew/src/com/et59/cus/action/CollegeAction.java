package com.et59.cus.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.et59.cus.cache.Cache;
import com.et59.cus.domain.dao.TCollegeDAO;
import com.et59.cus.domain.entity.TCollege;
import com.et59.cus.domain.entity.TCollegeExample;

/**
 * <p>
 * Title: 学院简介、院系介绍
 * </p>
 * <p>
 * Description:
 * </p>
 *
 */
public class CollegeAction extends BaseAction {
	/**
	 * @Fields serialVersionUID : 序列化ID
	 */
	private static final long serialVersionUID = 6519224642223458994L;

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * 院系介绍，学院简介
	 */
	protected TCollege college;

	@Autowired
	private TCollegeDAO tCollegeDAO;

	/**
	 * 院系列表
	 */
	protected List<TCollege> collegelist;

	/**
	 * 院系介绍，学院简介
	 */
	protected String introduction;

	/**
	 * @Title: toCollegePage
	 * @Description: 跳转到院系介绍列表页
	 * @return college\collegeList.jsp
	 * @return String 返回类型
	 * @throws
	 */
	public String toCollegePage() {
		// super.commonqueryDownload();
		TCollegeExample example = new TCollegeExample();
		example.createCriteria().andCollegelevelEqualTo("2");
		example.setOrderByClause(" collegeorder ");
		// college = (TCollege) Cache.getInstance().get("summary");
		// if (null == college) {
		collegelist = tCollegeDAO.selectByExample(example);
		// Cache.getInstance().put("summary", college);
		// }
		TCollege college = (TCollege) Cache.getInstance().get("summary");
		if (null == college) {
			example.createCriteria().andCollegelevelEqualTo("1");
			college = (TCollege) tCollegeDAO.selectByExample(example).get(0);
			Cache.getInstance().put("summary", college);
		}
		introduction = college.getCollegeintroduction();
		return "to_college_index";
	}

	/**
	 * 跳转到学院简介
	 * 
	 * @return
	 */
	public String toCollegeSummaryPage() {
		TCollegeExample example = new TCollegeExample();
		example.createCriteria().andCollegelevelEqualTo("1");
		college = (TCollege) Cache.getInstance().get("summary");
		if (null == college) {
			college = (TCollege) tCollegeDAO.selectByExample(example).get(0);
			Cache.getInstance().put("summary", college);
		}
		return "to_college_summary";
	}

	/**
	 * @Title: collegeDetail
	 * @Description: 跳转到详细页面
	 * @return String 返回类型
	 * @throws
	 */
	public String collegeDetail() {
		// super.commonqueryDownload();
		String id = request.getParameter("id");
		try {
			TCollegeExample example = new TCollegeExample();
			example.createCriteria().andCollegelevelEqualTo("2")
					.andIdEqualTo(Long.valueOf(id));
			college = (TCollege) tCollegeDAO.selectByExample(example).get(0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "college_detail";
	}

	/**
	 * 新闻后台首页
	 * 
	 * @return
	 */
	public String index() {
		return "index";
	}

	/**
	 * 需要简介后台首页
	 * 
	 * @return
	 */
	public String summary() {
		return "summary";
	}

	// /**
	// * 查询新闻
	// */
	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// public void query() {
	// String startdatacreatenew = request.getParameter("startdatacreatenew");
	// String enddatacreatenew = request.getParameter("enddatacreatenew");
	// String newtype = request.getParameter("newtype");
	// String newauthor = request.getParameter("newauthor");
	// String newtitle = request.getParameter("newtitle");
	// String page = request.getParameter("page"); // 当前页数
	// String rows = request.getParameter("rows"); // 每页显示行数
	// try {
	// BsArticleQuery bsArticle = new BsArticleQuery();
	// if (null != startdatacreatenew && !startdatacreatenew.equals("")) {
	// bsArticle.setStartdatacreatenew(DateUtil
	// .strToDate(startdatacreatenew));
	// }
	// if (null != enddatacreatenew && !enddatacreatenew.equals("")) {
	// bsArticle.setEnddatacreatenew(DateUtil
	// .strToDate(enddatacreatenew));
	// }
	// if (null != newtype && !newtype.equals("")) {
	// bsArticle.setArticletype(newtype);
	// }
	// if (null != newauthor && !newauthor.equals("")) {
	// bsArticle.setAuthor(newauthor);
	// }
	// if (null != newtitle && !newtitle.equals("")) {
	// bsArticle.setArticletitle(newtitle);
	// }
	// Pager pager = new Pager();
	// Map map = localServiceProxy.queryArticleByTypeForPage(bsArticle,
	// Integer.valueOf(rows), Integer.valueOf(page));
	// if (ComonUtil.validateMapResult(map)) {
	// bsArticlelist = (List<BsArticle>) map
	// .get(Constant.ARTICLE_LIST);
	// totalCount = (Integer) map.get(Constant.TOTALCOUNT);
	// totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
	// pager.setTotal(totalCount);
	// pager.setRows(bsArticlelist);
	// }
	// super.reponseWriter(JSON.toJSONString(pager));
	// } catch (IOException e) {
	// e.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * 保存文章
	// */
	// public void save() {
	// boolean flag = false;
	// BsArticle bsArticle = getBsArticle();
	// try {
	// localServiceProxy.saveArticle(bsArticle);
	// flag = true;
	// super.reponseWriter(JSON.toJSONString(flag));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * 编辑文章
	// */
	// public void update() {
	// boolean flag = false;
	// String id = request.getParameter("id");
	// BsArticle bsArticle = getBsArticle();
	// bsArticle.setArticleid(Long.valueOf(id));
	// try {
	// localServiceProxy.updateArticle(bsArticle);
	// flag = true;
	// super.reponseWriter(JSON.toJSONString(flag));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * 公共方法
	// *
	// * @return
	// */
	// public BsArticle getBsArticle() {
	// String title = request.getParameter("title");
	// String createdate = request.getParameter("createdate");
	// String author = request.getParameter("author");
	// String type = request.getParameter("type");
	// String summary = request.getParameter("summary");
	// String content = request.getParameter("content");
	// BsArticle bsArticle = new BsArticle();
	// bsArticle.setArticletitle(title);
	// bsArticle.setArticlesummary(summary);
	// bsArticle.setArticletype(type);
	// bsArticle.setContent(content);
	// bsArticle.setUpdatedate(new Date());
	// bsArticle.setCreatedate(DateUtil.strToDate(createdate));
	// bsArticle.setAuthor(author);
	// return bsArticle;
	// }
	//
	// /**
	// * 删除文章
	// */
	// public void deleteArticle() {
	// boolean flag = false;
	// String id = request.getParameter("id");
	// try {
	// localServiceProxy.deleteArticle(Long.valueOf(id));
	// flag = true;
	// super.reponseWriter(JSON.toJSONString(flag));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public TCollege getCollege() {
		return college;
	}

	public void setCollege(TCollege college) {
		this.college = college;
	}

	public List<TCollege> getCollegelist() {
		return collegelist;
	}

	public void setCollegelist(List<TCollege> collegelist) {
		this.collegelist = collegelist;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
