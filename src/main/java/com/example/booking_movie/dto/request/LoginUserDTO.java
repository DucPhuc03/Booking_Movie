package com.example.booking_movie.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.thymeleaf.spring6.processor.SpringErrorClassTagProcessor;

@NoArgsConstructor
@Setter
@Getter
public class LoginUserDTO {
    private String username;
    private String password;

    @NoArgsConstructor
    @Setter
    @Getter
    public static class UserToken{
        private Long Id;
        private String username;
        private String email;
    }
}
