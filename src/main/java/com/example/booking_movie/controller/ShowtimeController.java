package com.example.booking_movie.controller;

import com.example.booking_movie.entity.ShowTime;
import com.example.booking_movie.service.impl.ShowTimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowtimeController {
    @Autowired
    ShowTimeServiceImpl showTimeService;
    @PostMapping("/showtime/create")
    public ResponseEntity<ShowTime> createShowTime(@RequestBody ShowTime showTime){
        return ResponseEntity.ok(showTimeService.createShowTime(showTime));
    }
}
