package com.MovieBooking.App.DTO;

//import lombok.Data;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.Getter;
//import lombok.Setter;


public class ShowDTO {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime showTime;
    private Double price;
    private Long movieId;
    private Long theaterId;

    public ShowDTO(LocalDateTime showTime, Double price, Long movieId, Long theaterId) {
        this.showTime = showTime;
        this.price = price;
        this.movieId = movieId;
        this.theaterId = theaterId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }

    @Override
    public String toString() {
        return "ShowDTO{" +
                "showTime=" + showTime +
                ", price=" + price +
                ", movieId=" + movieId +
                ", theaterId=" + theaterId +
                '}';
    }
}
