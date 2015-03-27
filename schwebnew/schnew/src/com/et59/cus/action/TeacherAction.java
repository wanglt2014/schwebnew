package com.et59.cus.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsProductcategory;
import com.et59.cus.domain.entity.BsUser;
import com.et59.cus.domain.entity.TDictionary;
import com.et59.cus.domain.entity.TDownload;
import com.et59.cus.domain.entity.TPaper;
import com.et59.cus.domain.entity.TPrize;
import com.et59.cus.domain.entity.TResearch;
import com.et59.cus.domain.entity.TSubject;
import com.et59.cus.domain.entity.TTeacher;
import com.et59.cus.domain.entity.TTeacherPaperExample;
import com.et59.cus.domain.entity.TTeacherPaperKey;
import com.et59.cus.domain.entity.TTeacherResearchExample;
import com.et59.cus.domain.entity.TTeacherResearchKey;
import com.et59.cus.domain.entity.TTeacherSubjectExample;
import com.et59.cus.domain.entity.TTeacherSubjectKey;
import com.et59.cus.domain.entity.ex.Pager;
import com.et59.cus.dto.TPaperDTO;
import com.et59.cus.dto.TResearchDTO;
import com.et59.cus.dto.TSubjectDTO;
import com.et59.cus.tools.ComonUtil;
import com.et59.cus.tools.Constant;
import com.et59.cus.tools.DateUtil;
import com.et59.cus.tools.FileAction;

/**
 * 师资队伍
 *
 */
public class TeacherAction extends BaseAction {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	public String oldFileName;
	public String name;
	public File fileData;
	public String fileType;
	public String tampFileName;
	public String fileCount;

	public TTeacher tTeacher;

	public TPrize tPrize;

	public TResearch tResearch;

	public TSubject tSubject;

	public TPaper tPaper;

	public TSubjectDTO tSubjectDTO;

	public TResearchDTO tResearchDTO;

	public TPaperDTO tPaperDTO;

	public TPaperDTO gettPaperDTO() {
		return tPaperDTO;
	}

	public void settPaperDTO(TPaperDTO tPaperDTO) {
		this.tPaperDTO = tPaperDTO;
	}

	public TResearchDTO gettResearchDTO() {
		return tResearchDTO;
	}

	public void settResearchDTO(TResearchDTO tResearchDTO) {
		this.tResearchDTO = tResearchDTO;
	}

	public TSubjectDTO gettSubjectDTO() {
		return tSubjectDTO;
	}

	public void settSubjectDTO(TSubjectDTO tSubjectDTO) {
		this.tSubjectDTO = tSubjectDTO;
	}

	public TPrize gettPrize() {
		return tPrize;
	}

	public void settPrize(TPrize tPrize) {
		this.tPrize = tPrize;
	}

	public TResearch gettResearch() {
		return tResearch;
	}

	public void settResearch(TResearch tResearch) {
		this.tResearch = tResearch;
	}

	public TSubject gettSubject() {
		return tSubject;
	}

	public void settSubject(TSubject tSubject) {
		this.tSubject = tSubject;
	}

	public TPaper gettPaper() {
		return tPaper;
	}

	public void settPaper(TPaper tPaper) {
		this.tPaper = tPaper;
	}

	public TTeacher gettTeacher() {
		return tTeacher;
	}

	public void settTeacher(TTeacher tTeacher) {
		this.tTeacher = tTeacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOldFileName() {
		return oldFileName;
	}

	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getTampFileName() {
		return tampFileName;
	}

	public void setTampFileName(String tampFileName) {
		this.tampFileName = tampFileName;
	}

	public String getFileCount() {
		return fileCount;
	}

	public void setFileCount(String fileCount) {
		this.fileCount = fileCount;
	}

	/**
	 * 数据字典首页
	 * 
	 * @return
	 */
	public String index() {
		return "index";
	}

	/**
	 * @Title: toTeacherPage
	 * @Description: 跳转到教务教学通知
	 * @return String 返回类型
	 * @throws
	 */

	public String toTeacherPage() {
		super.commonQueryForTeacher("");
		return "to_teacher_index";
	}

	/**
	 * 分页查询师资队伍
	 */
	public void query() {
		String teachernamequery = request.getParameter("teachernamequery");
		String departmentquery = request.getParameter("departmentquery");
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			TTeacher tTeacher = new TTeacher();
			if (null != teachernamequery && !teachernamequery.equals("")) {
				tTeacher.setTeachername(teachernamequery);
			}
			if (null != departmentquery && !departmentquery.equals("")) {
				tTeacher.setDepartment(departmentquery);
			}
			Pager pager = localServiceProxy.queryTeacherBypage(tTeacher,
					Integer.valueOf(rows), Integer.valueOf(page));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询教师相关信息
	 */
	public void queryTeacherOtherInfo() {
		String teacherId = request.getParameter("teacherId");
		HashMap map = new HashMap();
		try {
			Long teacherIdLong = Long.parseLong(teacherId);
			// 加载课程
			TSubject subject = new TSubject();
			TTeacherSubjectExample example = new TTeacherSubjectExample();
			example.createCriteria().andTeacheridEqualTo(teacherIdLong);
			List<TTeacherSubjectKey> tsList = localServiceEXProxy
					.queryTTeacherSubjectKey(example);
			if (tsList != null && tsList.size() > 0) {
				subject = localServiceEXProxy.querySubjectById(tsList.get(0)
						.getSubjectid());
			}

			// 加载立项
			TResearch tResearch = new TResearch();
			TTeacherResearchExample trexample = new TTeacherResearchExample();
			trexample.createCriteria().andTeacheridEqualTo(teacherIdLong);
			List<TTeacherResearchKey> trList = localServiceEXProxy
					.queryTTeacherResearchKey(trexample);
			if (trList != null && trList.size() > 0) {
				tResearch = localServiceEXProxy.queryTResearch(trList.get(0)
						.getResearchid());
			}

			// 加载论文
			TPaper tPaper = new TPaper();
			TTeacherPaperExample tpexample = new TTeacherPaperExample();
			tpexample.createCriteria().andTeacheridEqualTo(teacherIdLong);
			List<TTeacherPaperKey> tpList = localServiceEXProxy
					.queryTTeacherPaperKey(tpexample);

			if (tpList != null && tpList.size() > 0) {
				tPaper = localServiceEXProxy.queryTPaper(tpList.get(0)
						.getPaperid());
			}

			map.put("subject", subject);
			map.put("tPaper", tPaper);
			map.put("tResearch", tResearch);

			super.reponseWriter(JSON.toJSONString(map));
			// } catch (IOException e) {
			// e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 */
	public void delete() {
		boolean flag = false;
		String id = request.getParameter("id");
		try {
			Integer i = localServiceProxy.deleteTeacher(Integer.valueOf(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		}
	}

	/**
	 * 得到教师基本信息
	 * 
	 * @return
	 */
	public TTeacher getTeacher() {
		String teachername = request.getParameter("teachername");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String department = request.getParameter("department");
		String title = request.getParameter("title");
		String job = request.getParameter("job");
		String tutortype = request.getParameter("tutortype");
		String introduction = request.getParameter("introduction");

		String departmentname = request.getParameter("departmentname");
		String titlename = request.getParameter("titlename");
		String jobname = request.getParameter("jobname");
		TTeacher tTeacher = new TTeacher();
		tTeacher.setTeachername(teachername);
		tTeacher.setSex(sex);
		tTeacher.setBirthday(birthday);
		tTeacher.setDepartment(department);
		tTeacher.setTitle(title);
		tTeacher.setJob(job);
		tTeacher.setTutortype(Integer.parseInt(tutortype));
		tTeacher.setIntroduction(introduction);
		tTeacher.setDepartmentname(departmentname);
		tTeacher.setTitlename(titlename);
		tTeacher.setJobname(jobname);
		return tTeacher;
	}

	/**
	 * 得到教师课程信息
	 * 
	 * @return
	 */
	public TSubject getSubject() {
		String subjectType = request.getParameter("subjecttype");
		String subjectNO = request.getParameter("subjectno");
		String subjectName = request.getParameter("subjectname");
		String subjectText = request.getParameter("subjecttext");
		String subjecttypename = request.getParameter("subjecttypename");
		TSubject tSubject = new TSubject();
		tSubject.setSubjecttype(subjectType);
		tSubject.setSubjectno(subjectNO);
		tSubject.setSubjectname(subjectName);
		tSubject.setSubjecttext(subjectText);
		tSubject.setSubjecttypename(subjecttypename);
		return tSubject;
	}

	/**
	 * 得到教师立项信息
	 * 
	 * @return
	 */
	public TResearch getResearch() {
		String researchlevel = request.getParameter("researchlevel");
		String researchname = request.getParameter("researchname");
		String researchno = request.getParameter("researchno");
		String researchmoney = request.getParameter("researchmoney") == "" ? "0"
				: request.getParameter("researchmoney");
		String researchmatchmoney = request.getParameter("researchmatchmoney") == "" ? "0"
				: request.getParameter("researchmatchmoney");
		String researchhost = request.getParameter("researchhost");
		String researchactor = request.getParameter("researchactor");
		String researchbegindate = request.getParameter("researchbegindate");
		String researchenddate = request.getParameter("researchenddate");
		TResearch tResearch = new TResearch();
		tResearch.setResearchlevel(researchlevel);
		tResearch.setResearchname(researchname);
		tResearch.setResearchno(researchno);
		tResearch.setResearchmoney(Integer.parseInt(researchmoney));
		tResearch.setResearchmatchmoney(Integer.parseInt(researchmatchmoney));
		tResearch.setResearchhost(researchhost);
		tResearch.setResearchactor(researchactor);
		tResearch.setResearchbegindate(researchbegindate);
		tResearch.setResearchenddate(researchenddate);

		return tResearch;
	}

	/**
	 * 得到教师论文信息
	 * 
	 * @return
	 */
	public TPaper getPaper() {
		String papername = request.getParameter("papername");
		String paperauthor = request.getParameter("paperauthor");
		String papernotename = request.getParameter("papernotename");
		String papernoteyear = request.getParameter("papernoteyear");
		String papernoteno = request.getParameter("papernoteno");

		TPaper tPaper = new TPaper();
		tPaper.setPapername(papername);
		tPaper.setPaperauthor(paperauthor);
		tPaper.setPapernotename(papernotename);
		tPaper.setPapernoteyear(papernoteyear);
		tPaper.setPapernoteno(papernoteno);
		return tPaper;
	}

	/**
	 * 得到教师获奖信息
	 * 
	 * @return
	 */
	public TPrize getPrize() {
		String papername = request.getParameter("papername");
		String paperauthor = request.getParameter("paperauthor");
		String papernotename = request.getParameter("papernotename");
		String papernoteyear = request.getParameter("papernoteyear");
		String papernoteno = request.getParameter("papernoteno");

		TPrize tPrize = new TPrize();
		return tPrize;
	}

	/**
	 * 通过类别查询数据字典
	 */
	public void queryDictionaryByType() {
		String type = request.getParameter("type");
		try {
			String name = localServiceProxy.querySupplierNameByCode(type);
			TDictionary tDictionary = new TDictionary();
			tDictionary.setDictionarytype(type);
			Pager pager = localServiceProxy.queryDictionaryBypage(tDictionary,
					100000, 1);
			super.reponseWriter(JSON.toJSONString(pager.getRows()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询产品分类名字
	 */
	public void queryproductcategroyNameByCode() {
		String code = request.getParameter("code");
		try {
			String name = localServiceProxy.queryBsProductcategoryByCode(code);
			super.reponseWriter(name);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询所有产品分类
	 */
	public void queryproductcategory() {
		try {
			BsProductcategory bsProductcategory = new BsProductcategory();
			Pager pager = localServiceProxy.queryProductcategoryBypage(
					bsProductcategory, 10000, 1);
			super.reponseWriter(JSON.toJSONString(pager.getRows()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新
	 */
	public void update() {
		boolean flag = false;
		String id = request.getParameter("id");// 教师ID
		String subjectid = request.getParameter("subjectid");
		String paperid = request.getParameter("paperid");
		String researchid = request.getParameter("researchid");

		TTeacher teacher = getTeacher();
		TSubject subject = getSubject();
		TResearch tResearch = getResearch();
		TPaper tPaper = getPaper();
		try {
			teacher.setId(Long.valueOf(id));
			localServiceProxy.updateTeacher(teacher);
			if (subjectid != null && !subjectid.isEmpty()) {
				subject.setSubjectid(Long.valueOf(subjectid));
				localServiceEXProxy.updateTSubject(subject);
			}

			if (paperid != null && !paperid.isEmpty()) {
				tPaper.setPaperid(Long.valueOf(paperid));
				localServiceEXProxy.updateTPaper(tPaper);
			}

			if (researchid != null && !researchid.isEmpty()) {
				tResearch.setResearchid(Long.valueOf(researchid));
				localServiceEXProxy.updateTResearch(tResearch);
			}

			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save() {
		boolean flag = false;
		TTeacher teacher = getTeacher();
		TSubject subject = getSubject();
		TResearch tResearch = getResearch();
		TPaper tPaper = getPaper();
		String result = "";
		long downloadid = 0l;
		String name = request.getParameter("uploader_pic_name");
		if (name != null && !name.isEmpty()) {
			String savePath = FileAction.getSavePathForTeacher();
			String extName = name.substring(name.lastIndexOf("."));
			String tampFileName = request.getParameter("uploader_pic_tmpname");
			String fileShowPath = Constant.PATH_TEACHER + "\\" + tampFileName
					+ extName;
			String filepath = savePath + "\\" + tampFileName + extName;
			teacher.setIimageurll(filepath);
		}
		try {
			// 新增教师表
			long teacherId = localServiceProxy.saveTeacher(teacher);

			// 新增附件表
			HashMap downloadIdMap = saveAllDownloadTable();

			// 新增立项，课程，论文，获奖表
			// 1.保存立项表
			tResearch.setDownloadid((Long) downloadIdMap.get("proDLId"));
			Long researchId = localServiceEXProxy.saveTResearch(tResearch);

			// 2.保存课程表
			subject.setSubjectoutline((Long) downloadIdMap.get("outlineDLId"));
			subject.setSubjectschedule((Long) downloadIdMap.get("scheduleDLId"));
			subject.setSubjectinfo((Long) downloadIdMap.get("subjectDLId"));
			subject.setSubjectteachername(teacher.getTeachername());
			subject.setSubjectisvalid(Constant.ISVALID_1);
			Long subjectId = localServiceEXProxy.saveTSubject(subject);

			// 3.保存论文表
			tPaper.setPaperdownloadid((Long) downloadIdMap.get("paperDLId"));
			Long paperId = localServiceEXProxy.saveTPaper(tPaper);

			// 4.保存获奖表

			// 新增教师关联表 立项，课程，论文，获奖
			// 1.立项关联表
			TTeacherResearchKey tTeacherResearchKey = new TTeacherResearchKey();
			tTeacherResearchKey.setTeacherid(teacherId);
			tTeacherResearchKey.setResearchid(researchId);
			localServiceEXProxy.saveTTeacherResearchKey(tTeacherResearchKey);

			// 2.课程关联表
			TTeacherSubjectKey tTeacherSubjectKey = new TTeacherSubjectKey();
			tTeacherSubjectKey.setTeacherid(teacherId);
			tTeacherSubjectKey.setSubjectid(subjectId);
			localServiceEXProxy.saveTTeacherSubjectKey(tTeacherSubjectKey);

			// 3.论文关联表
			TTeacherPaperKey tTeacherPaperKey = new TTeacherPaperKey();
			tTeacherPaperKey.setPaperid(paperId);
			tTeacherPaperKey.setTeacherid(teacherId);
			localServiceEXProxy.saveTTeacherPaperKey(tTeacherPaperKey);

			// 4.获奖关联表

			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @Title: teacherDetail
	 * @Description: 跳转到教务教学通知详细页面
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String teacherDetail() {
		super.commonquery();
		String id = request.getParameter("id");
		try {
			tTeacherdetail = localServiceProxy.queryTeacherById(Long
					.valueOf(id));
			Long teacherIdLong = Long.parseLong(id);
			// 加载课程
			TTeacherSubjectExample example = new TTeacherSubjectExample();
			example.createCriteria().andTeacheridEqualTo(teacherIdLong);
			List<TTeacherSubjectKey> tsList = localServiceEXProxy
					.queryTTeacherSubjectKey(example);
			TSubject tSubject = new TSubject();
			if (tsList != null && tsList.size() > 0) {
				tSubject = localServiceEXProxy.querySubjectById(tsList.get(0)
						.getSubjectid());
				tSubjectDTO = new TSubjectDTO();
				BeanUtils.copyProperties(tSubjectDTO, tSubject);
			}
			TDownload outlineFile = localServiceEXProxy
					.queryDownloadById(tSubject.getSubjectoutline());
			if (outlineFile != null) {
				tSubjectDTO
						.setSubjectoutlinePath(outlineFile.getFileshowpath());
				tSubjectDTO.setSubjectoutlineName(outlineFile.getFilename());
			}

			TDownload scheduleFile = localServiceEXProxy
					.queryDownloadById(tSubject.getSubjectschedule());

			if (scheduleFile != null) {
				tSubjectDTO.setSubjectschedulePath(scheduleFile
						.getFileshowpath());
			}

			TDownload infoFile = localServiceEXProxy.queryDownloadById(tSubject
					.getSubjectinfo());
			if (infoFile != null) {
				tSubjectDTO.setSubjectinfoPath(infoFile.getFileshowpath());
			}

			// 加载立项
			TTeacherResearchExample trexample = new TTeacherResearchExample();
			trexample.createCriteria().andTeacheridEqualTo(teacherIdLong);
			List<TTeacherResearchKey> trList = localServiceEXProxy
					.queryTTeacherResearchKey(trexample);
			TResearch tResearch = new TResearch();
			if (trList != null && trList.size() > 0) {
				tResearch = localServiceEXProxy.queryTResearch(trList.get(0)
						.getResearchid());
				tResearchDTO = new TResearchDTO();
				BeanUtils.copyProperties(tResearchDTO, tResearch);

			}

			TDownload researchFile = localServiceEXProxy
					.queryDownloadById(tResearch.getDownloadid());
			if (researchFile != null) {
				tResearchDTO
						.setDownloadShowPath(researchFile.getFileshowpath());
			}

			// 加载论文
			TTeacherPaperExample tpexample = new TTeacherPaperExample();
			tpexample.createCriteria().andTeacheridEqualTo(teacherIdLong);
			List<TTeacherPaperKey> tpList = localServiceEXProxy
					.queryTTeacherPaperKey(tpexample);
			TPaper tPaper = new TPaper();
			if (tpList != null && tpList.size() > 0) {
				tPaper = localServiceEXProxy.queryTPaper(tpList.get(0)
						.getPaperid());
				tPaperDTO = new TPaperDTO();
				BeanUtils.copyProperties(tPaperDTO, tPaper);
			}
			TDownload paperFile = localServiceEXProxy.queryDownloadById(tPaper
					.getPaperdownloadid());
			if (paperFile != null) {
				tPaperDTO.setPaperdownloadPath(paperFile.getFileshowpath());
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "teacher_detail";
	}

	/**
	 * 保存所有附件表
	 * 
	 * @return
	 * @throws Exception
	 */
	private HashMap saveAllDownloadTable() throws Exception {
		HashMap map = new HashMap();
		HashMap returnmap = new HashMap();
		// 1.保存立项附件
		map.put("paraName", "uploader_project_name");
		map.put("paraTmpname", "uploader_project_tmpname");
		map.put("infotype", "project");
		Long proDLId = saveTDownloadInfo(map);

		// 2.保存教学大纲附件
		map.put("paraName", "uploader_outline_name");
		map.put("paraTmpname", "uploader_outline_tmpname");
		map.put("infotype", "outline");
		Long outlineDLId = saveTDownloadInfo(map);

		// 3.保存教学进度附件
		map.put("paraName", "uploader_schedule_name");
		map.put("paraTmpname", "uploader_schedule_tmpname");
		map.put("infotype", "schedule");
		Long scheduleDLId = saveTDownloadInfo(map);

		// 4.保存课程资料附件
		map.put("paraName", "uploader_subject_name");
		map.put("paraTmpname", "uploader_subject_tmpname");
		map.put("infotype", "subject");
		Long subjectDLId = saveTDownloadInfo(map);

		// 5.保存论文附件
		map.put("paraName", "uploader_paper_name");
		map.put("paraTmpname", "uploader_paper_tmpname");
		map.put("infotype", "paper");
		Long paperDLId = saveTDownloadInfo(map);

		returnmap.put("proDLId", proDLId);
		returnmap.put("outlineDLId", outlineDLId);
		returnmap.put("scheduleDLId", scheduleDLId);
		returnmap.put("subjectDLId", subjectDLId);
		returnmap.put("paperDLId", paperDLId);
		return returnmap;
	}

	/**
	 * 保存附件并返回ID
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private Long saveTDownloadInfo(HashMap map) throws Exception {
		String name = request.getParameter((String) map.get("paraName"));
		if (name != null && !name.isEmpty()) {
			String savePath = FileAction.getSavePathForTeacher();
			String extName = name.substring(name.lastIndexOf("."));
			String tampFileName = request.getParameter((String) map
					.get("paraTmpname"));
			BsUser user = getUser();
			String filepath = savePath + "\\" + tampFileName + extName;
			String fileShowPath = Constant.PATH_TEACHER + "\\" + tampFileName
					+ extName;
			TDownload tDownload = new TDownload();
			tDownload.setAuthor(user.getUsername());
			tDownload.setCreatedate(DateUtil.getNowDate());
			tDownload.setFilename(name);
			tDownload.setFilepath(filepath);
			tDownload.setFileshowpath(fileShowPath);
			tDownload.setInfotype((String) map.get("infotype"));
			tDownload.setFileisvalid(Constant.ISVALID_1);
			return localServiceEXProxy.saveDownloadInfo(tDownload);
		} else {
			return null;
		}
	}

	/**
	 * 查询师资队伍
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String doQueryTeacher() {
		if (log.isDebugEnabled()) {
			log.debug("查询交易信息currentPage>>>>:" + currentPage);
		}
		try {
			TTeacher tTeacher = new TTeacher();
			Map map = localServiceProxy.queryTeacherByTypeForPage(tTeacher,
					Constant.PAGESIZE, currentPage);
			TDictionary tDictionary = new TDictionary();
			tDictionary.setDictionarytype("department");
			Pager pager = localServiceProxy.queryDictionaryBypage(tDictionary,
					100000, 1);
			dictionaryList = (List<TDictionary>) pager.getRows();
			if (ComonUtil.validateMapResult(map)) {
				teacherList = (List<TTeacher>) map.get(Constant.TEACHER_LIST);
				totalCount = (Integer) map.get(Constant.TOTALCOUNT);
				totalPageCount = (Integer) map.get(Constant.TOTALPAGECOUNT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "teacher_result";
	}

}
