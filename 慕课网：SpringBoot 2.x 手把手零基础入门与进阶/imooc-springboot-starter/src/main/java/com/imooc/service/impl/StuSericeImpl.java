
// 3-4 使用mybatis逆向工具生成mappe与pojo


package com.imooc.service.impl;


import com.imooc.mapper.DbStuMapper;
import com.imooc.mapper.DbStuMapperCustem;
import com.imooc.pojo.DbStu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.UUID;

@Service
public class StuSericeImpl implements StuService {

    @Autowired
    private DbStuMapper stuMapper;

    //    3-14 实现Mybatis自定义sql的查询
    @Autowired
    private DbStuMapperCustem stuMapperCustem;

    @Override
    public void saveStu(DbStu stu) {
        stuMapper.insert(stu);
    }

    //    3-14 实现Mybatis自定义sql的查询
    @Override
    public DbStu queryByIdCustom(String id) {

//        3-17 使用AOP监控service执行时间
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<DbStu> list = stuMapperCustem.getStuById(id);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    //    3-9 整合MyBatis - 实现查询操作
    @Override
    public DbStu queryById(String id) {
        DbStu stu = stuMapper.selectByPrimaryKey(id);
        return stu;
    }

    //    3-9
    @Override
//    public List<DbStu> queryByCondition(String name, Integer sex) {
//        Example example = new Example(DbStu.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("name", name);
//        criteria.andEqualTo("sex", sex);
//
//        List<DbStu> list = stuMapper.selectByExample(example);
//        return list;
//    }
    public List<DbStu> queryByCondition(String name, Integer sex) {
        // 条件对象
        DbStu stu = new DbStu();
        stu.setName(name);
        stu.setSex(sex);

        List<DbStu> list = stuMapper.select(stu);

        return list;
    }

//    3-10 整合MyBatis - 实现修改操作
    @Override
    public void updateStu(DbStu stu) {
        stuMapper.updateByPrimaryKey(stu);
    }

//    3-11 整合MyBatis - 实现删除操作
    @Override
    public void deleteStu(DbStu stu) {
        // 删除对象/数据的三种方式

//        stuMapper.deleteByPrimaryKey(stu.getId());    // 1. 根据主键删除
//        stuMapper.delete(stu);      // 2 根据对象中的属性值匹配做条件删除

        // 3. 根据构建的example进行条件删除
        Example example = new Example(DbStu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", stu.getName());
        stuMapper.deleteByExample(example);
    }


    //    3-12 Service层引入事务回滚
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testTrans() {
        // 1. 新增数据
        // 2. 修改数据
        // 3. 模拟发生异常
        // 4. 观察1和2步骤所发生的数据变动，有没有影响到数据库
        // 5. 处理事务，实现事务的回滚，不然先前的数据入库

        String sid = UUID.randomUUID().toString();
        DbStu stu = new DbStu();
        stu.setId(sid);
        stu.setName(sid);
        stu.setSex(2);
        stuMapper.insert(stu);

        int a = 100 / 0;

        DbStu stuUpdate = new DbStu();
        stu.setId("1001");
        stu.setName("1001修改");
        stu.setSex(3);
        stuMapper.updateByPrimaryKeySelective(stuUpdate);
    }
}
