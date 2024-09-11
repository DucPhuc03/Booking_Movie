package com.example.booking_movie.service.impl;

import com.example.booking_movie.entity.Cinema;
import com.example.booking_movie.exception.InvalidException;
import com.example.booking_movie.repository.CinemaRepository;
import com.example.booking_movie.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements ICinemaService {
    @Autowired
    CinemaRepository cinemaRepository;
    @Override
    public Cinema createCinema(Cinema cinema) {
        boolean checkCinema=cinemaRepository.existsByNameAndAddress(cinema.getName(), cinema.getAddress());
        if(checkCinema){
            throw new InvalidException("Cinema da ton tai");
        }
        if(cinema.getBranch()==null){
            throw new InvalidException("branch khong ton tai");
        }
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema updateCinema(Cinema cinema) {
        return null;
    }

    @Override
    public Cinema getCinema(Specification<Cinema> spec) {
        return null;
    }
}
