package com.et59.cus.domain.dao;

import com.et59.cus.domain.entity.TDictionary;
import com.et59.cus.domain.entity.TDictionaryExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TDictionaryDAOImpl extends SqlMapClientDaoSupport implements TDictionaryDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public TDictionaryDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public int countByExample(TDictionaryExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"t_dictionary.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public int deleteByExample(TDictionaryExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"t_dictionary.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public int deleteByPrimaryKey(Integer dictionaryid) {
		TDictionary key = new TDictionary();
		key.setDictionaryid(dictionaryid);
		int rows = getSqlMapClientTemplate().delete(
				"t_dictionary.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public void insert(TDictionary record) {
		getSqlMapClientTemplate().insert("t_dictionary.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public void insertSelective(TDictionary record) {
		getSqlMapClientTemplate().insert(
				"t_dictionary.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public List selectByExample(TDictionaryExample example) {
		List list = getSqlMapClientTemplate().queryForList(
				"t_dictionary.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public TDictionary selectByPrimaryKey(Integer dictionaryid) {
		TDictionary key = new TDictionary();
		key.setDictionaryid(dictionaryid);
		TDictionary record = (TDictionary) getSqlMapClientTemplate()
				.queryForObject(
						"t_dictionary.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public int updateByExampleSelective(TDictionary record,
			TDictionaryExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_dictionary.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public int updateByExample(TDictionary record, TDictionaryExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"t_dictionary.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public int updateByPrimaryKeySelective(TDictionary record) {
		int rows = getSqlMapClientTemplate().update(
				"t_dictionary.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	public int updateByPrimaryKey(TDictionary record) {
		int rows = getSqlMapClientTemplate().update(
				"t_dictionary.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table t_dictionary
	 * @ibatorgenerated  Sun Feb 22 22:16:26 CST 2015
	 */
	private static class UpdateByExampleParms extends TDictionaryExample {
		private Object record;

		public UpdateByExampleParms(Object record, TDictionaryExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}