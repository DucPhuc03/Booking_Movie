package com.example.booking_movie.service.impl;

import com.example.booking_movie.entity.Branch;
import com.example.booking_movie.exception.InvalidException;
import com.example.booking_movie.repository.BranchRepository;
import com.example.booking_movie.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements IBranchService {
    @Autowired
    BranchRepository branchRepository;
    @Override
    public Branch createBranch(Branch branch) {
        boolean checkBranch=branchRepository.existsByName(branch.getName());
        if(checkBranch){
            throw new InvalidException("branch da ton tai");
        }
        return branchRepository.save(branch);
    }

    @Override
    public Branch updateBranch(Branch branch) {

        return branchRepository.save(branch);
    }

    @Override
    public List<Branch> getBranch() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getBranchById(Long id) {
        return branchRepository.findById(id).orElseThrow();
    }
}
