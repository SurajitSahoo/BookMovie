package com.MovieBooking.App.Repository;

import com.MovieBooking.App.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByUserId(Long userid);
    List<Booking> findByShowId(Long showid);
}
