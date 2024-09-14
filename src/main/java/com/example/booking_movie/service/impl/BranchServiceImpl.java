package com.example.booking_movie.service.impl;

import com.example.booking_movie.dto.response.ResBranchDTO;
import com.example.booking_movie.entity.Branch;
import com.example.booking_movie.entity.Cinema;
import com.example.booking_movie.exception.InvalidException;
import com.example.booking_movie.mapper.CinemaMapper;
import com.example.booking_movie.repository.BranchRepository;
import com.example.booking_movie.repository.CinemaRepository;
import com.example.booking_movie.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements IBranchService {
    @Autowired
    CinemaMapper cinemaMapper;
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    CinemaRepository cinemaRepository;
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
    public List<ResBranchDTO> getBranchByAreaId(Long id) {
        List<Branch> branches=branchRepository.findByArea_Id(id);
        List<ResBranchDTO>res = branches.stream().map(item->
                new ResBranchDTO(
                item.getId(),
                item.getName(),
                item.getLogo(),
                item.getArea(),
                cinemaMapper.toDto(cinemaRepository.findByBranch_Id(item.getId()))

        )).toList();
        return res;
    }
}
