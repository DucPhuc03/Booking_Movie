package com.example.booking_movie.mapper;

import com.example.booking_movie.dto.response.ShowTimeDTO;
import com.example.booking_movie.entity.ShowTime;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShowTimeMapper {
    //List<ShowTimeDTO> toShowTimeDtos(List<ShowTime> showTimes);
}
