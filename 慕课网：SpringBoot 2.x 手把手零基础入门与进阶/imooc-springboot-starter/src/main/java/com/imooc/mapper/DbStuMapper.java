
// 3-4 使用mybatis逆向工具生成mappe与pojo


package com.imooc.mapper;

import com.imooc.my.mapper.MyMapper;
import com.imooc.pojo.DbStu;
import org.springframework.stereotype.Repository;

@Repository
public interface DbStuMapper extends MyMapper<DbStu> {
}
