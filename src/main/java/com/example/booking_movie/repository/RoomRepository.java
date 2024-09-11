package com.example.booking_movie.repository;

import com.example.booking_movie.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room ,Long> {
}
