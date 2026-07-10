package com.MovieBooking.App.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ShowDTO {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime showTime;
    private Double price;
    private Long movieId;
    private Long theaterId;
}
