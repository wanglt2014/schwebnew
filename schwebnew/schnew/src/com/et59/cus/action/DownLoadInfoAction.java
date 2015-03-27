package com.et59.cus.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.TDownload;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.FileAction;

/**
 * <p>
 * Title: 资料下载
 * </p>
 * <p>
 * Description:
 * </p>
 *
 */
public class DownLoadInfoAction extends BaseAction {
	/**
	 * @Fields serialVersionUID : 序列化ID
	 */
	private static final long serialVersionUID = -8219690726666214883L;

	Logger log = Logger.getLogger(this.getClass());

	/**
	 * 资料下载详情
	 */
	protected TDownload downloaddetail;

	/**
	 * @Title: toNewsPage
	 * @Description: 跳转到新闻中心
	 * @param @return /news/news.jsp
	 * @return String 返回类型
	 * @throws
	 */

	public String toDownloadPage() {
		super.commonqueryDownload();
		return "to_download_index";
	}

	/**
	 * 查询资料下载
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String doqueryDownload() {
		if (log.isDebugEnabled()) {
			log.debug("查询交易信息currentPage>>>>:" + currentPage);
		}
		try {
			// TDownload download = new TDownload();
			// download.setFileisvalid(Constant.ISVALID_1);
			Map map = localServiceEXProxy.queryDownloadInfoForLimit(
					new TDownload(), Constant.PAGESIZE, currentPage);
			if (ComonUtil.validateMapResult(map)) {
				downloadlist = (List<TDownload>) map
						.get(Constant.DOWNLOAD_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "download_result";
	}

	/**
	 * @Title: downloaddetail
	 * @Description: 跳转到资料下载详细页面
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String downloaddetail() {
		super.commonqueryDownload();
		String id = request.getParameter("id");
		try {
			downloaddetail = localServiceEXProxy.queryDownloadById(Long
					.valueOf(id));
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
	 * 查询资料下载（后台）
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void query() {
		String downloadauthor = request.getParameter("downloadauthor");
		String filename = request.getParameter("filename");
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			TDownload tDownload = new TDownload();
			if (null != downloadauthor && !downloadauthor.equals("")) {
				tDownload.setAuthor(downloadauthor);
			}
			if (null != filename && !filename.equals("")) {
				tDownload.setFilename(filename);
			}
			Pager pager = new Pager();
			Map map = localServiceEXProxy.queryDownloadInfoForLimit(tDownload,
					Integer.valueOf(rows), Integer.valueOf(page));
			if (ComonUtil.validateMapResult(map)) {
				downloadlist = (List<TDownload>) map
						.get(Constant.DOWNLOAD_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
				pager.setTotal(totalCount);
				pager.setRows(downloadlist);
			}
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存资料
	 */
	public void save() {
		boolean flag = false;
		String savePath = FileAction.getSavePathForOther();
		String name = request.getParameter("uploader_name");
		String extName = name.substring(name.lastIndexOf("."));
		String tampFileName = request.getParameter("uploader_tmpname");
		BsUser user = getUser();
		String filepath = savePath + "\\" + tampFileName + extName;
		String fileShowPath = Constant.PATH_OTHER + "\\" + tampFileName
				+ extName;
		try {
			downloaddetail.setFilepath(filepath);
			downloaddetail.setFileshowpath(fileShowPath);
			downloaddetail.setFileisvalid(Constant.ISVALID_1);
			localServiceEXProxy.saveDownloadInfo(downloaddetail);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编辑资料
	 */
	public void update() {
		boolean flag = false;
		String id = request.getParameter("id");
		TDownload downloaddetail = getTDownload();
		downloaddetail.setDownloadid(Long.valueOf(id));
		try {
			localServiceEXProxy.updateDownloadInfo(downloaddetail);
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
	public TDownload getTDownload() {
		String filename = request.getParameter("filename");
		String author = request.getParameter("author");
		String directions = request.getParameter("directions");
		String createdate = request.getParameter("createdate");
		TDownload tDownload = new TDownload();
		tDownload.setAuthor(author);
		tDownload.setFilename(filename);
		tDownload.setCreatedate(createdate);
		tDownload.setDirections(directions);
		return tDownload;
	}

	/**
	 * 删除资料
	 */
	public void deleteDownloadInfo() {
		boolean flag = false;
		String id = request.getParameter("id");
		try {
			localServiceEXProxy.deleteDownloadInfo(Long.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TDownload getDownloaddetail() {
		return downloaddetail;
	}

	public void setDownloaddetail(TDownload downloaddetail) {
		this.downloaddetail = downloaddetail;
	}

}
