
//    2-3  Restful 接口请求风格
//    2-4 SpringBoot 之接受参数的常用注解


package com.imooc.controller;

import com.imooc.pojo.MyConfig;
import com.imooc.pojo.Stu;
import com.imooc.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
@Slf4j      // 2-2
@RequestMapping("stu")
public class StuController {

    @GetMapping("{stuId}/get")
    // 2-4 SpringBoot 之接受参数的常用注解
    public String getStu(@PathVariable("stuId") String stuId,
                         @RequestParam Integer id,
                         @RequestParam String name) {
        log.info("stuId= " + stuId);
        log.info("id= " + id);
        log.info("name= " + name);

        return "查询Stu";
    }

    @PostMapping("creat")
    // 2-4
    public String creatStu(@RequestBody Map<String, Object> map,
                           @RequestHeader("token") String token,
                           @CookieValue("clientId") String clientId,
                           HttpServletRequest request) {
        log.info("token=" + token);
        log.info(clientId);

        log.info(map.toString());

        String headerToken = request.getHeader("token");
        log.info(headerToken);
        
        return "新增Stu";
    }

    @PutMapping("update")
    public String updateStu() {
        return "修改Stu";
    }

    @DeleteMapping("delete")
    public String deleteStu() {
        return "删除Stu";
    }



}

