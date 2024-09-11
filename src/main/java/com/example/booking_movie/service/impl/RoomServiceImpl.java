package com.example.booking_movie.service.impl;

import com.example.booking_movie.entity.Room;
import com.example.booking_movie.repository.RoomRepository;
import com.example.booking_movie.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    RoomRepository roomRepository;
    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }
}
