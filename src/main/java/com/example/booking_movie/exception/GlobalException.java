package com.example.booking_movie.exception;

import com.example.booking_movie.dto.response.GlobalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = InvalidException.class)
    public ResponseEntity<GlobalResponse<Object>> handleInvalitException(InvalidException invalidException){
        GlobalResponse<Object> res=new GlobalResponse<>();
        res.setStatus(HttpStatus.BAD_REQUEST.value());
        res.setMessage(invalidException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
