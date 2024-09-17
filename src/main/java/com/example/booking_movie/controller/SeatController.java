package com.example.booking_movie.controller;

import com.example.booking_movie.dto.response.SeatDTO;
import com.example.booking_movie.entity.Seat;
import com.example.booking_movie.service.impl.SeatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/seat/get/{showtime_id}")
    public ResponseEntity<List<SeatDTO>> getSeat(@PathVariable("showtime_id") Long id){
        return ResponseEntity.ok(seatService.getSeat(id));
    }
}
