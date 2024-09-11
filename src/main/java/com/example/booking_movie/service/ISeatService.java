package com.example.booking_movie.service;

import com.example.booking_movie.entity.Seat;

public interface ISeatService {
    Seat createSeat(Seat seat);
    Seat update(Seat seat);
}
