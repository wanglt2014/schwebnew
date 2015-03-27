package com.et59.cus.domain.dao;

import com.et59.cus.domain.entity.BsRole;
import com.et59.cus.domain.entity.BsRoleExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class BsRoleDAOImpl extends SqlMapClientDaoSupport implements BsRoleDAO {

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	public BsRoleDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	public void insert(BsRole record) {
		getSqlMapClientTemplate().insert("bs_role.abatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	public int updateByPrimaryKey(BsRole record) {
		int rows = getSqlMapClientTemplate().update(
				"bs_role.abatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	public int updateByPrimaryKeySelective(BsRole record) {
		int rows = getSqlMapClientTemplate().update(
				"bs_role.abatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	@SuppressWarnings("unchecked")
	public List<BsRole> selectByExample(BsRoleExample example) {
		List<BsRole> list = (List<BsRole>) getSqlMapClientTemplate()
				.queryForList("bs_role.abatorgenerated_selectByExample",
						example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	public BsRole selectByPrimaryKey(Integer id) {
		BsRole key = new BsRole();
		key.setId(id);
		BsRole record = (BsRole) getSqlMapClientTemplate().queryForObject(
				"bs_role.abatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	public int deleteByExample(BsRoleExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"bs_role.abatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	public int deleteByPrimaryKey(Integer id) {
		BsRole key = new BsRole();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"bs_role.abatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	public int countByExample(BsRoleExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"bs_role.abatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	public int updateByExampleSelective(BsRole record, BsRoleExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"bs_role.abatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	public int updateByExample(BsRole record, BsRoleExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"bs_role.abatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table bs_role
	 * @abatorgenerated
	 */
	private static class UpdateByExampleParms extends BsRoleExample {
		private Object record;

		public UpdateByExampleParms(Object record, BsRoleExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}