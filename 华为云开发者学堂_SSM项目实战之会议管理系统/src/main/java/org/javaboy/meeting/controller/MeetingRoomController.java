

/**
 * 5.1 查看会议室
 * 5.2 会议室详情
 *
 */


package org.javaboy.meeting.controller;

import org.javaboy.meeting.model.MeetingRoom;
import org.javaboy.meeting.servlice.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//5.1
@Controller
public class MeetingRoomController {
    @Autowired
    MeetingRoomService meetingRoomService;
    @RequestMapping("/meetingrooms")
    public String meetingrooes(Model model){
        model.addAttribute("mrs", meetingRoomService.getAllMr());
        return "meetingrooms";
    }

//    5.2
    @RequestMapping("/roomdetails")
    public String roomdetails(Integer roomid, Model model){
        model.addAttribute("mr", meetingRoomService.getMrById(roomid));
        return "roomdeatails";
    }
    @RequestMapping("/updateroom")
    public String updateRoom(MeetingRoom meetingRoom) {
        Integer result = meetingRoomService.updateRoom(meetingRoom);
        if (result == 1) {
            return "redirect:/meetingrooms";
        }else {
            return "forward:/roomdetails";
        }
    }

//    5.3 添加会议室
    @RequestMapping("/admin/addmeetionroom")
    public String addmeetingroom(){
        return "addmeeingroom";
    }
    @RequestMapping("/admin/doAddMr")
    public String doAddMr(MeetingRoom meetingRoom){
        Integer result = meetingRoomService.addMr(meetingRoom);
        return "redirect:/meetingrooms";
    }

}
