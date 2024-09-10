package com.example.booking_movie.dto.response;

import ch.qos.logback.core.joran.action.AppenderRefAction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResLoginDTO {
    private Long Id;
    private String username;
    private String email;
    private String acces_token;
}
