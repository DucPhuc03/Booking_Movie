package com.example.booking_movie.controller;

import com.example.booking_movie.dto.response.ResScheduleDTO;
import com.example.booking_movie.entity.Schedule;
import com.example.booking_movie.service.impl.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    ScheduleServiceImpl scheduleService;
    @GetMapping("/schedule/get/{id}")
    public ResponseEntity<ResScheduleDTO> getScheduleByCinemaId(@PathVariable("id") Long id){
        return ResponseEntity.ok(scheduleService.getScheduleByCinemaId(id));
    }
    @PostMapping("/schedule/create")
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule){
        return ResponseEntity.ok(scheduleService.createSchedule(schedule));
    }
}
