package com.et59.cus.domain.dao;

import java.util.List;

import com.et59.cus.domain.entity.BsArticle;
import com.et59.cus.domain.entity.BsArticleExample;

public interface BsArticleDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	int countByExample(BsArticleExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	int deleteByExample(BsArticleExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	int deleteByPrimaryKey(Long articleid);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	void insert(BsArticle record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	void insertSelective(BsArticle record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	List selectByExample(BsArticleExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	BsArticle selectByPrimaryKey(Long articleid);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	int updateByExampleSelective(BsArticle record, BsArticleExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	int updateByExample(BsArticle record, BsArticleExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	int updateByPrimaryKeySelective(BsArticle record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	int updateByPrimaryKey(BsArticle record);
}