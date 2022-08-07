package com.imooc.controller;

import com.imooc.exception.MyCustomException;
import com.imooc.pojo.MyConfig;
import com.imooc.pojo.Stu;
import com.imooc.pojo.Student;
import com.imooc.utils.JSONResult;
import com.imooc.utils.MyAsyonTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


//@Controller
@RestController
@Slf4j      // 2-2
public class HelloController {

//    @RequestMapping("hello")
//    @ResponseBody
    @GetMapping("hello")
    public String hello(){
        return "Hell world";
    }


//     1-12
    @Autowired
    private Stu stu;


    @GetMapping("getStu")
    public Object getStu() {
        return stu;
    }


//    #    1-13 SpringBoot自定义属性资源配置
    @Autowired
    private MyConfig myConfig;

    @Autowired
    private MyAsyonTask myAsyonTask;    //2-12

    @GetMapping("getMyConfig")
    public Object getMyConfig() {
        myAsyonTask.publishMsg();   //2-12
        log.info("这是跳过异步任务的执行");
        return myConfig;
    }


//    #    1-14 在yml中实现自定义配置与表达式
    @Value("${self.custom.config.sdkSecrect}")
    private String sdkSecrect;
    @Value("${self.custom.config.host}")
    private String host;
    @Value("${self.custom.config.port}")
    private String port;
    @Value("${app.name.xxx.yyy.zzz}")
    private String xyz;

    @GetMapping("getYmlCustomConfig")
    public Object getYmlCustomConfig() {
        return sdkSecrect + ";\t" +  host + ":" +port + ";\t" + xyz;
    }


//    2-2
    @GetMapping("getStudent")
//    public Object getStudent()
    public JSONResult getStudent()         // 2-6 SpringBoot 实现文件上传
    {
        Student stu = new Student();
        stu.setName("imooc");
        stu.setAge(22);

//        System.out.println(stu.toString());
        Student stu2 = new Student("风", 22);
        log.debug(stu.toString());
        log.info(stu.toString());
        log.warn(stu.toString());
        log.error(stu.toString());

//        return stu;
        return JSONResult.ok(stu);       // 2-6 SpringBoot 实现文件上传
    }

    // 2-6 SpringBoot 实现文件上传
    public String upload(MultipartFile file) throws Exception {

        file.transferTo(new File("D:\\ProgramData\\IntelliJ-IDEA\\Imooc-temp\\" + file.getOriginalFilename()));

        return "上传成功";
    }



}

