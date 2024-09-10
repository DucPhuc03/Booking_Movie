package com.example.booking_movie.controller;

import com.example.booking_movie.dto.request.LoginUserDTO;
import com.example.booking_movie.dto.response.ResLoginDTO;
import com.example.booking_movie.entity.User;
import com.example.booking_movie.repository.UserRepository;
import com.example.booking_movie.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthServiceImpl authServiceImpl;
    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Value("${com.example.cookie-expiration}")
    private long expriration_cookie;
    @PostMapping("/auth/login")
    public ResponseEntity<ResLoginDTO> login(@RequestBody LoginUserDTO loginUserDTO){
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(loginUserDTO.getUsername(), loginUserDTO.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User userDB=userRepository.findByUsername(loginUserDTO.getUsername());
        LoginUserDTO.UserToken res=new LoginUserDTO.UserToken();
        res.setId(userDB.getId());
        res.setUsername(userDB.getUsername());
        res.setEmail(userDB.getEmail());
        String access_token= authServiceImpl.createToken(res);
        ResLoginDTO resLoginDTO=new ResLoginDTO();
        resLoginDTO.setId(userDB.getId());
        resLoginDTO.setUsername(userDB.getUsername());
        resLoginDTO.setEmail(userDB.getEmail());
        resLoginDTO.setAcces_token(access_token);

        ResponseCookie responseCookie=ResponseCookie.from("access_token",access_token)
                .httpOnly(true)
                .path("/")
                .secure(true)
                .maxAge(expriration_cookie)
                .build();

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,responseCookie.toString()).body(resLoginDTO);
    }
}
