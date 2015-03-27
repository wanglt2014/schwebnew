package com.et59.cus.domain.dao;

import com.et59.cus.domain.entity.OpenApi;
import com.et59.cus.domain.entity.OpenApiExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class OpenApiDAOImpl extends SqlMapClientDaoSupport implements OpenApiDAO {

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public OpenApiDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public void insert(OpenApi record) {
		getSqlMapClientTemplate().insert("open_api.abatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public int updateByPrimaryKeyWithoutBLOBs(OpenApi record) {
		int rows = getSqlMapClientTemplate().update(
				"open_api.abatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public int updateByPrimaryKeyWithBLOBs(OpenApi record) {
		int rows = getSqlMapClientTemplate().update(
				"open_api.abatorgenerated_updateByPrimaryKeyWithBLOBs", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public int updateByPrimaryKeySelective(OpenApi record) {
		int rows = getSqlMapClientTemplate().update(
				"open_api.abatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	@SuppressWarnings("unchecked")
	public List<OpenApi> selectByExampleWithoutBLOBs(OpenApiExample example) {
		List<OpenApi> list = (List<OpenApi>) getSqlMapClientTemplate()
				.queryForList("open_api.abatorgenerated_selectByExample",
						example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	@SuppressWarnings("unchecked")
	public List<OpenApi> selectByExampleWithBLOBs(OpenApiExample example) {
		List<OpenApi> list = (List<OpenApi>) getSqlMapClientTemplate()
				.queryForList(
						"open_api.abatorgenerated_selectByExampleWithBLOBs",
						example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public OpenApi selectByPrimaryKey(Long id) {
		OpenApi key = new OpenApi();
		key.setId(id);
		OpenApi record = (OpenApi) getSqlMapClientTemplate().queryForObject(
				"open_api.abatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public int deleteByExample(OpenApiExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"open_api.abatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public int deleteByPrimaryKey(Long id) {
		OpenApi key = new OpenApi();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"open_api.abatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public int countByExample(OpenApiExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"open_api.abatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public int updateByExampleSelective(OpenApi record, OpenApiExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"open_api.abatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public int updateByExampleWithBLOBs(OpenApi record, OpenApiExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"open_api.abatorgenerated_updateByExampleWithBLOBs", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table open_api
	 * @abatorgenerated
	 */
	public int updateByExampleWithoutBLOBs(OpenApi record,
			OpenApiExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"open_api.abatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table open_api
	 * @abatorgenerated
	 */
	private static class UpdateByExampleParms extends OpenApiExample {
		private Object record;

		public UpdateByExampleParms(Object record, OpenApiExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}