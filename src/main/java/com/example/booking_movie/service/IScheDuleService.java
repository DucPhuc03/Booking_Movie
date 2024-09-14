package com.example.booking_movie.service;

import com.example.booking_movie.dto.response.ResScheduleDTO;
import com.example.booking_movie.entity.Schedule;

import java.util.List;

public interface IScheDuleService {
    Schedule createSchedule(Schedule schedule);
    ResScheduleDTO getScheduleByCinemaId(Long id);
}
