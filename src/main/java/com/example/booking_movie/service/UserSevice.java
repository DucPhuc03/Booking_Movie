package com.example.booking_movie.service;

import com.example.booking_movie.entity.User;
import com.example.booking_movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevice {
    @Autowired
    UserRepository userRepository;
    public User creteUser(User user){
        return userRepository.save(user);
    }
}
