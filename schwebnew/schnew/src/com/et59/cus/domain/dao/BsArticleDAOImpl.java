package com.et59.cus.domain.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.et59.cus.domain.entity.BsArticle;
import com.et59.cus.domain.entity.BsArticleExample;

public class BsArticleDAOImpl extends SqlMapClientDaoSupport implements BsArticleDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public BsArticleDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public int countByExample(BsArticleExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"bs_article.ibatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public int deleteByExample(BsArticleExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"bs_article.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public int deleteByPrimaryKey(Long articleid) {
		BsArticle key = new BsArticle();
		key.setArticleid(articleid);
		int rows = getSqlMapClientTemplate().delete(
				"bs_article.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public void insert(BsArticle record) {
		getSqlMapClientTemplate().insert("bs_article.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public void insertSelective(BsArticle record) {
		getSqlMapClientTemplate().insert(
				"bs_article.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public List selectByExample(BsArticleExample example) {
		List list = getSqlMapClientTemplate().queryForList(
				"bs_article.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public BsArticle selectByPrimaryKey(Long articleid) {
		BsArticle key = new BsArticle();
		key.setArticleid(articleid);
		BsArticle record = (BsArticle) getSqlMapClientTemplate()
				.queryForObject(
						"bs_article.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public int updateByExampleSelective(BsArticle record,
			BsArticleExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"bs_article.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public int updateByExample(BsArticle record, BsArticleExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"bs_article.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public int updateByPrimaryKeySelective(BsArticle record) {
		int rows = getSqlMapClientTemplate().update(
				"bs_article.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	public int updateByPrimaryKey(BsArticle record) {
		int rows = getSqlMapClientTemplate().update(
				"bs_article.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table bs_article
	 * @ibatorgenerated  Thu Mar 05 16:23:33 CST 2015
	 */
	private static class UpdateByExampleParms extends BsArticleExample {
		private Object record;

		public UpdateByExampleParms(Object record, BsArticleExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}