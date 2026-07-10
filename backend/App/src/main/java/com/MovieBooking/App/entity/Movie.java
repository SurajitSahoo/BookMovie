package com.MovieBooking.App.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String genre;
    private Integer duration;
    private LocalDate releaseDate;
    private String language;

    @Column(length = 500)
    private String imageUrl;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Show> show;
}