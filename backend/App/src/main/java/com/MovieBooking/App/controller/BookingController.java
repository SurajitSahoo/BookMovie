package com.MovieBooking.App.controller;

import com.MovieBooking.App.DTO.BookingDTO;
import com.MovieBooking.App.entity.Booking;
import com.MovieBooking.App.entity.BookingStatus;
import com.MovieBooking.App.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.MovieBooking.App.DTO.BookingResponseDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @PostMapping("/createbooking")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.createBooking(bookingDTO));
    }
    @GetMapping("/getuserbookings/{id}")
    public ResponseEntity<List<BookingResponseDTO>>
    getUserBookings(@PathVariable Long id) {

        return ResponseEntity.ok(
                bookingService.getUserBookings(id)
        );
    }
    @GetMapping("/getshowbookings/{id}")
    public ResponseEntity<List<BookingResponseDTO>>
    getShowBookings(@PathVariable Long id) {

        return ResponseEntity.ok(
                bookingService.getShowBookings(id)
        );
    }
    @PutMapping("{id}/confirm")
    public ResponseEntity<Booking> confirmBooking(@PathVariable Long id)
    {
        return ResponseEntity.ok(bookingService.confirmBooking(id));
    }
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }
    @GetMapping("/getallbookings")
    public ResponseEntity<List<BookingResponseDTO>>
    getAllBookings() {

        return ResponseEntity.ok(
                bookingService.getAllBookings()
        );
    }
}