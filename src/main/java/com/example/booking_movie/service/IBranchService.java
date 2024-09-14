package com.example.booking_movie.service;

import com.example.booking_movie.dto.response.ResBranchDTO;
import com.example.booking_movie.entity.Branch;

import java.util.List;

public interface IBranchService {
    Branch createBranch(Branch branch);
    Branch updateBranch(Branch branch);
    List<Branch> getBranch();
    List<ResBranchDTO> getBranchByAreaId(Long id);
}
