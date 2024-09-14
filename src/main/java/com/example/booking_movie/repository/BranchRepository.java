package com.example.booking_movie.repository;

import com.example.booking_movie.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {
    boolean existsByName(String name);
    List<Branch> findByArea_Id(Long id);
}
