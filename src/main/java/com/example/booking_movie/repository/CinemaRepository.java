package com.example.booking_movie.repository;

import com.example.booking_movie.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> , JpaSpecificationExecutor<Cinema> {
    boolean existsByNameAndAddress(String name, String address);
}
