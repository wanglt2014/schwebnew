package com.et59.cus.service;

import java.util.List;
import java.util.Map;

import com.et59.cus.domain.entity.TDepartment;
import com.et59.cus.domain.entity.TDepartmentWithBLOBs;
import com.et59.cus.domain.entity.TDownload;
import com.et59.cus.domain.entity.TPaper;
import com.et59.cus.domain.entity.TResearch;
import com.et59.cus.domain.entity.TSubject;
import com.et59.cus.domain.entity.TTeacherPaperExample;
import com.et59.cus.domain.entity.TTeacherPaperKey;
import com.et59.cus.domain.entity.TTeacherPrizeKey;
import com.et59.cus.domain.entity.TTeacherResearchExample;
import com.et59.cus.domain.entity.TTeacherResearchKey;
import com.et59.cus.domain.entity.TTeacherSubjectExample;
import com.et59.cus.domain.entity.TTeacherSubjectKey;
import com.et59.cus.domain.entity.TTrainingplan;
import com.et59.cus.domain.entity.TTrainingplanExample;
import com.et59.cus.domain.entity.ex.Pager;

/**
 * <p>
 * Title: LocalService.java
 * </p>
 * <p>
 * Description:
 * </p>
 *
 */
public interface LocalServiceEX {
	// 资料下载
	@SuppressWarnings("rawtypes")
	public Map queryDownloadInfoForLimit(TDownload download, int pagesize,
			int currentpage) throws Exception;

	/**
	 * 查询资料byid
	 */
	@SuppressWarnings("rawtypes")
	public TDownload queryDownloadById(long id) throws Exception;

	/**
	 * 查询课程列表
	 */
	@SuppressWarnings("rawtypes")
	public Map querySubjectForLimit(TSubject subject, int pagesize,
			int currentpage) throws Exception;

	/**
	 * 查询课程byid
	 */
	@SuppressWarnings("rawtypes")
	public TSubject querySubjectById(long id) throws Exception;

	/**
	 * 保存资料
	 */
	@SuppressWarnings("rawtypes")
	public Long saveDownloadInfo(TDownload tDownload) throws Exception;

	/**
	 * 修改资料
	 */
	@SuppressWarnings("rawtypes")
	public void updateDownloadInfo(TDownload tDownload) throws Exception;

	/**
	 * 删除资料
	 */
	@SuppressWarnings("rawtypes")
	public void deleteDownloadInfo(long id) throws Exception;

	/**
	 * 保存立项表
	 */
	@SuppressWarnings("rawtypes")
	public Long saveTResearch(TResearch tResearch) throws Exception;

	/**
	 * 保存课程表
	 */
	@SuppressWarnings("rawtypes")
	public Long saveTSubject(TSubject tSubject) throws Exception;

	/**
	 * 保存论文表
	 */
	@SuppressWarnings("rawtypes")
	public Long saveTPaper(TPaper tPaper) throws Exception;

	/**
	 * 保存立项关联表
	 */
	@SuppressWarnings("rawtypes")
	public void saveTTeacherResearchKey(TTeacherResearchKey tTeacherResearchKey)
			throws Exception;

	/**
	 * 保存课程关联表
	 */
	@SuppressWarnings("rawtypes")
	public void saveTTeacherSubjectKey(TTeacherSubjectKey tTeacherSubjectKey)
			throws Exception;

	/**
	 * 保存论文关联表
	 */
	@SuppressWarnings("rawtypes")
	public void saveTTeacherPaperKey(TTeacherPaperKey tTeacherPaperKey)
			throws Exception;

	/**
	 * 保存获奖关联表
	 */
	@SuppressWarnings("rawtypes")
	public void saveTTeacherPrizeKey(TTeacherPrizeKey tTeacherPrizeKey)
			throws Exception;

	/**
	 * 查询论文表
	 */
	@SuppressWarnings("rawtypes")
	public TPaper queryTPaper(Long paperid) throws Exception;

	/**
	 * 查询立项关联表
	 */
	@SuppressWarnings("rawtypes")
	public List queryTTeacherResearchKey(TTeacherResearchExample example)
			throws Exception;

	/**
	 * 查询课程关联表
	 */
	@SuppressWarnings("rawtypes")
	public List queryTTeacherSubjectKey(TTeacherSubjectExample example)
			throws Exception;

	/**
	 * 查询立项表
	 */
	@SuppressWarnings("rawtypes")
	public TResearch queryTResearch(Long researchid) throws Exception;

	/**
	 * 查询论文关联表
	 */
	@SuppressWarnings("rawtypes")
	public List queryTTeacherPaperKey(TTeacherPaperExample example)
			throws Exception;

	/**
	 * 更新立项表
	 */
	@SuppressWarnings("rawtypes")
	public void updateTResearch(TResearch tResearch) throws Exception;

	/**
	 * 更新课程表
	 */
	@SuppressWarnings("rawtypes")
	public void updateTSubject(TSubject tSubject) throws Exception;

	/**
	 * 更新论文表
	 */
	@SuppressWarnings("rawtypes")
	public void updateTPaper(TPaper tPaper) throws Exception;

	/**
	 * 专业查询--（人才培养方案）
	 */
	@SuppressWarnings("rawtypes")
	public Pager queryTDepartmentBypage(TDepartment tDepartment, int pagesize,
			int currentpage) throws Exception;

	/**
	 * 保存专业表
	 */
	@SuppressWarnings("rawtypes")
	public void saveTDepartmentWithBLOBs(
			TDepartmentWithBLOBs tDepartmentWithBLOBs) throws Exception;

	/**
	 * 编辑专业表
	 */
	@SuppressWarnings("rawtypes")
	public void updateTDepartmentWithBLOBs(
			TDepartmentWithBLOBs tDepartmentWithBLOBs) throws Exception;

	/**
	 * 删除专业表
	 */
	@SuppressWarnings("rawtypes")
	public void deleteTDepartment(long id) throws Exception;

	/**
	 * 删除方案表
	 */
	@SuppressWarnings("rawtypes")
	public void deleteTTrainingplan(TTrainingplanExample example)
			throws Exception;

	/**
	 * 查询专业表
	 */
	@SuppressWarnings("rawtypes")
	public TDepartmentWithBLOBs queryTDepartment(long id) throws Exception;

	/**
	 * 保存方案表
	 */
	@SuppressWarnings("rawtypes")
	public void saveTTrainingplan(TTrainingplan tTrainingplan) throws Exception;

	/**
	 * 查询方案表
	 */
	@SuppressWarnings("rawtypes")
	public List<TTrainingplan> queryTTrainingplan(TTrainingplanExample example)
			throws Exception;

}
