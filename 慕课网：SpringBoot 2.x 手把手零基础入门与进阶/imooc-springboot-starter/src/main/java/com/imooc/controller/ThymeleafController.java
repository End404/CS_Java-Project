package com.imooc.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

// 4-1 入门Thymeleaf模板与基本使用
@Controller
@Slf4j
@RequestMapping("thyme")
public class ThymeleafController {

    @GetMapping("hello")
    public String hello(Model model, HttpServletRequest request){

        String stranger = "Jack";
        model.addAttribute("there", stranger);

        Date birthday = new Date();
        model.addAttribute("birthda", birthday);

        Integer sex = 0;    // 4-3 Thymeleaf 的各种条件判断
        model.addAttribute("sex", sex);

//        4-4 Thymeleaf 循环遍历list与map
        List<String> myList = new ArrayList<>();
        myList.add("Java");
        myList.add("SingBoot");
        myList.add("微服务");
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("id", 10010);
        myMap.put("name", "Jack");
        myMap.put("sex", "男");
        myMap.put("loves", myList);
        model.addAttribute("myList", myList);
        model.addAttribute("myMap", myMap);

//        4-6 Thymeleaf 操作request和session
        request.setAttribute("englishName", "xyzabc");
        request.getSession().setAttribute("userToken", "hfui-gwh-ouf-wfc");

        return "thacher";


    }

// 4-7 Thymeleaf 实现页面静态化html
    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("createHTML")
    @ResponseBody
    public String createHTML(Model model, HttpServletRequest request) throws Throwable {

        String stranger = "Jack";
        model.addAttribute("there", stranger);

        Date birthday = new Date();
        model.addAttribute("birthda", birthday);

        Integer sex = 0;    // 4-3 Thymeleaf 的各种条件判断
        model.addAttribute("sex", sex);

//        4-4 Thymeleaf 循环遍历list与map
        List<String> myList = new ArrayList<>();
        myList.add("Java");
        myList.add("SingBoot");
        myList.add("微服务");
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("id", 10010);
        myMap.put("name", "Jack");
        myMap.put("sex", "男");
        myMap.put("loves", myList);
        model.addAttribute("myList", myList);
        model.addAttribute("myMap", myMap);

//        4-6 Thymeleaf 操作request和session
        request.setAttribute("englishName", "xyzabc");
        request.getSession().setAttribute("userToken", "hfui-gwh-ouf-wfc");

        //开始静态化
        Context context = new Context();
        context.setVariable("birthday", birthday);
        context.setVariable("there", stranger);
        context.setVariable("sex", stranger);
        context.setVariable("myList", stranger);
        context.setVariable("myMap", stranger);

        //定义html最终保存生成的目录位置
        String path = "D:\\ProgramData\\IntelliJ-IDEA\\IntelliJ-IDEA_U_2019.3\\temp";

        Writer out = new FileWriter(path + "\\teacher.html");
        templateEngine.process("tecaher", context, out);
        out.close();

        return "ok";
    }


}

