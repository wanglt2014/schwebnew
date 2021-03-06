package com.et59.cus.domain.dao;

import com.et59.cus.domain.entity.BsUserRole;
import com.et59.cus.domain.entity.BsUserRoleExample;
import java.util.List;

public interface BsUserRoleDAO {

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_user_role
	 * @abatorgenerated
	 */
	void insert(BsUserRole record);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_user_role
	 * @abatorgenerated
	 */
	int updateByPrimaryKey(BsUserRole record);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_user_role
	 * @abatorgenerated
	 */
	int updateByPrimaryKeySelective(BsUserRole record);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_user_role
	 * @abatorgenerated
	 */
	List<BsUserRole> selectByExample(BsUserRoleExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_user_role
	 * @abatorgenerated
	 */
	BsUserRole selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_user_role
	 * @abatorgenerated
	 */
	int deleteByExample(BsUserRoleExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_user_role
	 * @abatorgenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_user_role
	 * @abatorgenerated
	 */
	int countByExample(BsUserRoleExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_user_role
	 * @abatorgenerated
	 */
	int updateByExampleSelective(BsUserRole record, BsUserRoleExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_user_role
	 * @abatorgenerated
	 */
	int updateByExample(BsUserRole record, BsUserRoleExample example);
}