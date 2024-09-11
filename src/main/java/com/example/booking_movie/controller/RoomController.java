package com.example.booking_movie.controller;

import com.example.booking_movie.entity.Room;
import com.example.booking_movie.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @Autowired
    RoomServiceImpl roomService;
    @PostMapping("/room/create")
    public ResponseEntity<Room> createRoom(@RequestBody Room room){
        return ResponseEntity.ok(roomService.createRoom(room));
    }
    @PutMapping("/room/update")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room){
        return ResponseEntity.ok(roomService.updateRoom(room));
    }
}
