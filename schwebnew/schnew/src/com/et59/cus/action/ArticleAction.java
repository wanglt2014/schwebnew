package com.et59.cus.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsArticle;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.TDownload;
import com.et59.cus.domain.entity.ex.BsArticleQuery;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.DateUtil;
import com.et59.cus.tools.FileAction;

/**
 * <p>
 * Title: 文章（教务教学通知，教学规章制度）,
 * 人才培养成果（教学获奖、教改立项、教材建设、精品课程、国际共建课程、学生展示（含历届学生保送学校、获得奖学金等））
 * </p>
 * <p>
 * Description:
 * </p>
 *
 */
public class ArticleAction extends BaseAction {
	/**
	 * @Fields serialVersionUID : 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	Logger log = Logger.getLogger(this.getClass());

	// public TDownload tDownload;

	/**
	 * 文章后台首页
	 * 
	 * @return
	 */
	public String index() {
		return "index";
	}

	/**
	 * 人才培养成果后台首页
	 * 
	 * @return
	 */
	public String trainingResultsIndex() {
		return "trainingResults_index";
	}

	/**
	 * @Title: toTeacherPage
	 * @Description: 跳转到教务教学通知
	 * @return String 返回类型
	 * @throws
	 */

	public String toNoticePage() {
		super.commonQueryForArticle(1);
		return "to_notice_index";
	}

	/**
	 * @Title: toRegulationPage
	 * @Description: 跳转到教务教学制度
	 * @return String 返回类型
	 * @throws
	 */

	public String toRegulationPage() {
		super.commonQueryForArticle(2);
		return "to_regulation_index";
	}

	/**
	 * @Title: toRegulationPage
	 * @Description: 跳转到教务教学制度
	 * @return String 返回类型
	 * @throws
	 */

	public String toTrainingResultPage() {
		super.commonQueryForArticle(3);
		return "to_trainingResult_index";
	}

	/**
	 * 查询教务教学通知
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String doQueryTeach() {
		if (log.isDebugEnabled()) {
			log.debug("查询交易信息currentPage>>>>:" + currentPage);
		}
		try {
			BsArticleQuery bsArticle = new BsArticleQuery();
			bsArticle.setArticletype(Constant.ARTICLE_TYPE_NOTICE);
			Map map = localServiceProxy.queryArticleByTypeForPage(bsArticle,
					Constant.PAGESIZE, currentPage);
			if (ComonUtil.validateMapResult(map)) {
				bsArticlelist = (List<BsArticle>) map
						.get(Constant.ARTICLE_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "notice_result";
	}

	/**
	 * 查询教务教学制度
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String doQueryRegulation() {
		if (log.isDebugEnabled()) {
			log.debug("查询交易信息currentPage>>>>:" + currentPage);
		}
		try {
			BsArticleQuery bsArticle = new BsArticleQuery();
			bsArticle.setArticletype(Constant.ARTICLE_TYPE_REGULATION);
			Map map = localServiceProxy.queryArticleByTypeForPage(bsArticle,
					Constant.PAGESIZE, currentPage);
			if (ComonUtil.validateMapResult(map)) {
				bsArticlelist = (List<BsArticle>) map
						.get(Constant.ARTICLE_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "regulation_result";
	}

	/**
	 * @Title: teachDetail
	 * @Description: 跳转到教务教学通知详细页面
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String teachDetail() {
		super.commonquery();
		String id = request.getParameter("id");
		try {
			bsArticledetail = localServiceProxy.queryArticleById(Long
					.valueOf(id));

			if (bsArticledetail.getDownloadid() != null) {
				TDownload download = localServiceEXProxy
						.queryDownloadById(bsArticledetail.getDownloadid());
				bsArticledetail.setDownload(download);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "notice_detail";
	}

	/**
	 * @Title: regulationDetail
	 * @Description: 跳转到教务教学制度详细页面
	 * @return String 返回类型
	 * @throws
	 */
	public String regulationDetail() {
		super.commonquery();
		String id = request.getParameter("id");
		try {
			bsArticledetail = localServiceProxy.queryArticleById(Long
					.valueOf(id));

			downloaddetail = localServiceEXProxy
					.queryDownloadById(bsArticledetail.getDownloadid());

			bsArticledetail.setDownload(downloaddetail);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "regulation_detail";
	}

	/**
	 * 查询文章-后台
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void query() {
		String startdatacreatenew = request.getParameter("startdatacreatenew");
		String enddatacreatenew = request.getParameter("enddatacreatenew");
		String newtype = request.getParameter("newtype");
		String newauthor = request.getParameter("newauthor");
		String newtitle = request.getParameter("newtitle");
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			BsArticleQuery bsArticle = new BsArticleQuery();
			if (null != startdatacreatenew && !startdatacreatenew.equals("")) {
				bsArticle.setStartdatacreatenew(DateUtil
						.strToDate(startdatacreatenew));
			}
			if (null != enddatacreatenew && !enddatacreatenew.equals("")) {
				bsArticle.setEnddatacreatenew(DateUtil
						.strToDate(enddatacreatenew));
			}
			if (null != newtype && !newtype.equals("")) {
				bsArticle.setArticletype(newtype);
			}
			if (null != newauthor && !newauthor.equals("")) {
				bsArticle.setAuthor(newauthor);
			}
			if (null != newtitle && !newtitle.equals("")) {
				bsArticle.setArticletitle(newtitle);
			}
			// bsArticle.setMenuType("article");
			Pager pager = new Pager();
			Map map = localServiceProxy.queryArticleByTypeForPage(bsArticle,
					Integer.valueOf(rows), Integer.valueOf(page));
			if (ComonUtil.validateMapResult(map)) {
				bsArticlelist = (List<BsArticle>) map
						.get(Constant.ARTICLE_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
				pager.setTotal(totalCount);
				pager.setRows(bsArticlelist);
			}
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存文章
	 */
	public void save() {
		boolean flag = false;
		BsArticle bsArticle = getBsArticle();
		try {
			String savePath = FileAction.getSavePathForArticle();
			String name = request.getParameter("uploader_name");
			if (name != null) {
				String extName = name.substring(name.lastIndexOf("."));
				String tampFileName = request.getParameter("uploader_tmpname");
				BsUser user = getUser();
				String filepath = savePath + "\\" + tampFileName + extName;
				String fileShowPath = Constant.PATH_ARTICLE + "\\"
						+ tampFileName + extName;
				TDownload tDownload = new TDownload();
				tDownload.setAuthor(user.getUsername());
				tDownload.setCreatedate(DateUtil.getNowDate());
				tDownload.setFilename(name);
				tDownload.setFilepath(filepath);
				tDownload.setFileshowpath(fileShowPath);
				tDownload.setInfotype(bsArticle.getArticletype());
				tDownload.setFileisvalid(Constant.ISVALID_1);
				Long downloadId = localServiceEXProxy
						.saveDownloadInfo(tDownload);
				System.out.println(downloadId + "******downloadId" + "路径："
						+ filepath);
				bsArticle.setDownloadid(downloadId);
			}
			localServiceProxy.saveArticle(bsArticle);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编辑文章
	 */
	public void update() {
		boolean flag = false;
		String id = request.getParameter("id");
		BsArticle bsArticle = getBsArticle();
		bsArticle.setArticleid(Long.valueOf(id));
		try {
			localServiceProxy.updateArticle(bsArticle);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 公共方法
	 * 
	 * @return
	 */
	public BsArticle getBsArticle() {
		String title = request.getParameter("articletitle");
		String createdate = request.getParameter("createdate");
		String author = request.getParameter("author");
		String type = request.getParameter("articletypeInsert");
		String summary = request.getParameter("articlesummary");
		String content = request.getParameter("content");
		BsArticle bsArticle = new BsArticle();
		bsArticle.setArticletitle(title);
		bsArticle.setArticlesummary(summary);
		bsArticle.setArticletype(type);
		bsArticle.setContent(content);
		bsArticle.setUpdatedate(DateUtil.getNowDate());
		bsArticle.setCreatedate(createdate);
		bsArticle.setAuthor(author);
		return bsArticle;
	}

	/**
	 * 删除文章
	 */
	public void deleteArticle() {
		boolean flag = false;
		String id = request.getParameter("id");
		try {
			localServiceProxy.deleteArticle(Long.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询人才培养成果
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void queryTrainingResults() {
		String startdatacreatenew = request.getParameter("startdatacreatenew");
		String enddatacreatenew = request.getParameter("enddatacreatenew");
		String newtype = request.getParameter("type");
		String newauthor = request.getParameter("author");
		String newtitle = request.getParameter("title");
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			BsArticleQuery bsArticle = new BsArticleQuery();
			if (null != startdatacreatenew && !startdatacreatenew.equals("")) {
				bsArticle.setStartdatacreatenew(DateUtil
						.strToDate(startdatacreatenew));
			}
			if (null != enddatacreatenew && !enddatacreatenew.equals("")) {
				bsArticle.setEnddatacreatenew(DateUtil
						.strToDate(enddatacreatenew));
			}
			if (null != newtype && !newtype.equals("")) {
				bsArticle.setArticletype(newtype);
			}
			if (null != newauthor && !newauthor.equals("")) {
				bsArticle.setAuthor(newauthor);
			}
			if (null != newtitle && !newtitle.equals("")) {
				bsArticle.setArticletitle(newtitle);
			}

			// bsArticle.setMenuType("result");
			Pager pager = new Pager();
			Map map = localServiceProxy.queryArticleByTypeForPage(bsArticle,
					Integer.valueOf(rows), Integer.valueOf(page));
			if (ComonUtil.validateMapResult(map)) {
				bsArticlelist = (List<BsArticle>) map
						.get(Constant.ARTICLE_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
				pager.setTotal(totalCount);
				pager.setRows(bsArticlelist);
			}
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 人才培养成果
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String doQueryTrainingResult() {
		if (log.isDebugEnabled()) {
			log.debug("查询交易信息currentPage>>>>:" + currentPage);
		}
		try {
			BsArticleQuery bsArticle = new BsArticleQuery();
			// bsArticle.setArticletype(Constant.ARTICLE_TYPE_NOTICE);
			bsArticle.setMenuType("result");
			Map map = localServiceProxy.queryArticleByTypeForPage(bsArticle,
					Constant.PAGESIZE, currentPage);
			if (ComonUtil.validateMapResult(map)) {
				bsArticlelist = (List<BsArticle>) map
						.get(Constant.ARTICLE_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "trainingResult_result";
	}

	/**
	 * @Title: trainingResultDetail
	 * @Description: 跳转到人才培养成果详细页面
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String trainingResultDetail() {
		super.commonquery();
		String id = request.getParameter("id");
		try {
			bsArticledetail = localServiceProxy.queryArticleById(Long
					.valueOf(id));

			if (bsArticledetail.getDownloadid() != null) {
				TDownload download = localServiceEXProxy
						.queryDownloadById(bsArticledetail.getDownloadid());
				bsArticledetail.setDownload(download);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "trainingResult_detail";
	}

	/**
	 * 保存人才培养成果
	 */
	public void saveTrainingResult() {
		boolean flag = false;
		BsArticle bsArticle = getBsArticleForResult();
		try {
			String savePath = FileAction.getSavePathForArticle();
			String name = request.getParameter("uploader_nameForResult");
			if (name != null) {
				String extName = name.substring(name.lastIndexOf("."));
				String tampFileName = request
						.getParameter("uploader_tmpnameForResult");
				BsUser user = getUser();
				String filepath = savePath + "\\" + tampFileName + extName;
				String fileShowPath = Constant.PATH_ARTICLE + "\\"
						+ tampFileName + extName;
				TDownload tDownload = new TDownload();
				tDownload.setAuthor(user.getUsername());
				tDownload.setCreatedate(DateUtil.getNowDate());
				tDownload.setFilename(name);
				tDownload.setFilepath(filepath);
				tDownload.setFileshowpath(fileShowPath);
				tDownload.setInfotype(bsArticle.getArticletype());
				tDownload.setFileisvalid(Constant.ISVALID_1);
				Long downloadId = localServiceEXProxy
						.saveDownloadInfo(tDownload);
				System.out.println(downloadId + "******downloadId" + "路径："
						+ filepath);
				bsArticle.setDownloadid(downloadId);
			}
			localServiceProxy.saveArticle(bsArticle);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编辑人才培养成果
	 */
	public void updateTrainingResult() {
		boolean flag = false;
		String id = request.getParameter("id");
		BsArticle bsArticle = getBsArticleForResult();
		bsArticle.setArticleid(Long.valueOf(id));
		try {
			localServiceProxy.updateArticle(bsArticle);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 公共方法
	 * 
	 * @return
	 */
	public BsArticle getBsArticleForResult() {
		String title = request.getParameter("articletitleForResult");
		String createdate = request.getParameter("createdateForResult");
		String author = request.getParameter("authorForResult");
		String type = request.getParameter("articletypeInsert");
		String summary = request.getParameter("articlesummaryForResult");
		String content = request.getParameter("contentForResult");
		BsArticle bsArticle = new BsArticle();
		bsArticle.setArticletitle(title);
		bsArticle.setArticlesummary(summary);
		bsArticle.setArticletype(type);
		bsArticle.setContent(content);
		bsArticle.setUpdatedate(DateUtil.getNowDate());
		bsArticle.setCreatedate(createdate);
		bsArticle.setAuthor(author);
		return bsArticle;
	}

	public static void main(String[] args) throws Exception {

		System.out.println(Thread.currentThread().getContextClassLoader()
				.getResource(""));

		System.out
				.println(ArticleAction.class.getClassLoader().getResource(""));

		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println(ArticleAction.class.getResource(""));
		System.out.println(ArticleAction.class.getResource("/")); // Class文件所在路径
		System.out.println(new File("/").getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
	}
}
