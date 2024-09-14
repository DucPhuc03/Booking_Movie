package com.example.booking_movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "area")
@Getter
@Setter
@NoArgsConstructor
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private int cinema;
    @OneToMany(mappedBy = "area",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Cinema> cinemaList;
    @PreUpdate
    private void updateCinema() {
        if (cinemaList != null) {
            this.cinema = cinemaList.size();
        } else {
            this.cinema = 0;
        }
    }
}
