package com.et59.cus.domain.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BsProductcategoryExample {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table bs_productcategory
	 * @abatorgenerated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table bs_productcategory
	 * @abatorgenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_productcategory
	 * @abatorgenerated
	 */
	public BsProductcategoryExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_productcategory
	 * @abatorgenerated
	 */
	protected BsProductcategoryExample(BsProductcategoryExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_productcategory
	 * @abatorgenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_productcategory
	 * @abatorgenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_productcategory
	 * @abatorgenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_productcategory
	 * @abatorgenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_productcategory
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
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_productcategory
	 * @abatorgenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table bs_productcategory
	 * @abatorgenerated
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table bs_productcategory
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

		public Criteria andProductcategoryCodeIsNull() {
			addCriterion("productcategory_code is null");
			return this;
		}

		public Criteria andProductcategoryCodeIsNotNull() {
			addCriterion("productcategory_code is not null");
			return this;
		}

		public Criteria andProductcategoryCodeEqualTo(String value) {
			addCriterion("productcategory_code =", value, "productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeNotEqualTo(String value) {
			addCriterion("productcategory_code <>", value,
					"productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeGreaterThan(String value) {
			addCriterion("productcategory_code >", value, "productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeGreaterThanOrEqualTo(String value) {
			addCriterion("productcategory_code >=", value,
					"productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeLessThan(String value) {
			addCriterion("productcategory_code <", value, "productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeLessThanOrEqualTo(String value) {
			addCriterion("productcategory_code <=", value,
					"productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeLike(String value) {
			addCriterion("productcategory_code like", value,
					"productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeNotLike(String value) {
			addCriterion("productcategory_code not like", value,
					"productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeIn(List<String> values) {
			addCriterion("productcategory_code in", values,
					"productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeNotIn(List<String> values) {
			addCriterion("productcategory_code not in", values,
					"productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeBetween(String value1,
				String value2) {
			addCriterion("productcategory_code between", value1, value2,
					"productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryCodeNotBetween(String value1,
				String value2) {
			addCriterion("productcategory_code not between", value1, value2,
					"productcategoryCode");
			return this;
		}

		public Criteria andProductcategoryNameIsNull() {
			addCriterion("productcategory_name is null");
			return this;
		}

		public Criteria andProductcategoryNameIsNotNull() {
			addCriterion("productcategory_name is not null");
			return this;
		}

		public Criteria andProductcategoryNameEqualTo(String value) {
			addCriterion("productcategory_name =", value, "productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameNotEqualTo(String value) {
			addCriterion("productcategory_name <>", value,
					"productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameGreaterThan(String value) {
			addCriterion("productcategory_name >", value, "productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameGreaterThanOrEqualTo(String value) {
			addCriterion("productcategory_name >=", value,
					"productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameLessThan(String value) {
			addCriterion("productcategory_name <", value, "productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameLessThanOrEqualTo(String value) {
			addCriterion("productcategory_name <=", value,
					"productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameLike(String value) {
			addCriterion("productcategory_name like", value,
					"productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameNotLike(String value) {
			addCriterion("productcategory_name not like", value,
					"productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameIn(List<String> values) {
			addCriterion("productcategory_name in", values,
					"productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameNotIn(List<String> values) {
			addCriterion("productcategory_name not in", values,
					"productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameBetween(String value1,
				String value2) {
			addCriterion("productcategory_name between", value1, value2,
					"productcategoryName");
			return this;
		}

		public Criteria andProductcategoryNameNotBetween(String value1,
				String value2) {
			addCriterion("productcategory_name not between", value1, value2,
					"productcategoryName");
			return this;
		}

		public Criteria andProductcategoryRemarkIsNull() {
			addCriterion("productcategory_remark is null");
			return this;
		}

		public Criteria andProductcategoryRemarkIsNotNull() {
			addCriterion("productcategory_remark is not null");
			return this;
		}

		public Criteria andProductcategoryRemarkEqualTo(String value) {
			addCriterion("productcategory_remark =", value,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkNotEqualTo(String value) {
			addCriterion("productcategory_remark <>", value,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkGreaterThan(String value) {
			addCriterion("productcategory_remark >", value,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkGreaterThanOrEqualTo(
				String value) {
			addCriterion("productcategory_remark >=", value,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkLessThan(String value) {
			addCriterion("productcategory_remark <", value,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkLessThanOrEqualTo(String value) {
			addCriterion("productcategory_remark <=", value,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkLike(String value) {
			addCriterion("productcategory_remark like", value,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkNotLike(String value) {
			addCriterion("productcategory_remark not like", value,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkIn(List<String> values) {
			addCriterion("productcategory_remark in", values,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkNotIn(List<String> values) {
			addCriterion("productcategory_remark not in", values,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkBetween(String value1,
				String value2) {
			addCriterion("productcategory_remark between", value1, value2,
					"productcategoryRemark");
			return this;
		}

		public Criteria andProductcategoryRemarkNotBetween(String value1,
				String value2) {
			addCriterion("productcategory_remark not between", value1, value2,
					"productcategoryRemark");
			return this;
		}

		public Criteria andSupplierCodeIsNull() {
			addCriterion("supplier_code is null");
			return this;
		}

		public Criteria andSupplierCodeIsNotNull() {
			addCriterion("supplier_code is not null");
			return this;
		}

		public Criteria andSupplierCodeEqualTo(String value) {
			addCriterion("supplier_code =", value, "supplierCode");
			return this;
		}

		public Criteria andSupplierCodeNotEqualTo(String value) {
			addCriterion("supplier_code <>", value, "supplierCode");
			return this;
		}

		public Criteria andSupplierCodeGreaterThan(String value) {
			addCriterion("supplier_code >", value, "supplierCode");
			return this;
		}

		public Criteria andSupplierCodeGreaterThanOrEqualTo(String value) {
			addCriterion("supplier_code >=", value, "supplierCode");
			return this;
		}

		public Criteria andSupplierCodeLessThan(String value) {
			addCriterion("supplier_code <", value, "supplierCode");
			return this;
		}

		public Criteria andSupplierCodeLessThanOrEqualTo(String value) {
			addCriterion("supplier_code <=", value, "supplierCode");
			return this;
		}

		public Criteria andSupplierCodeLike(String value) {
			addCriterion("supplier_code like", value, "supplierCode");
			return this;
		}

		public Criteria andSupplierCodeNotLike(String value) {
			addCriterion("supplier_code not like", value, "supplierCode");
			return this;
		}

		public Criteria andSupplierCodeIn(List<String> values) {
			addCriterion("supplier_code in", values, "supplierCode");
			return this;
		}

		public Criteria andSupplierCodeNotIn(List<String> values) {
			addCriterion("supplier_code not in", values, "supplierCode");
			return this;
		}

		public Criteria andSupplierCodeBetween(String value1, String value2) {
			addCriterion("supplier_code between", value1, value2,
					"supplierCode");
			return this;
		}

		public Criteria andSupplierCodeNotBetween(String value1, String value2) {
			addCriterion("supplier_code not between", value1, value2,
					"supplierCode");
			return this;
		}
	}
}