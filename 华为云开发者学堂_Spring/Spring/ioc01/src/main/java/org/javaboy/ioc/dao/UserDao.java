
/*
  *  2.7 对象注入问题
  *
 */

package org.javaboy.ioc.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public String hello() {
        return "hello( 2.7 )";
    }
}
