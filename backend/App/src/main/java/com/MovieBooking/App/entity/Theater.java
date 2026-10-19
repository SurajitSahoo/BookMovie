package com.MovieBooking.App.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import lombok.Data;

import java.util.List;

@Entity

public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theaterName;
    private String theaterLocation;
    private Integer theaterCapacity;
    private String theaterScreenType;

    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Show> show;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterLocation() {
        return theaterLocation;
    }

    public void setTheaterLocation(String theaterLocation) {
        this.theaterLocation = theaterLocation;
    }

    public Integer getTheaterCapacity() {
        return theaterCapacity;
    }

    public void setTheaterCapacity(Integer theaterCapacity) {
        this.theaterCapacity = theaterCapacity;
    }

    public String getTheaterScreenType() {
        return theaterScreenType;
    }

    public void setTheaterScreenType(String theaterScreenType) {
        this.theaterScreenType = theaterScreenType;
    }

    public List<Show> getShow() {
        return show;
    }

    public void setShow(List<Show> show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", theaterName='" + theaterName + '\'' +
                ", theaterLocation='" + theaterLocation + '\'' +
                ", theaterCapacity=" + theaterCapacity +
                ", theaterScreenType='" + theaterScreenType + '\'' +
                ", show=" + show +
                '}';
    }
}