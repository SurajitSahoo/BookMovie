package com.MovieBooking.App.DTO;

import com.MovieBooking.App.entity.BookingStatus;


import java.time.LocalDateTime;
import java.util.List;


public class BookingResponseDTO {

    private Long bookingId;
    private Integer numberOfSeats;
    private LocalDateTime bookingTime;
    private Double price;
    private BookingStatus bookingStatus;

    private List<String> seatNumbers;

    private Long userId;
    private Long showId;

    public BookingResponseDTO(Long bookingId, Integer numberOfSeats, LocalDateTime bookingTime, Double price, BookingStatus bookingStatus, List<String> seatNumbers, Long userId, Long showId) {
        this.bookingId = bookingId;
        this.numberOfSeats = numberOfSeats;
        this.bookingTime = bookingTime;
        this.price = price;
        this.bookingStatus = bookingStatus;
        this.seatNumbers = seatNumbers;
        this.userId = userId;
        this.showId = showId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
    public BookingResponseDTO() {
    }
    @Override
    public String toString() {
        return "BookingResponseDTO{" +
                "bookingId=" + bookingId +
                ", numberOfSeats=" + numberOfSeats +
                ", bookingTime=" + bookingTime +
                ", price=" + price +
                ", bookingStatus=" + bookingStatus +
                ", seatNumbers=" + seatNumbers +
                ", userId=" + userId +
                ", showId=" + showId +
                '}';
    }
}