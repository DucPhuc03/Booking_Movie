package com.example.booking_movie.service.impl;

import com.example.booking_movie.entity.ShowTime;
import com.example.booking_movie.repository.ShowTimeRepository;
import com.example.booking_movie.service.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowTimeServiceImpl implements IShowTimeService {
    @Autowired
    ShowTimeRepository showTimeRepository;
    @Override
    public ShowTime createShowTime(ShowTime showTime) {
        return showTimeRepository.save(showTime);
    }
}
