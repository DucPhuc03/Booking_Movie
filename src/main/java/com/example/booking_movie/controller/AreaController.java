package com.example.booking_movie.controller;

import com.example.booking_movie.entity.Area;
import com.example.booking_movie.service.impl.AreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AreaController {
    @Autowired
    AreaServiceImpl areaService;
    @PostMapping("/area/create")
    public ResponseEntity<Area> createArea(@RequestBody Area area){
        return ResponseEntity.ok(areaService.createArea(area));
    }
    @GetMapping("/area/get")
    public ResponseEntity<List<Area>> getArea(){
        return ResponseEntity.ok(areaService.getArea());
    }
}
