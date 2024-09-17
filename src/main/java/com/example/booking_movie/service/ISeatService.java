package com.example.booking_movie.service;

import com.example.booking_movie.dto.response.SeatDTO;
import com.example.booking_movie.entity.Seat;

import java.util.List;

public interface ISeatService {
    Seat createSeat(Seat seat);
    Seat update(Seat seat);
    List<SeatDTO> getSeat(Long id);
}
