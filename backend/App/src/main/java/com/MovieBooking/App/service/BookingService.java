package com.MovieBooking.App.service;

import com.MovieBooking.App.DTO.BookingDTO;
import com.MovieBooking.App.Repository.BookingRepository;
import com.MovieBooking.App.Repository.ShowRepository;
import com.MovieBooking.App.Repository.UserRepository;
import com.MovieBooking.App.entity.Booking;
import com.MovieBooking.App.entity.BookingStatus;
import com.MovieBooking.App.entity.Show;
import com.MovieBooking.App.entity.User;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
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
                .orElseThrow(()->new RuntimeException("Show nor found"));
        if(!isSeatsAvailable(show.getId(),bookingDTO.getNumberOfSeats()))
        {
            throw new RuntimeException("Not enough seats are available");
        }
        if(bookingDTO.getSeatNumbers().size()!=bookingDTO.getNumberOfSeats())
        {
            throw  new RuntimeException("Seat Number and Number of seats must be equal");
        }
        validateDuplicateSeats(show.getId(), bookingDTO.getSeatNumbers()); //When Seats are not duplicate
        User user = userRepository.findById(bookingDTO.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setSeatNumbers(bookingDTO.getSeatNumbers());
        booking.setBookingTime(LocalDateTime.now());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShow(show);
        booking.setPrice(calculateTotalAmount(show.getPrice(),bookingDTO.getNumberOfSeats()));
        booking.setNumberOfSeats(bookingDTO.getNumberOfSeats());

        return bookingRepository.save(booking);
    }

    private Double calculateTotalAmount(Double price, Integer numberOfSeats) {
        return price*numberOfSeats;
    }

    private void validateDuplicateSeats(Long showId, List<String> seatNumbers) { // If occupied seat contains required
        Show show = showRepository.findById(showId)
                .orElseThrow(()->new RuntimeException("Show nor found"));

        Set<String> occupiedSeats = show.getBookings().stream().filter(b->b.getBookingStatus()!= BookingStatus.CANCELLED)
                .flatMap(b->b.getSeatNumbers().stream())
                .collect(Collectors.toSet());

        List<String> duplicateSeats = seatNumbers.stream()
                .filter(occupiedSeats::contains)
                .collect(Collectors.toList());

        if(!duplicateSeats.isEmpty()) {
            throw  new RuntimeException("Seats are already booked");
        }
    }

    public boolean isSeatsAvailable(Long showid, Integer numberOfSeats)
    {
        Show show = showRepository.findById(showid)
                .orElseThrow(()->new RuntimeException("Show nor found"));
        int bookedSeats  = show.getBookings().stream()
                .filter(booking -> booking.getBookingStatus() != BookingStatus.CANCELLED)
                .mapToInt(Booking::getNumberOfSeats)
                .sum();
        return (show.getTheater().getTheaterCapacity() - bookedSeats) >= numberOfSeats;
    }

    public List<Booking> getUserBookings(Long userid) {
        return bookingRepository.findByUserId(userid);
    }

    public List<Booking> getShowBookings(Long showid) {
        return bookingRepository.findByShowId(showid);
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
                .orElseThrow(()-> new RuntimeException("Booking not found"));
        validateCancellation(booking);
        booking.setBookingStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

    private void validateCancellation(Booking booking) {
        LocalDateTime showTime = booking.getShow().getShowTime();
        LocalDateTime deadLineTime = showTime.minusHours(2); // You cannot cancel show within 2 hours before show start time
        if(LocalDateTime.now().isAfter(deadLineTime))
        {
            throw new RuntimeException("Cannot cancel the booking");
        }
        if(booking.getBookingStatus()==BookingStatus.CANCELLED)
        {
            throw new RuntimeException("Booking already been cancelled");
        }
    }

//    public List<Booking> getBookingsByStatus(BookingStatus bookingStatus) {
//    }
}
