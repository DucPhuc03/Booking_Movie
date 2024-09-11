package com.example.booking_movie.controller;

import com.example.booking_movie.entity.Seat;
import com.example.booking_movie.service.impl.SeatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {
    @Autowired
    SeatServiceImpl seatService;
    @PostMapping("/seat/create")
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat){
        return ResponseEntity.ok(seatService.createSeat(seat));

    }
    @PutMapping("/seat/update")
    public ResponseEntity<Seat> updateSeat(@RequestBody Seat seat){
        return ResponseEntity.ok(seatService.createSeat(seat));

    }
}
