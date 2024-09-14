package com.example.booking_movie.repository;

import com.example.booking_movie.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime ,Long> {
    List<ShowTime> findBySchedule_Id(Long id);
}
