/**
 * 第5章
 *
 */


package org.javaboy.meeting.servlice;

import org.javaboy.meeting.model.MeetingRoom;
import org.javaboy.meeting.mapper.MeetingRoomMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {
    @Autowired
    MeetingRoomMaper meetingRoomMaper;
    public List<MeetingRoom> getAllMr() {   //5.1
        return meetingRoomMaper.getAllMr();
    }

    public MeetingRoom getMrById(Integer roomid) {  //5.2
        return meetingRoomMaper.getMrById(roomid);
    }
    public Integer updateRoom(MeetingRoom meetingRoom) {
        return meetingRoomMaper.updateRoom(meetingRoom);
    }


//    5.3
    public Integer addMr(MeetingRoom meetingRoom) {
        return meetingRoomMaper.addMr(meetingRoom);
    }
}
