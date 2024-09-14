package com.example.booking_movie.dto.response;

import com.example.booking_movie.entity.Cinema;
import com.example.booking_movie.entity.Movie;
import com.example.booking_movie.entity.ShowTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResScheduleDTO {
    private CinemaDTO cinema;
    private List<ScheduleDTO> schedules;
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduleDTO{
        private Long id;
        private Date showDate;
        private Movie movie;
        private List<ShowTimeDTO> showTimes;
    }
}
