package com.czxy.service;

import com.czxy.dao.RoomMapper;
import com.czxy.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;

    public Room findRoomByRid(Integer roomId){
        Room room = roomMapper.selectByPrimaryKey(roomId);
        return room;
    }

}
