package com.example.booking_movie.service.impl;

import com.example.booking_movie.entity.Seat;
import com.example.booking_movie.repository.SeatRepository;
import com.example.booking_movie.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements ISeatService {
    @Autowired
    SeatRepository seatRepository;

    @Override
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Seat update(Seat seat) {
        return seatRepository.save(seat);
    }
}
