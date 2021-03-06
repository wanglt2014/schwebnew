package com.et59.cus.domain.dao;

import com.et59.cus.domain.entity.TTeacherPrizeExample;
import com.et59.cus.domain.entity.TTeacherPrizeKey;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TTeacherPrizeDAOImpl extends SqlMapClientDaoSupport implements TTeacherPrizeDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_prize
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    public TTeacherPrizeDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_prize
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    public int countByExample(TTeacherPrizeExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("t_teacher_prize.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_prize
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    public int deleteByExample(TTeacherPrizeExample example) {
        int rows = getSqlMapClientTemplate().delete("t_teacher_prize.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_prize
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    public int deleteByPrimaryKey(TTeacherPrizeKey key) {
        int rows = getSqlMapClientTemplate().delete("t_teacher_prize.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_prize
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    public void insert(TTeacherPrizeKey record) {
        getSqlMapClientTemplate().insert("t_teacher_prize.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_prize
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    public void insertSelective(TTeacherPrizeKey record) {
        getSqlMapClientTemplate().insert("t_teacher_prize.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_prize
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    public List selectByExample(TTeacherPrizeExample example) {
        List list = getSqlMapClientTemplate().queryForList("t_teacher_prize.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_prize
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    public int updateByExampleSelective(TTeacherPrizeKey record, TTeacherPrizeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_teacher_prize.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_prize
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    public int updateByExample(TTeacherPrizeKey record, TTeacherPrizeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("t_teacher_prize.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table t_teacher_prize
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    private static class UpdateByExampleParms extends TTeacherPrizeExample {
        private Object record;

        public UpdateByExampleParms(Object record, TTeacherPrizeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}