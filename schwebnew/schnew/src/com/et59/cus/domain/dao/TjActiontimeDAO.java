package com.et59.cus.domain.dao;

import com.et59.cus.domain.entity.TjActiontime;
import com.et59.cus.domain.entity.TjActiontimeExample;
import java.util.List;

public interface TjActiontimeDAO {

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table tj_actiontime
	 * @abatorgenerated
	 */
	void insert(TjActiontime record);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table tj_actiontime
	 * @abatorgenerated
	 */
	int updateByPrimaryKey(TjActiontime record);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table tj_actiontime
	 * @abatorgenerated
	 */
	int updateByPrimaryKeySelective(TjActiontime record);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table tj_actiontime
	 * @abatorgenerated
	 */
	List<TjActiontime> selectByExample(TjActiontimeExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table tj_actiontime
	 * @abatorgenerated
	 */
	TjActiontime selectByPrimaryKey(Long id);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table tj_actiontime
	 * @abatorgenerated
	 */
	int deleteByExample(TjActiontimeExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table tj_actiontime
	 * @abatorgenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table tj_actiontime
	 * @abatorgenerated
	 */
	int countByExample(TjActiontimeExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table tj_actiontime
	 * @abatorgenerated
	 */
	int updateByExampleSelective(TjActiontime record,
			TjActiontimeExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table tj_actiontime
	 * @abatorgenerated
	 */
	int updateByExample(TjActiontime record, TjActiontimeExample example);
}