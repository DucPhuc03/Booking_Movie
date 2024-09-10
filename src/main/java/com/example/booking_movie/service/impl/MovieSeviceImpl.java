package com.example.booking_movie.service.impl;

import com.example.booking_movie.dto.response.MetaDTO;
import com.example.booking_movie.dto.response.ResPageDTO;
import com.example.booking_movie.entity.Movie;
import com.example.booking_movie.exception.InvalidException;
import com.example.booking_movie.repository.MovieRepository;
import com.example.booking_movie.service.IMovieSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieSeviceImpl implements IMovieSevice {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public Movie createMovie(Movie movie) {
        boolean checkMovie=movieRepository.existsByName(movie.getName());
        if(checkMovie){
            throw  new InvalidException("movie da ton tai");
        }

        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Optional<Movie> optionalMovie=movieRepository.findById(movie.getId());
        Movie movieDB=optionalMovie.get();
        if(optionalMovie.isEmpty()){
            throw new InvalidException("movie khong ton tai");
        }
        movieDB.setName(movie.getName());
        movieDB.setDescription(movie.getDescription());
        movieDB.setReleaseDate(movie.getReleaseDate());
        movieDB.setStatus(movie.getStatus());

        return movieDB;
    }

    @Override
    public ResPageDTO getAllMovie(Specification<Movie> spec,Pageable pageable) {
        ResPageDTO res=new ResPageDTO();
        Page<Movie> moviePage=movieRepository.findAll(spec,pageable);
        MetaDTO mt=new MetaDTO();
        mt.setPage(pageable.getPageNumber()+1);
        mt.setPageSize(pageable.getPageSize());
        mt.setPages(moviePage.getTotalPages());
        mt.setTotal(moviePage.getTotalElements());
        res.setMeta(mt);
        res.setResult(moviePage.getContent());
        return res;
    }
}
