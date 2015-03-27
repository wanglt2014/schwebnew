package com.et59.cus.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.TSubject;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;

/**
 * <p>
 * Title: 课程
 * </p>
 * <p>
 * Description:
 * </p>
 *
 */
public class SubjectAction extends BaseAction {
	/**
	 * @Fields serialVersionUID : 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * 课程详情
	 */
	protected TSubject subject;

	/**
	 * @Title: toSubjectPage
	 * @Description: 跳转到课程列表
	 * @param @return /news/news.jsp
	 * @return String 返回类型
	 * @throws
	 */

	public String toSubjectPage() {
		super.commonQueryForSubject();
		return "to_subject_index";
	}

	/**
	 * 查询课程列表
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String doQuerySubject() {
		if (log.isDebugEnabled()) {
			log.debug("查询交易信息currentPage>>>>:" + currentPage);
		}
		try {
			// TDownload download = new TDownload();
			// download.setFileisvalid(Constant.ISVALID_1);
			Map map = localServiceEXProxy.querySubjectForLimit(new TSubject(),
					Constant.PAGESIZE, currentPage);
			if (ComonUtil.validateMapResult(map)) {
				subjectList = (List<TSubject>) map.get(Constant.SUBJECT_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "subject_result";
	}

	/**
	 * @Title: downloaddetail
	 * @Description: 跳转到资料下载详细页面
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String subjectDetail() {
		super.commonQueryForSubject();
		String id = request.getParameter("id");
		try {
			// subject =
			// localServiceEXProxy.queryDownloadById(Long.valueOf(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "download_detail";
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
	 * 查询课程-分页
	 */
	public void query() {
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		// String roleNamequery = request.getParameter("roleNamequery");
		if (page == null || rows == null) {
			page = "1";
			rows = "1000";
		}
		Pager pager = new Pager();
		try {
			// TSubject tSubject = new TSubject();
			Map map = localServiceEXProxy.querySubjectForLimit(new TSubject(),
					Integer.valueOf(rows), Integer.valueOf(page));
			pager.setRows(map.get(Constant.SUBJECT_LIST));
			pager.setTotal((Integer) map.get(Constant.TOTALCOUNT));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	// bsArticle.setId(Long.valueOf(id));
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
	// bsArticle.setTitle(title);
	// bsArticle.setSummary(summary);
	// bsArticle.setType(type);
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

	public TSubject getSubject() {
		return subject;
	}

	public void setSubject(TSubject subject) {
		this.subject = subject;
	}

}
