package com.example.booking_movie.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MetaDTO {
    private int page;
    private int pageSize;
    private int pages;
    private long total;
}
