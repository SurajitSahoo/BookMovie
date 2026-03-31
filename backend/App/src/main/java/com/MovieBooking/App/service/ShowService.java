package com.MovieBooking.App.service;

import com.MovieBooking.App.DTO.ShowDTO;
import com.MovieBooking.App.Repository.MovieRepository;
import com.MovieBooking.App.Repository.ShowRepository;
import com.MovieBooking.App.Repository.TheaterRepository;
import com.MovieBooking.App.entity.Booking;
import com.MovieBooking.App.entity.Movie;
import com.MovieBooking.App.entity.Show;
import com.MovieBooking.App.entity.Theater;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public Show createShow(ShowDTO showDTO) {
        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(()->new RuntimeException("No movie found"+showDTO.getMovieId()));
        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(()->new RuntimeException("No movie found"+showDTO.getTheaterId()));
        Show show = new Show();
        show.setShowTime(showDTO.getShowTime());
        show.setPrice(show.getPrice());
        show.setMovie(movie);
        show.setTheater(theater);

        return showRepository.save(show);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public List<Show> getShowsByMovie(Long movieid) {
        Optional<List<Show>> showListBox=showRepository.findByMovieId(movieid);
        if(showListBox.isPresent())
        {
            return showListBox.get();
        }
        else throw new RuntimeException("No shows available for the movie");
    }

    public List<Show> getShowsByTheater(Long theaterid) {
        Optional<List<Show>> showListBox=showRepository.findByTheaterId(theaterid);
        if(showListBox.isPresent())
        {
            return showListBox.get();
        }
        else throw new RuntimeException("No shows available for the theater");
    }

    public Show updateShow(Long id, ShowDTO showDTO) {
        Show show = showRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No shows available for this id"+id));
        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(()->new RuntimeException("No movie found"+showDTO.getMovieId()));
        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(()->new RuntimeException("No movie found"+showDTO.getTheaterId()));

        show.setShowTime(showDTO.getShowTime());
        show.setPrice(show.getPrice());
        show.setMovie(movie);
        show.setTheater(theater);

        return showRepository.save(show);
    }

    public void deleteShow(Long id) {
        if(!showRepository.existsById(id)) //check if show is available on this id
        {
            throw new RuntimeException("No show available for the id"+id);
        }
        //If there are bookings present then  we cannot delete
        //check it
        List<Booking> bookings = showRepository.findById(id).get().getBookings();
        if(!bookings.isEmpty()) //Means there are bookings (! isEmpty())
        {
            throw new RuntimeException("Can't delete show with existing bookings");
        }
        showRepository.deleteById(id); //else delete it
    }
}
