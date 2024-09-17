package com.example.booking_movie.mapper;

import com.example.booking_movie.dto.response.SeatDTO;
import com.example.booking_movie.entity.Seat;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    List<SeatDTO> toDtos(List<Seat> seats);
}
