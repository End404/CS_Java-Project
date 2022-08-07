
/*
 *   2.6 自动扫描注入
 *
 */

package org.javaboy.ioc.service;

import org.javaboy.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    //    2.7 对象注入
    @Autowired
    UserDao userDao;

    public List<String> getAllUsers() {

        String hello = userDao.hello();
        System.out.println("hello( 2.7 ) = " + hello);

        ArrayList<String> users = new ArrayList<>();
        for (int i=0; i<10; i++) {
            users.add("javaboy( 2.6 ): " + i);
        }
        return users;
    }

}
