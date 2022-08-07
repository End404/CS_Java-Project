/**
 * 5.4 会议预定-1
 *  5.5 会议预定-2
 *  5.7
 *
 */


package org.javaboy.meeting.controller;

import org.javaboy.meeting.model.Department;
import org.javaboy.meeting.model.Employee;
import org.javaboy.meeting.model.Meeting;
import org.javaboy.meeting.servlice.DepartmentServce;
import org.javaboy.meeting.servlice.EmployeeService;
import org.javaboy.meeting.servlice.MeetingRoomService;
import org.javaboy.meeting.servlice.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import java.util.List;


@Controller
public class MeetingController {
    @Autowired
    MeetingRoomService meetingRoomService;
    @Autowired
    DepartmentServce departmentServce;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    private MeetingService meetingService;

    @RequestMapping("/bookmeeting")
    public String bookmeeting(Model model){     //5.4
        model.addAttribute("mrs",meetingRoomService.getAllMr());
        return "bookmeeting";
    }

    @RequestMapping("/alldeps")
    @ResponseBody
    public List<Department> getAllDeps(){   //5.5
        return departmentServce.getAllDeps();
    }
    @RequestMapping("/getempbydepid")
    @ResponseBody
    public List<Employee> getEmpsByDepId(Integer depId){
        return employeeService.getEmpsByDepId(depId);
    }

//    5.7
    @RequestMapping("/doAddMeeting")
    public String doAddMeeting(Meeting meeting, Integer[] mps, HttpServlet session){
        Employee currentuser = (Employee) session.getAttribute("currentUser");
        meeting.setReservationistid(currentuser.getEmployeeid());
        Integer resutl = meetingService.addMeeting(meeting,mps);
        if (resutl==1){
            return "redirect:/searchmeeting";
        }else {
            return "forward:bookmeeting";
        }
    }
    @RequestMapping("/searchmeetings")
    public String searchmeetings() {
        return "serarchmeetings";
    }

}
