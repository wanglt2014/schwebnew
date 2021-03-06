package com.et59.cus.domain.dao;

import com.et59.cus.domain.entity.TRoleMenu;
import com.et59.cus.domain.entity.TRoleMenuExample;
import java.util.List;

public interface TRoleMenuDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    int countByExample(TRoleMenuExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    int deleteByExample(TRoleMenuExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    void insert(TRoleMenu record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    void insertSelective(TRoleMenu record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    List selectByExample(TRoleMenuExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    TRoleMenu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    int updateByExampleSelective(TRoleMenu record, TRoleMenuExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    int updateByExample(TRoleMenu record, TRoleMenuExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    int updateByPrimaryKeySelective(TRoleMenu record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table t_role_menu
     *
     * @ibatorgenerated Sun Feb 22 20:19:02 CST 2015
     */
    int updateByPrimaryKey(TRoleMenu record);
}