

//    第2章 项目环境搭建
//   2.1 项目搭建
//  2.3 整合Freemarker


package org.javaboy.meeting.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController     //2.1
@Controller     //2.3
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", "hello javaboy");   //2.3
        return "hello";     //2.1
    }
}
