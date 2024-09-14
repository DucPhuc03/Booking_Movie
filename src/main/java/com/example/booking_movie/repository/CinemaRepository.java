package com.example.booking_movie.repository;

import com.example.booking_movie.dto.response.CinemaDTO;
import com.example.booking_movie.dto.response.ResBranchDTO;
import com.example.booking_movie.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> , JpaSpecificationExecutor<Cinema> {
    boolean existsByNameAndAddress(String name, String address);
    List<Cinema> findByBranch_Id(Long id);
}
