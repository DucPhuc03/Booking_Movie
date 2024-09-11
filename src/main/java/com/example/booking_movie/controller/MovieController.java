package com.example.booking_movie.controller;

import com.example.booking_movie.dto.response.ResPageDTO;
import com.example.booking_movie.entity.Movie;
import com.example.booking_movie.service.impl.MovieServiceImpl;
import com.turkraft.springfilter.boot.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class MovieController {
    @Autowired
    MovieServiceImpl movieSevice;
    @PostMapping("/movie/create")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie req){
        return ResponseEntity.ok(movieSevice.createMovie(req));
    }
    @PutMapping("/movie/update")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie req){
        return ResponseEntity.ok(movieSevice.updateMovie(req));
    }
    @GetMapping("/movie/get")
    public ResponseEntity<ResPageDTO> getMovie(@Filter Specification<Movie>  spec, Pageable pageable){
        return ResponseEntity.ok(movieSevice.getAllMovie(spec,pageable));
    }
    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id){
        return ResponseEntity.ok(movieSevice.getMovieById(id));
    }
}
