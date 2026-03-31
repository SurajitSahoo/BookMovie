package com.MovieBooking.App.DTO;

import com.MovieBooking.App.entity.BookingStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class BookingDTO  {
    private Integer numberOfSeats;
    private LocalDateTime bookingTime;
    private Double price;
    private BookingStatus bookingStatus;
    private List<String> seatNumbers;
    private Long userId;
    private Long showId;
}
