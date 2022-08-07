
//    2-3  Restful 接口请求风格
//    2-4 SpringBoot 之接受参数的常用注解
//    3-5 整合MyBatis - 实现增加操作
//    3-9 整合MyBatis - 实现查询操作



package com.imooc.controller;

import com.imooc.pojo.DbStu;
import com.imooc.pojo.bo.DbStuBO;
import com.imooc.service.StuService;
import com.imooc.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@Slf4j      // 2-2
@RequestMapping("dbstu")
public class DBStuController {

    @Autowired
    private StuService stuService;   // 3-5

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

    //    3-9 整合MyBatis - 实现查询操作
    @GetMapping("/get")
    public JSONResult getStu(String  stuId) {
        DbStu stu = stuService.queryById(stuId);
        List<DbStu> list = stuService.queryByCondition("abc", 1);
//        return JSONResult.ok(list);

        //    3-14 实现Mybatis自定义sql的查询
        DbStu stu2 = stuService.queryByIdCustom(stuId);
        return JSONResult.ok(stu2);
    }


    @PostMapping("creat")
    public JSONResult creatStu() {   // 3-5

        String sid = UUID.randomUUID().toString();

        DbStu stu = new DbStu();

        stu.setId(sid);
        stu.setName("慕课");
        stu.setSex(1);

        stuService.saveStu(stu);

        return JSONResult.ok();
    }

    @PostMapping("creat2")
    public JSONResult creatStu2(@Valid @RequestBody DbStuBO stuBO,
                                BindingResult result) {   // 3-6 通过接受bean的业务对象引出验证框架

        // 判断BindingResult是否有错误
        if (result.hasErrors()) {     //3-7
            Map<String, String> map = getErrors(result);
            return JSONResult.errorMsg(map);
        }

        String sid = UUID.randomUUID().toString();

        DbStu stu = new DbStu();
        BeanUtils.copyProperties(stuBO,stu);
        stu.setId(sid);

        stuService.saveStu(stu);

        return JSONResult.ok();
    }

    public Map<String, String> getErrors(BindingResult result) {   //3-7
        Map<String, String> map = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error: errorList) {
            String field = error.getField();
            String msg = error.getDefaultMessage();
            map.put(field, msg);
        }
        return map;
    }

//    @PutMapping("update")
    @GetMapping("update")   // 3-10 整合MyBatis - 实现修改操作
    public JSONResult updateStu() {

        DbStu stu = new DbStu();
        stu.setId("111");
        stu.setName("已经修改的name");
        stu.setSex(2);

        stuService.updateStu(stu);

        return JSONResult.ok();
    }

//    3-11 整合MyBatis - 实现删除操作
//    @DeleteMapping("delete")
    @GetMapping("delete")
    public String deleteStu() {     // 3-11
        DbStu stu = new DbStu();
//        stu.setId("r32re132");    // 3-11 1.
        stu.setSex(2);      // 3-11 2.
        stu.setName("abc");     // 3-11 3.

        stuService.deleteStu(stu);

        return "删除Stu";
    }

//    3-12 Service层引入事务回滚
    @GetMapping("testTrans")
    public JSONResult testTrans() {
        stuService.testTrans();
        return JSONResult.ok();
    }


}

