package com.example.booking_movie.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;
    private String director;
    private String actor;
    private String genre;
    private int duration;
    private Date releaseDate;
    private String language;
    private String posterURL;
    private String trailerURL;
    private int status;

}
