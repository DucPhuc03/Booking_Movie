package com.example.booking_movie.mapper;

import com.example.booking_movie.dto.response.CinemaDTO;
import com.example.booking_movie.dto.response.ResBranchDTO;
import com.example.booking_movie.entity.Cinema;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CinemaMapper {
    List<ResBranchDTO.CinemaBranchDTO> toDto(List<Cinema> cinemas);
    CinemaDTO toDto(Cinema cinema);
}
