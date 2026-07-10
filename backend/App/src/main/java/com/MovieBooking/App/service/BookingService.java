package com.MovieBooking.App.service;

import com.MovieBooking.App.DTO.BookingDTO;
import com.MovieBooking.App.DTO.BookingResponseDTO;
import com.MovieBooking.App.Repository.BookingRepository;
import com.MovieBooking.App.Repository.ShowRepository;
import com.MovieBooking.App.Repository.UserRepository;
import com.MovieBooking.App.entity.Booking;
import com.MovieBooking.App.entity.BookingStatus;
import com.MovieBooking.App.entity.Show;
import com.MovieBooking.App.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;


    public Booking createBooking(BookingDTO bookingDTO) {
// we need to check whether the seats are available or Not
        Show show = showRepository.findById(bookingDTO.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found"));

        if (!isSeatsAvailable(show.getId(), bookingDTO.getNumberOfSeats())) {
            throw new RuntimeException("Not enough seats available");
        }

        if (bookingDTO.getSeatNumbers().size() != bookingDTO.getNumberOfSeats()) {
            throw new RuntimeException("Seat count mismatch");
        }

        validateDuplicateSeats(show.getId(), bookingDTO.getSeatNumbers());

        User user = userRepository.findById(bookingDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setSeatNumbers(bookingDTO.getSeatNumbers());
        booking.setNumberOfSeats(bookingDTO.getNumberOfSeats());
        booking.setBookingTime(LocalDateTime.now());
        booking.setBookingStatus(BookingStatus.PENDING);

        Double totalAmount = calculateTotalAmount(show.getPrice(), bookingDTO.getNumberOfSeats());
        booking.setPrice(totalAmount);

        return bookingRepository.save(booking);
    }


    private Double calculateTotalAmount(Double price, Integer seats) {
        return price * seats;
    }

    private void validateDuplicateSeats(Long showId, List<String> seatNumbers) {

        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        Set<String> occupiedSeats = show.getBookings().stream()
                .filter(b -> b.getBookingStatus() != BookingStatus.CANCELLED)
                .flatMap(b -> b.getSeatNumbers().stream())
                .collect(Collectors.toSet());

        List<String> duplicates = seatNumbers.stream()
                .filter(occupiedSeats::contains)
                .collect(Collectors.toList());

        if (!duplicates.isEmpty()) {
            throw new RuntimeException("Seats already booked: " + duplicates);
        }
    }

    public boolean isSeatsAvailable(Long showId, Integer numberOfSeats) {

        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        int bookedSeats = show.getBookings().stream()
                .filter(b -> b.getBookingStatus() != BookingStatus.CANCELLED)
                .mapToInt(Booking::getNumberOfSeats)
                .sum();

        return (show.getTheater().getTheaterCapacity() - bookedSeats) >= numberOfSeats;
    }

    public List<BookingResponseDTO> getUserBookings(Long userId) {

        List<Booking> bookings = bookingRepository.findByUser_Id(userId);

        return bookings.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public List<BookingResponseDTO> getShowBookings(Long showId) {

        List<Booking> bookings = bookingRepository.findByShow_Id(showId);

        return bookings.stream()
                .map(this::convertToDTO)
                .toList();
    }
    public Booking confirmBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(()-> new RuntimeException("Booking not found"));

        if(booking.getBookingStatus()!= BookingStatus.PENDING)
        {
            throw new RuntimeException("Booking is not in pending state");
        }
        //ASK PAYMENT TO THE USER
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        return bookingRepository.save(booking);
    }
    public Booking cancelBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        validateCancellation(booking);

        booking.setBookingStatus(BookingStatus.CANCELLED);

        return bookingRepository.save(booking);
    }

    private void validateCancellation(Booking booking) {

        LocalDateTime deadline = booking.getShow().getShowTime().minusHours(2);

        if (LocalDateTime.now().isAfter(deadline)) {
            throw new RuntimeException("Cancellation allowed only up to 2 hours before showtime");
        }

        if (booking.getBookingStatus() == BookingStatus.CANCELLED) {
            throw new RuntimeException("Booking already cancelled");
        }
    }
    private BookingResponseDTO convertToDTO(Booking booking) {

        BookingResponseDTO dto = new BookingResponseDTO();

        dto.setBookingId(booking.getId());
        dto.setNumberOfSeats(booking.getNumberOfSeats());
        dto.setBookingTime(booking.getBookingTime());
        dto.setPrice(booking.getPrice());
        dto.setBookingStatus(booking.getBookingStatus());
        dto.setSeatNumbers(booking.getSeatNumbers());

        dto.setUserId(booking.getUser().getId());

        if (booking.getShow() != null) {
            dto.setShowId(booking.getShow().getId());
        }

        return dto;
    }
    public List<BookingResponseDTO>
    getAllBookings() {

        return bookingRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
}