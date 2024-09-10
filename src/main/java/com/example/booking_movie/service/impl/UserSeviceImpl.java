package com.example.booking_movie.service.impl;

import com.example.booking_movie.entity.User;
import com.example.booking_movie.repository.UserRepository;
import com.example.booking_movie.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSeviceImpl implements IUserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        String ps=passwordEncoder.encode(user.getPassword());
        user.setPassword(ps);
        return userRepository.save(user);
    }
}
