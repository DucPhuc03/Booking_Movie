package com.example.booking_movie.service.impl;

import com.example.booking_movie.dto.response.ResScheduleDTO;
import com.example.booking_movie.dto.response.RoomDTO;
import com.example.booking_movie.dto.response.ShowTimeDTO;
import com.example.booking_movie.entity.Cinema;
import com.example.booking_movie.entity.Schedule;
import com.example.booking_movie.entity.ShowTime;
import com.example.booking_movie.mapper.CinemaMapper;
import com.example.booking_movie.mapper.ShowTimeMapper;
import com.example.booking_movie.repository.CinemaRepository;
import com.example.booking_movie.repository.ScheduleRepository;
import com.example.booking_movie.repository.ShowTimeRepository;
import com.example.booking_movie.service.IScheDuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements IScheDuleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    ShowTimeRepository showTimeRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    CinemaMapper cinemaMapper;
    @Autowired
    ShowTimeMapper showTimeMapper;
    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public ResScheduleDTO getScheduleByCinemaId(Long id) {
        Optional<Cinema> cinemaOptional=cinemaRepository.findById(id);
        Cinema cinema=cinemaOptional.get();
        ResScheduleDTO data=new ResScheduleDTO();
        data.setCinema(cinemaMapper.toDto(cinema));
        List<Schedule> schedules=scheduleRepository.findByCinema_Id(id);
        List<ResScheduleDTO.ScheduleDTO> res=schedules.stream().map(item-> new ResScheduleDTO.ScheduleDTO(
                item.getId(),
                item.getShowDate(),
                item.getMovie(),
                toShowtimeDTO(showTimeRepository.findBySchedule_Id(item.getId()))
        )).toList();

        data.setSchedules(res);
        return data;
    }

    @Override
    public List<ShowTimeDTO> toShowtimeDTO(List<ShowTime> showTimes) {
        List<ShowTimeDTO> res=showTimes.stream().map(item->new ShowTimeDTO(
                item.getId(),
                item.getStartTime(),
                new RoomDTO(item.getRoom().getId(),item.getRoom().getName())
        )).toList();
        return res;
    }
}
