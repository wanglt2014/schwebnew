package com.et59.cus.domain.dao;

import com.et59.cus.domain.entity.TTrainingplan;
import com.et59.cus.domain.entity.TTrainingplanExample;
import java.util.List;

public interface TTrainingplanDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	int countByExample(TTrainingplanExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	int deleteByExample(TTrainingplanExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	int deleteByPrimaryKey(Long trainingplanid);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	void insert(TTrainingplan record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	void insertSelective(TTrainingplan record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	List selectByExample(TTrainingplanExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	TTrainingplan selectByPrimaryKey(Long trainingplanid);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	int updateByExampleSelective(TTrainingplan record,
			TTrainingplanExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	int updateByExample(TTrainingplan record, TTrainingplanExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	int updateByPrimaryKeySelective(TTrainingplan record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table t_trainingplan
	 * @ibatorgenerated  Thu Mar 26 17:53:45 CST 2015
	 */
	int updateByPrimaryKey(TTrainingplan record);
}