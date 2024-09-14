package com.example.booking_movie.controller;

import com.example.booking_movie.dto.response.ResBranchDTO;
import com.example.booking_movie.entity.Branch;
import com.example.booking_movie.service.impl.BranchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    BranchServiceImpl branchService;
    @PostMapping("/branch/create")
    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch){
        return ResponseEntity.ok(branchService.createBranch(branch));
    }
    @PutMapping("/branch/update")
    public ResponseEntity<Branch> updateBranch(@RequestBody Branch branch){
        return ResponseEntity.ok(branchService.updateBranch(branch));
    }
    @GetMapping("/branch/get")
    public ResponseEntity<List<Branch>> getBranch(){
        return ResponseEntity.ok(branchService.getBranch());
    }
    @GetMapping("/branch/get/{id}")
    public ResponseEntity<List<ResBranchDTO>> getBranchByAreaId(@PathVariable("id") Long id){
        return ResponseEntity.ok(branchService.getBranchByAreaId(id));
    }
}
