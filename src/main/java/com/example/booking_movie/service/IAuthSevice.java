package com.example.booking_movie.service;

import com.example.booking_movie.dto.request.LoginUserDTO;

public interface IAuthSevice {
    String createToken(LoginUserDTO.UserToken userDTO);
}
