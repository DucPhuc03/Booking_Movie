package com.example.booking_movie.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GlobalResponse<T> {
    private int status;
    private String message;
    private T data;
}
