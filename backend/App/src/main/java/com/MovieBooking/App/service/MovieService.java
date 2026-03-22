package com.MovieBooking.App.service;

import com.MovieBooking.App.DTO.MovieDTO;
import com.MovieBooking.App.Repository.MovieRepository;
import com.MovieBooking.App.entity.Movie;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
     @Autowired
    private MovieRepository movieRepository;
    public Movie addMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setName(movieDTO.getName());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setDuration(movieDTO.getDuration());
        movie.setLanguage(movieDTO.getLanguage());
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByGenre(String genre) {
        Optional<List<Movie>> listOfMovieBox =   movieRepository.findByGenre(genre); //It contains movies list

        if(listOfMovieBox.isPresent()){
            return listOfMovieBox.get();
        }
        else throw new RuntimeException("no movies found for this genre"+genre);
    }

    public List<Movie> getMoviesByLanguage(String language) {
        Optional<List<Movie>> listOfMovieBox =   movieRepository.findByLanguage(language); //It contains movies list

        if(listOfMovieBox.isPresent()){
            return listOfMovieBox.get();
        }
        else throw new RuntimeException("no movies found for this language"+language);
    }

    public Movie getMovieByTitle(String title) {
        Optional<List<Movie>> movieBox =   movieRepository.findByName(title); //It contains movies list

        if(movieBox.isPresent()){
            return (Movie) movieBox.get();
        }
        else throw new RuntimeException("no movies found for this title"+title);
    }

    public Movie updateMovie(Long id, MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(id).orElseThrow(()-> new RuntimeException("No Movie Found for the id"+id));
        movie.setName(movieDTO.getName());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setDuration(movieDTO.getDuration());
        movie.setLanguage(movieDTO.getLanguage());
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}

