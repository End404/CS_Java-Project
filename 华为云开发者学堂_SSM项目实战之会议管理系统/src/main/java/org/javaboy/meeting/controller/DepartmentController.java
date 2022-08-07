
//    2.2
//      3.6
//        4.1 部门管理


package org.javaboy.meeting.controller;

import org.javaboy.meeting.model.Department;
import org.javaboy.meeting.servlice.DepartmentServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class DepartmentController {

    @Autowired
    DepartmentServce departmentServce;      // 4.1
    @RequestMapping("/departments")
    public String departments(Model model) {
        model.addAttribute("deps", departmentServce.getAllDeps());  //4.1
        return "departments";
    }

//    4.1
    @RequestMapping("/adddepartment")
    public String adddepartment(String departmentname){
        departmentServce.adddepartment(departmentname);
        return "redirect:/departments";
    }
    @RequestMapping("/deletedep")
    public String deletedep(Integer departmentid) {
        departmentServce.deletedep(departmentid);
        return "redirect:/departments";
    }

    //  4.2
    @RequestMapping("/updatedep")
    @ResponseBody
    public String updatedep(Integer id, String name){
        Integer result = departmentServce.updatedep(id, name);
        if (result == 1){
            return "success";
        }
        return "error";
    }



}
