package com.et59.cus.domain.dao;

import com.et59.cus.domain.entity.TTeacherSubjectExample;
import com.et59.cus.domain.entity.TTeacherSubjectKey;
import java.util.List;

public interface TTeacherSubjectDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_subject
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    int countByExample(TTeacherSubjectExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_subject
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    int deleteByExample(TTeacherSubjectExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_subject
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    int deleteByPrimaryKey(TTeacherSubjectKey key);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_subject
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    void insert(TTeacherSubjectKey record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_subject
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    void insertSelective(TTeacherSubjectKey record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_subject
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    List selectByExample(TTeacherSubjectExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_subject
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    int updateByExampleSelective(TTeacherSubjectKey record, TTeacherSubjectExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_teacher_subject
     *
     * @ibatorgenerated Tue Mar 03 17:43:02 CST 2015
     */
    int updateByExample(TTeacherSubjectKey record, TTeacherSubjectExample example);
}