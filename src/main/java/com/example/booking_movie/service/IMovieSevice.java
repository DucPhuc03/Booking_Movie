package com.example.booking_movie.service;

import com.example.booking_movie.dto.response.ResPageDTO;
import com.example.booking_movie.entity.Movie;
import com.example.booking_movie.exception.InvalidException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface IMovieSevice {
    Movie createMovie(Movie movie);
    Movie updateMovie(Movie movie);
    ResPageDTO getAllMovie(Specification<Movie> spec,Pageable pageable);
}
