package com.MovieBooking.App.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity


public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfSeats;
    private LocalDateTime bookingTime;
    private Double price;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "booking_seat_numbers")
    private List<String > seatNumbers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"password","bookings"})
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "show_id", nullable = false)
    @JsonIgnore
    private Show show;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", numberOfSeats=" + numberOfSeats +
                ", bookingTime=" + bookingTime +
                ", price=" + price +
                ", bookingStatus=" + bookingStatus +
                ", seatNumbers=" + seatNumbers +
                ", user=" + user +
                ", show=" + show +
                '}';
    }
}
