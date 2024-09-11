package com.example.booking_movie.repository;

import com.example.booking_movie.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {
    boolean existsByName(String name);
}
