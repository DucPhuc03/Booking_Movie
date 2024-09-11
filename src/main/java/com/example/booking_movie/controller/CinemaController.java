package com.example.booking_movie.controller;

import com.example.booking_movie.entity.Cinema;
import com.example.booking_movie.service.impl.CinemaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    @Autowired
    CinemaServiceImpl cinemaService;
    @PostMapping("/cinema/create")
    public ResponseEntity<Cinema> createCinema(@RequestBody Cinema cinema){
        return ResponseEntity.ok(cinemaService.createCinema(cinema));
    }
    @PutMapping("/cinema/update")
    public ResponseEntity<Cinema> updateCinema(@RequestBody Cinema cinema){
        return ResponseEntity.ok(cinemaService.updateCinema(cinema));
    }
}
