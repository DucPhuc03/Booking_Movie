package com.example.booking_movie.service;

import com.example.booking_movie.entity.Area;

import java.util.List;

public interface IAreaService {
    Area createArea(Area area);
    List<Area> getArea();
}
