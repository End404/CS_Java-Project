

//    3-5 整合MyBatis - 实现增加操作
//    3-9 整合MyBatis - 实现查询操作


package com.imooc.service;

import com.imooc.pojo.DbStu;

import java.util.List;

public interface StuService {

    /**
     * 新增stu到数据库
     * @param stu
     */
    public void saveStu(DbStu stu);

    /**
     * 3-9 整合MyBatis - 实现查询操作
     * 根据主键查询对象信息
     * @param id
     */
    public DbStu queryById(String id);   //3-9

    /**
     * 根据条件查询stu的list结果集
     * @param name
     * @param sex
     * @return
     */
    public List<DbStu> queryByCondition(String name, Integer sex);


    /** 3-10 整合MyBatis - 实现修改操作
     * 修改stu到数据库
     * @param stu
     */
    public void updateStu(DbStu stu);

    /** 3-11 整合MyBatis - 实现删除操作
     * 根据条件删除stu
     * @param stu
     */
    public void deleteStu(DbStu stu);

    /**
     * 3-12 Service层引入事务回滚
     * 演示事务
     * @param stu
     */
    public void testTrans();

    //    3-14 实现Mybatis自定义sql的查询
    public DbStu queryByIdCustom(String id);
}
