package com.example.booking_movie.repository;

import com.example.booking_movie.dto.response.BookSeatDTO;
import com.example.booking_movie.entity.BookedSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookSeatReposiory extends JpaRepository<BookedSeat,Long> {

    @Query("SELECT  b.seatId FROM BookedSeat b JOIN b.showTime s WHERE s.id = :id")
    List<Long> findByShowId(Long id);
}
