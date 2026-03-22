package com.MovieBooking.App.Repository;

import com.MovieBooking.App.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {
   public Optional <List<Movie>> findByGenre(String genre);

    public Optional<List<Movie>> findByLanguage(String language);

   public Optional<List<Movie>> findByName(String title);
}
