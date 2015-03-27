package com.et59.cus.domain.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.et59.cus.domain.entity.TResearch;
import com.et59.cus.domain.entity.TResearchExample;

public class TResearchDAOImpl extends SqlMapClientDaoSupport implements
		TResearchDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public TResearchDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public int countByExample(TResearchExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_research.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public int deleteByExample(TResearchExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"t_research.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public int deleteByPrimaryKey(Long researchid) {
		TResearch key = new TResearch();
		key.setResearchid(researchid);
		int rows = getSqlMapClientTemplate().delete(
				"t_research.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public void insertSelective(TResearch record) {
		getSqlMapClientTemplate().insert(
				"t_research.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public List selectByExample(TResearchExample example) {
		List list = getSqlMapClientTemplate().queryForList(
				"t_research.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public TResearch selectByPrimaryKey(Long researchid) {
		TResearch key = new TResearch();
		key.setResearchid(researchid);
		TResearch record = (TResearch) getSqlMapClientTemplate()
				.queryForObject(
						"t_research.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public int updateByExampleSelective(TResearch record,
			TResearchExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_research.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public int updateByExample(TResearch record, TResearchExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_research.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public int updateByPrimaryKeySelective(TResearch record) {
		int rows = getSqlMapClientTemplate().update(
				"t_research.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	public int updateByPrimaryKey(TResearch record) {
		int rows = getSqlMapClientTemplate().update(
				"t_research.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds
	 * to the database table t_research
	 * 
	 * @ibatorgenerated Mon Mar 09 15:53:45 CST 2015
	 */
	private static class UpdateByExampleParms extends TResearchExample {
		private Object record;

		public UpdateByExampleParms(Object record, TResearchExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	/*
	 * 新增返回ID
	 */
	public Long insert(TResearch record) {
		return (Long) getSqlMapClientTemplate().insert(
				"t_research.ibatorgenerated_insert", record);
	}
}