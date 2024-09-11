package com.example.booking_movie.service;

import com.example.booking_movie.dto.response.ResPageDTO;
import com.example.booking_movie.entity.Cinema;
import org.springframework.data.jpa.domain.Specification;

public interface ICinemaService {
    Cinema createCinema(Cinema cinema);
    Cinema updateCinema(Cinema cinema);
    Cinema getCinema(Specification<Cinema> spec);
}
