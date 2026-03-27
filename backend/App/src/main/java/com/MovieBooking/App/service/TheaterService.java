package com.MovieBooking.App.service;

import com.MovieBooking.App.DTO.TheaterDTO;
import com.MovieBooking.App.Repository.TheaterRepository;
import com.MovieBooking.App.entity.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    public Theater addTheater(TheaterDTO theaterDTO) {
        Theater theater = new Theater();
        theater.setTheaterName(theaterDTO.getTheaterName());
        theater.setTheaterLocation(theaterDTO.getTheaterLocation());
        theater.setTheaterCapacity(theater.getTheaterCapacity());
        theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());

        return theaterRepository.save(theater);
    }

    public List<Theater> getTheaterByLocation(String location) {
        Optional<List<Theater>> listOfTheaterBox = theaterRepository.findByLocation(location);
        if(listOfTheaterBox.isPresent()){
            return listOfTheaterBox.get();
        }
        else throw new RuntimeException("No theater found for location entered: "+location);
    }

    public Theater updateTheater(Long id, TheaterDTO theaterDTO) {
        Theater theater = theaterRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No theater found for id:"+id));
        theater.setTheaterName(theaterDTO.getTheaterName());
        theater.setTheaterLocation(theaterDTO.getTheaterLocation());
        theater.setTheaterCapacity(theater.getTheaterCapacity());
        theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());

        return theaterRepository.save(theater);
    }

    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
