package com.example.booking_movie.service.impl;

import com.example.booking_movie.entity.Area;
import com.example.booking_movie.repository.AreaRepository;
import com.example.booking_movie.service.IAreaService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements IAreaService {
    @Autowired
    AreaRepository areaRepository;
    @Override
    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public List<Area> getArea() {

        return areaRepository.findAll();
    }
}
