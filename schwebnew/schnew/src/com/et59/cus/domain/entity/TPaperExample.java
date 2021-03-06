package com.et59.cus.domain.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TPaperExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    public TPaperExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    protected TPaperExample(TPaperExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table t_paper
     *
     * @ibatorgenerated Mon Feb 16 17:46:03 CST 2015
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andPaperidIsNull() {
            addCriterion("paperId is null");
            return this;
        }

        public Criteria andPaperidIsNotNull() {
            addCriterion("paperId is not null");
            return this;
        }

        public Criteria andPaperidEqualTo(Long value) {
            addCriterion("paperId =", value, "paperid");
            return this;
        }

        public Criteria andPaperidNotEqualTo(Long value) {
            addCriterion("paperId <>", value, "paperid");
            return this;
        }

        public Criteria andPaperidGreaterThan(Long value) {
            addCriterion("paperId >", value, "paperid");
            return this;
        }

        public Criteria andPaperidGreaterThanOrEqualTo(Long value) {
            addCriterion("paperId >=", value, "paperid");
            return this;
        }

        public Criteria andPaperidLessThan(Long value) {
            addCriterion("paperId <", value, "paperid");
            return this;
        }

        public Criteria andPaperidLessThanOrEqualTo(Long value) {
            addCriterion("paperId <=", value, "paperid");
            return this;
        }

        public Criteria andPaperidIn(List values) {
            addCriterion("paperId in", values, "paperid");
            return this;
        }

        public Criteria andPaperidNotIn(List values) {
            addCriterion("paperId not in", values, "paperid");
            return this;
        }

        public Criteria andPaperidBetween(Long value1, Long value2) {
            addCriterion("paperId between", value1, value2, "paperid");
            return this;
        }

        public Criteria andPaperidNotBetween(Long value1, Long value2) {
            addCriterion("paperId not between", value1, value2, "paperid");
            return this;
        }

        public Criteria andPapernameIsNull() {
            addCriterion("paperName is null");
            return this;
        }

        public Criteria andPapernameIsNotNull() {
            addCriterion("paperName is not null");
            return this;
        }

        public Criteria andPapernameEqualTo(String value) {
            addCriterion("paperName =", value, "papername");
            return this;
        }

        public Criteria andPapernameNotEqualTo(String value) {
            addCriterion("paperName <>", value, "papername");
            return this;
        }

        public Criteria andPapernameGreaterThan(String value) {
            addCriterion("paperName >", value, "papername");
            return this;
        }

        public Criteria andPapernameGreaterThanOrEqualTo(String value) {
            addCriterion("paperName >=", value, "papername");
            return this;
        }

        public Criteria andPapernameLessThan(String value) {
            addCriterion("paperName <", value, "papername");
            return this;
        }

        public Criteria andPapernameLessThanOrEqualTo(String value) {
            addCriterion("paperName <=", value, "papername");
            return this;
        }

        public Criteria andPapernameLike(String value) {
            addCriterion("paperName like", value, "papername");
            return this;
        }

        public Criteria andPapernameNotLike(String value) {
            addCriterion("paperName not like", value, "papername");
            return this;
        }

        public Criteria andPapernameIn(List values) {
            addCriterion("paperName in", values, "papername");
            return this;
        }

        public Criteria andPapernameNotIn(List values) {
            addCriterion("paperName not in", values, "papername");
            return this;
        }

        public Criteria andPapernameBetween(String value1, String value2) {
            addCriterion("paperName between", value1, value2, "papername");
            return this;
        }

        public Criteria andPapernameNotBetween(String value1, String value2) {
            addCriterion("paperName not between", value1, value2, "papername");
            return this;
        }

        public Criteria andPaperauthorIsNull() {
            addCriterion("paperAuthor is null");
            return this;
        }

        public Criteria andPaperauthorIsNotNull() {
            addCriterion("paperAuthor is not null");
            return this;
        }

        public Criteria andPaperauthorEqualTo(String value) {
            addCriterion("paperAuthor =", value, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorNotEqualTo(String value) {
            addCriterion("paperAuthor <>", value, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorGreaterThan(String value) {
            addCriterion("paperAuthor >", value, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorGreaterThanOrEqualTo(String value) {
            addCriterion("paperAuthor >=", value, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorLessThan(String value) {
            addCriterion("paperAuthor <", value, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorLessThanOrEqualTo(String value) {
            addCriterion("paperAuthor <=", value, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorLike(String value) {
            addCriterion("paperAuthor like", value, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorNotLike(String value) {
            addCriterion("paperAuthor not like", value, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorIn(List values) {
            addCriterion("paperAuthor in", values, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorNotIn(List values) {
            addCriterion("paperAuthor not in", values, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorBetween(String value1, String value2) {
            addCriterion("paperAuthor between", value1, value2, "paperauthor");
            return this;
        }

        public Criteria andPaperauthorNotBetween(String value1, String value2) {
            addCriterion("paperAuthor not between", value1, value2, "paperauthor");
            return this;
        }

        public Criteria andPapernotenameIsNull() {
            addCriterion("paperNoteName is null");
            return this;
        }

        public Criteria andPapernotenameIsNotNull() {
            addCriterion("paperNoteName is not null");
            return this;
        }

        public Criteria andPapernotenameEqualTo(String value) {
            addCriterion("paperNoteName =", value, "papernotename");
            return this;
        }

        public Criteria andPapernotenameNotEqualTo(String value) {
            addCriterion("paperNoteName <>", value, "papernotename");
            return this;
        }

        public Criteria andPapernotenameGreaterThan(String value) {
            addCriterion("paperNoteName >", value, "papernotename");
            return this;
        }

        public Criteria andPapernotenameGreaterThanOrEqualTo(String value) {
            addCriterion("paperNoteName >=", value, "papernotename");
            return this;
        }

        public Criteria andPapernotenameLessThan(String value) {
            addCriterion("paperNoteName <", value, "papernotename");
            return this;
        }

        public Criteria andPapernotenameLessThanOrEqualTo(String value) {
            addCriterion("paperNoteName <=", value, "papernotename");
            return this;
        }

        public Criteria andPapernotenameLike(String value) {
            addCriterion("paperNoteName like", value, "papernotename");
            return this;
        }

        public Criteria andPapernotenameNotLike(String value) {
            addCriterion("paperNoteName not like", value, "papernotename");
            return this;
        }

        public Criteria andPapernotenameIn(List values) {
            addCriterion("paperNoteName in", values, "papernotename");
            return this;
        }

        public Criteria andPapernotenameNotIn(List values) {
            addCriterion("paperNoteName not in", values, "papernotename");
            return this;
        }

        public Criteria andPapernotenameBetween(String value1, String value2) {
            addCriterion("paperNoteName between", value1, value2, "papernotename");
            return this;
        }

        public Criteria andPapernotenameNotBetween(String value1, String value2) {
            addCriterion("paperNoteName not between", value1, value2, "papernotename");
            return this;
        }

        public Criteria andPapernoteyearIsNull() {
            addCriterion("paperNoteYear is null");
            return this;
        }

        public Criteria andPapernoteyearIsNotNull() {
            addCriterion("paperNoteYear is not null");
            return this;
        }

        public Criteria andPapernoteyearEqualTo(String value) {
            addCriterion("paperNoteYear =", value, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearNotEqualTo(String value) {
            addCriterion("paperNoteYear <>", value, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearGreaterThan(String value) {
            addCriterion("paperNoteYear >", value, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearGreaterThanOrEqualTo(String value) {
            addCriterion("paperNoteYear >=", value, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearLessThan(String value) {
            addCriterion("paperNoteYear <", value, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearLessThanOrEqualTo(String value) {
            addCriterion("paperNoteYear <=", value, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearLike(String value) {
            addCriterion("paperNoteYear like", value, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearNotLike(String value) {
            addCriterion("paperNoteYear not like", value, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearIn(List values) {
            addCriterion("paperNoteYear in", values, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearNotIn(List values) {
            addCriterion("paperNoteYear not in", values, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearBetween(String value1, String value2) {
            addCriterion("paperNoteYear between", value1, value2, "papernoteyear");
            return this;
        }

        public Criteria andPapernoteyearNotBetween(String value1, String value2) {
            addCriterion("paperNoteYear not between", value1, value2, "papernoteyear");
            return this;
        }

        public Criteria andPapernotenoIsNull() {
            addCriterion("paperNoteNO is null");
            return this;
        }

        public Criteria andPapernotenoIsNotNull() {
            addCriterion("paperNoteNO is not null");
            return this;
        }

        public Criteria andPapernotenoEqualTo(String value) {
            addCriterion("paperNoteNO =", value, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoNotEqualTo(String value) {
            addCriterion("paperNoteNO <>", value, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoGreaterThan(String value) {
            addCriterion("paperNoteNO >", value, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoGreaterThanOrEqualTo(String value) {
            addCriterion("paperNoteNO >=", value, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoLessThan(String value) {
            addCriterion("paperNoteNO <", value, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoLessThanOrEqualTo(String value) {
            addCriterion("paperNoteNO <=", value, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoLike(String value) {
            addCriterion("paperNoteNO like", value, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoNotLike(String value) {
            addCriterion("paperNoteNO not like", value, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoIn(List values) {
            addCriterion("paperNoteNO in", values, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoNotIn(List values) {
            addCriterion("paperNoteNO not in", values, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoBetween(String value1, String value2) {
            addCriterion("paperNoteNO between", value1, value2, "papernoteno");
            return this;
        }

        public Criteria andPapernotenoNotBetween(String value1, String value2) {
            addCriterion("paperNoteNO not between", value1, value2, "papernoteno");
            return this;
        }

        public Criteria andPaperdownloadidIsNull() {
            addCriterion("paperDownloadId is null");
            return this;
        }

        public Criteria andPaperdownloadidIsNotNull() {
            addCriterion("paperDownloadId is not null");
            return this;
        }

        public Criteria andPaperdownloadidEqualTo(Long value) {
            addCriterion("paperDownloadId =", value, "paperdownloadid");
            return this;
        }

        public Criteria andPaperdownloadidNotEqualTo(Long value) {
            addCriterion("paperDownloadId <>", value, "paperdownloadid");
            return this;
        }

        public Criteria andPaperdownloadidGreaterThan(Long value) {
            addCriterion("paperDownloadId >", value, "paperdownloadid");
            return this;
        }

        public Criteria andPaperdownloadidGreaterThanOrEqualTo(Long value) {
            addCriterion("paperDownloadId >=", value, "paperdownloadid");
            return this;
        }

        public Criteria andPaperdownloadidLessThan(Long value) {
            addCriterion("paperDownloadId <", value, "paperdownloadid");
            return this;
        }

        public Criteria andPaperdownloadidLessThanOrEqualTo(Long value) {
            addCriterion("paperDownloadId <=", value, "paperdownloadid");
            return this;
        }

        public Criteria andPaperdownloadidIn(List values) {
            addCriterion("paperDownloadId in", values, "paperdownloadid");
            return this;
        }

        public Criteria andPaperdownloadidNotIn(List values) {
            addCriterion("paperDownloadId not in", values, "paperdownloadid");
            return this;
        }

        public Criteria andPaperdownloadidBetween(Long value1, Long value2) {
            addCriterion("paperDownloadId between", value1, value2, "paperdownloadid");
            return this;
        }

        public Criteria andPaperdownloadidNotBetween(Long value1, Long value2) {
            addCriterion("paperDownloadId not between", value1, value2, "paperdownloadid");
            return this;
        }
    }
}