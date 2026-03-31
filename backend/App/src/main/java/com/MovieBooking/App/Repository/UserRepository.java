package com.MovieBooking.App.Repository;

import com.MovieBooking.App.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
