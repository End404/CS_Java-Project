
//    第5章

package org.javaboy.meeting.mapper;

import org.javaboy.meeting.model.MeetingRoom;

import java.util.List;

public interface MeetingRoomMaper {

    List<MeetingRoom> getAllMr();   //5.1

    MeetingRoom getMrById(Integer roomid);  //5.2

    Integer updateRoom(MeetingRoom meetingRoom);    //5.2

    Integer addMr(MeetingRoom meetingRoom);     //5.3

}
