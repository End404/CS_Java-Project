
//    3-14 实现Mybatis自定义sql的查询


package com.imooc.mapper;

import com.imooc.my.mapper.MyMapper;
import com.imooc.pojo.DbStu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbStuMapperCustem {

    public List<DbStu> getStuById(String sid);
}
