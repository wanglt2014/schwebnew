package com.et59.cus.domain.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BsMarkingExample {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	public BsMarkingExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	protected BsMarkingExample(BsMarkingExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table bs_marking
	 * @abatorgenerated
	 */
	public static class Criteria {
		protected List<String> criteriaWithoutValue;
		protected List<Map<String, Object>> criteriaWithSingleValue;
		protected List<Map<String, Object>> criteriaWithListValue;
		protected List<Map<String, Object>> criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList<String>();
			criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
			criteriaWithListValue = new ArrayList<Map<String, Object>>();
			criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List<String> getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List<Map<String, Object>> getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List<Map<String, Object>> getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List<Map<String, Object>> getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition,
				List<? extends Object> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List<Object> list = new ArrayList<Object>();
			list.add(value1);
			list.add(value2);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return this;
		}

		public Criteria andProvinceIsNull() {
			addCriterion("province is null");
			return this;
		}

		public Criteria andProvinceIsNotNull() {
			addCriterion("province is not null");
			return this;
		}

		public Criteria andProvinceEqualTo(String value) {
			addCriterion("province =", value, "province");
			return this;
		}

		public Criteria andProvinceNotEqualTo(String value) {
			addCriterion("province <>", value, "province");
			return this;
		}

		public Criteria andProvinceGreaterThan(String value) {
			addCriterion("province >", value, "province");
			return this;
		}

		public Criteria andProvinceGreaterThanOrEqualTo(String value) {
			addCriterion("province >=", value, "province");
			return this;
		}

		public Criteria andProvinceLessThan(String value) {
			addCriterion("province <", value, "province");
			return this;
		}

		public Criteria andProvinceLessThanOrEqualTo(String value) {
			addCriterion("province <=", value, "province");
			return this;
		}

		public Criteria andProvinceLike(String value) {
			addCriterion("province like", value, "province");
			return this;
		}

		public Criteria andProvinceNotLike(String value) {
			addCriterion("province not like", value, "province");
			return this;
		}

		public Criteria andProvinceIn(List<String> values) {
			addCriterion("province in", values, "province");
			return this;
		}

		public Criteria andProvinceNotIn(List<String> values) {
			addCriterion("province not in", values, "province");
			return this;
		}

		public Criteria andProvinceBetween(String value1, String value2) {
			addCriterion("province between", value1, value2, "province");
			return this;
		}

		public Criteria andProvinceNotBetween(String value1, String value2) {
			addCriterion("province not between", value1, value2, "province");
			return this;
		}

		public Criteria andSaleNameIsNull() {
			addCriterion("sale_name is null");
			return this;
		}

		public Criteria andSaleNameIsNotNull() {
			addCriterion("sale_name is not null");
			return this;
		}

		public Criteria andSaleNameEqualTo(String value) {
			addCriterion("sale_name =", value, "saleName");
			return this;
		}

		public Criteria andSaleNameNotEqualTo(String value) {
			addCriterion("sale_name <>", value, "saleName");
			return this;
		}

		public Criteria andSaleNameGreaterThan(String value) {
			addCriterion("sale_name >", value, "saleName");
			return this;
		}

		public Criteria andSaleNameGreaterThanOrEqualTo(String value) {
			addCriterion("sale_name >=", value, "saleName");
			return this;
		}

		public Criteria andSaleNameLessThan(String value) {
			addCriterion("sale_name <", value, "saleName");
			return this;
		}

		public Criteria andSaleNameLessThanOrEqualTo(String value) {
			addCriterion("sale_name <=", value, "saleName");
			return this;
		}

		public Criteria andSaleNameLike(String value) {
			addCriterion("sale_name like", value, "saleName");
			return this;
		}

		public Criteria andSaleNameNotLike(String value) {
			addCriterion("sale_name not like", value, "saleName");
			return this;
		}

		public Criteria andSaleNameIn(List<String> values) {
			addCriterion("sale_name in", values, "saleName");
			return this;
		}

		public Criteria andSaleNameNotIn(List<String> values) {
			addCriterion("sale_name not in", values, "saleName");
			return this;
		}

		public Criteria andSaleNameBetween(String value1, String value2) {
			addCriterion("sale_name between", value1, value2, "saleName");
			return this;
		}

		public Criteria andSaleNameNotBetween(String value1, String value2) {
			addCriterion("sale_name not between", value1, value2, "saleName");
			return this;
		}

		public Criteria andSaleQqIsNull() {
			addCriterion("sale_qq is null");
			return this;
		}

		public Criteria andSaleQqIsNotNull() {
			addCriterion("sale_qq is not null");
			return this;
		}

		public Criteria andSaleQqEqualTo(String value) {
			addCriterion("sale_qq =", value, "saleQq");
			return this;
		}

		public Criteria andSaleQqNotEqualTo(String value) {
			addCriterion("sale_qq <>", value, "saleQq");
			return this;
		}

		public Criteria andSaleQqGreaterThan(String value) {
			addCriterion("sale_qq >", value, "saleQq");
			return this;
		}

		public Criteria andSaleQqGreaterThanOrEqualTo(String value) {
			addCriterion("sale_qq >=", value, "saleQq");
			return this;
		}

		public Criteria andSaleQqLessThan(String value) {
			addCriterion("sale_qq <", value, "saleQq");
			return this;
		}

		public Criteria andSaleQqLessThanOrEqualTo(String value) {
			addCriterion("sale_qq <=", value, "saleQq");
			return this;
		}

		public Criteria andSaleQqLike(String value) {
			addCriterion("sale_qq like", value, "saleQq");
			return this;
		}

		public Criteria andSaleQqNotLike(String value) {
			addCriterion("sale_qq not like", value, "saleQq");
			return this;
		}

		public Criteria andSaleQqIn(List<String> values) {
			addCriterion("sale_qq in", values, "saleQq");
			return this;
		}

		public Criteria andSaleQqNotIn(List<String> values) {
			addCriterion("sale_qq not in", values, "saleQq");
			return this;
		}

		public Criteria andSaleQqBetween(String value1, String value2) {
			addCriterion("sale_qq between", value1, value2, "saleQq");
			return this;
		}

		public Criteria andSaleQqNotBetween(String value1, String value2) {
			addCriterion("sale_qq not between", value1, value2, "saleQq");
			return this;
		}

		public Criteria andSalePhoneIsNull() {
			addCriterion("sale_phone is null");
			return this;
		}

		public Criteria andSalePhoneIsNotNull() {
			addCriterion("sale_phone is not null");
			return this;
		}

		public Criteria andSalePhoneEqualTo(String value) {
			addCriterion("sale_phone =", value, "salePhone");
			return this;
		}

		public Criteria andSalePhoneNotEqualTo(String value) {
			addCriterion("sale_phone <>", value, "salePhone");
			return this;
		}

		public Criteria andSalePhoneGreaterThan(String value) {
			addCriterion("sale_phone >", value, "salePhone");
			return this;
		}

		public Criteria andSalePhoneGreaterThanOrEqualTo(String value) {
			addCriterion("sale_phone >=", value, "salePhone");
			return this;
		}

		public Criteria andSalePhoneLessThan(String value) {
			addCriterion("sale_phone <", value, "salePhone");
			return this;
		}

		public Criteria andSalePhoneLessThanOrEqualTo(String value) {
			addCriterion("sale_phone <=", value, "salePhone");
			return this;
		}

		public Criteria andSalePhoneLike(String value) {
			addCriterion("sale_phone like", value, "salePhone");
			return this;
		}

		public Criteria andSalePhoneNotLike(String value) {
			addCriterion("sale_phone not like", value, "salePhone");
			return this;
		}

		public Criteria andSalePhoneIn(List<String> values) {
			addCriterion("sale_phone in", values, "salePhone");
			return this;
		}

		public Criteria andSalePhoneNotIn(List<String> values) {
			addCriterion("sale_phone not in", values, "salePhone");
			return this;
		}

		public Criteria andSalePhoneBetween(String value1, String value2) {
			addCriterion("sale_phone between", value1, value2, "salePhone");
			return this;
		}

		public Criteria andSalePhoneNotBetween(String value1, String value2) {
			addCriterion("sale_phone not between", value1, value2, "salePhone");
			return this;
		}

		public Criteria andSaleEmailIsNull() {
			addCriterion("sale_email is null");
			return this;
		}

		public Criteria andSaleEmailIsNotNull() {
			addCriterion("sale_email is not null");
			return this;
		}

		public Criteria andSaleEmailEqualTo(String value) {
			addCriterion("sale_email =", value, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailNotEqualTo(String value) {
			addCriterion("sale_email <>", value, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailGreaterThan(String value) {
			addCriterion("sale_email >", value, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailGreaterThanOrEqualTo(String value) {
			addCriterion("sale_email >=", value, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailLessThan(String value) {
			addCriterion("sale_email <", value, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailLessThanOrEqualTo(String value) {
			addCriterion("sale_email <=", value, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailLike(String value) {
			addCriterion("sale_email like", value, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailNotLike(String value) {
			addCriterion("sale_email not like", value, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailIn(List<String> values) {
			addCriterion("sale_email in", values, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailNotIn(List<String> values) {
			addCriterion("sale_email not in", values, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailBetween(String value1, String value2) {
			addCriterion("sale_email between", value1, value2, "saleEmail");
			return this;
		}

		public Criteria andSaleEmailNotBetween(String value1, String value2) {
			addCriterion("sale_email not between", value1, value2, "saleEmail");
			return this;
		}

		public Criteria andAreanameIsNull() {
			addCriterion("areaname is null");
			return this;
		}

		public Criteria andAreanameIsNotNull() {
			addCriterion("areaname is not null");
			return this;
		}

		public Criteria andAreanameEqualTo(String value) {
			addCriterion("areaname =", value, "areaname");
			return this;
		}

		public Criteria andAreanameNotEqualTo(String value) {
			addCriterion("areaname <>", value, "areaname");
			return this;
		}

		public Criteria andAreanameGreaterThan(String value) {
			addCriterion("areaname >", value, "areaname");
			return this;
		}

		public Criteria andAreanameGreaterThanOrEqualTo(String value) {
			addCriterion("areaname >=", value, "areaname");
			return this;
		}

		public Criteria andAreanameLessThan(String value) {
			addCriterion("areaname <", value, "areaname");
			return this;
		}

		public Criteria andAreanameLessThanOrEqualTo(String value) {
			addCriterion("areaname <=", value, "areaname");
			return this;
		}

		public Criteria andAreanameLike(String value) {
			addCriterion("areaname like", value, "areaname");
			return this;
		}

		public Criteria andAreanameNotLike(String value) {
			addCriterion("areaname not like", value, "areaname");
			return this;
		}

		public Criteria andAreanameIn(List<String> values) {
			addCriterion("areaname in", values, "areaname");
			return this;
		}

		public Criteria andAreanameNotIn(List<String> values) {
			addCriterion("areaname not in", values, "areaname");
			return this;
		}

		public Criteria andAreanameBetween(String value1, String value2) {
			addCriterion("areaname between", value1, value2, "areaname");
			return this;
		}

		public Criteria andAreanameNotBetween(String value1, String value2) {
			addCriterion("areaname not between", value1, value2, "areaname");
			return this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return this;
		}

		public Criteria andClassstyleIsNull() {
			addCriterion("classstyle is null");
			return this;
		}

		public Criteria andClassstyleIsNotNull() {
			addCriterion("classstyle is not null");
			return this;
		}

		public Criteria andClassstyleEqualTo(String value) {
			addCriterion("classstyle =", value, "classstyle");
			return this;
		}

		public Criteria andClassstyleNotEqualTo(String value) {
			addCriterion("classstyle <>", value, "classstyle");
			return this;
		}

		public Criteria andClassstyleGreaterThan(String value) {
			addCriterion("classstyle >", value, "classstyle");
			return this;
		}

		public Criteria andClassstyleGreaterThanOrEqualTo(String value) {
			addCriterion("classstyle >=", value, "classstyle");
			return this;
		}

		public Criteria andClassstyleLessThan(String value) {
			addCriterion("classstyle <", value, "classstyle");
			return this;
		}

		public Criteria andClassstyleLessThanOrEqualTo(String value) {
			addCriterion("classstyle <=", value, "classstyle");
			return this;
		}

		public Criteria andClassstyleLike(String value) {
			addCriterion("classstyle like", value, "classstyle");
			return this;
		}

		public Criteria andClassstyleNotLike(String value) {
			addCriterion("classstyle not like", value, "classstyle");
			return this;
		}

		public Criteria andClassstyleIn(List<String> values) {
			addCriterion("classstyle in", values, "classstyle");
			return this;
		}

		public Criteria andClassstyleNotIn(List<String> values) {
			addCriterion("classstyle not in", values, "classstyle");
			return this;
		}

		public Criteria andClassstyleBetween(String value1, String value2) {
			addCriterion("classstyle between", value1, value2, "classstyle");
			return this;
		}

		public Criteria andClassstyleNotBetween(String value1, String value2) {
			addCriterion("classstyle not between", value1, value2, "classstyle");
			return this;
		}

		public Criteria andHrefIsNull() {
			addCriterion("href is null");
			return this;
		}

		public Criteria andHrefIsNotNull() {
			addCriterion("href is not null");
			return this;
		}

		public Criteria andHrefEqualTo(String value) {
			addCriterion("href =", value, "href");
			return this;
		}

		public Criteria andHrefNotEqualTo(String value) {
			addCriterion("href <>", value, "href");
			return this;
		}

		public Criteria andHrefGreaterThan(String value) {
			addCriterion("href >", value, "href");
			return this;
		}

		public Criteria andHrefGreaterThanOrEqualTo(String value) {
			addCriterion("href >=", value, "href");
			return this;
		}

		public Criteria andHrefLessThan(String value) {
			addCriterion("href <", value, "href");
			return this;
		}

		public Criteria andHrefLessThanOrEqualTo(String value) {
			addCriterion("href <=", value, "href");
			return this;
		}

		public Criteria andHrefLike(String value) {
			addCriterion("href like", value, "href");
			return this;
		}

		public Criteria andHrefNotLike(String value) {
			addCriterion("href not like", value, "href");
			return this;
		}

		public Criteria andHrefIn(List<String> values) {
			addCriterion("href in", values, "href");
			return this;
		}

		public Criteria andHrefNotIn(List<String> values) {
			addCriterion("href not in", values, "href");
			return this;
		}

		public Criteria andHrefBetween(String value1, String value2) {
			addCriterion("href between", value1, value2, "href");
			return this;
		}

		public Criteria andHrefNotBetween(String value1, String value2) {
			addCriterion("href not between", value1, value2, "href");
			return this;
		}
	}
}