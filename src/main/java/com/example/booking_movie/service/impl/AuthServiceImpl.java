package com.example.booking_movie.service.impl;

import com.example.booking_movie.dto.request.LoginUserDTO;
import com.example.booking_movie.service.IAuthSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.springframework.security.oauth2.jose.jws.MacAlgorithm.HS256;

@Service
public class AuthServiceImpl implements IAuthSevice {
    @Autowired
    JwtEncoder jwtEncoder;
    @Value("${com.example.jwt-expiration}")
    private long jwtExpiration;
    @Override
    public String createToken(LoginUserDTO.UserToken userDTO){
    Instant now=Instant.now();
    Instant expriration=now.plus(jwtExpiration, ChronoUnit.SECONDS);
    JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
            .issuedAt(now)
            .expiresAt(expriration)
            .claim("user", userDTO)
            .subject(userDTO.getUsername())
            .build();
    JwsHeader jwsHeader=JwsHeader.with(HS256).build();
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, jwtClaimsSet)).getTokenValue();
    }
}
