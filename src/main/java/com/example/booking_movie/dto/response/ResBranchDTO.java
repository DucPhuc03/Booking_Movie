package com.example.booking_movie.dto.response;

import com.example.booking_movie.entity.Area;
import com.example.booking_movie.entity.Cinema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResBranchDTO {
    private Long id;
    private String name;
    private String logo;
    private Area area;
    private List<CinemaBranchDTO> cinemas;
    @Getter
    @Setter
    @NoArgsConstructor
    public static class CinemaBranchDTO{
        private Long id;
        private String name;
        private String address;
    }
}

