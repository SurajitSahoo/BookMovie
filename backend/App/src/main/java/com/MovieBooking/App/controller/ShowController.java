package com.MovieBooking.App.controller;

import com.MovieBooking.App.DTO.ShowDTO;
import com.MovieBooking.App.entity.Show;
import com.MovieBooking.App.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/show")
public class ShowController {
    @Autowired
    private ShowService service;

    @PostMapping("/createshow")
    public ResponseEntity<Show> createShow(@RequestBody ShowDTO showDTO)
    {
        return ResponseEntity.ok(service.createShow(showDTO));
    }

    @GetMapping("/getallshows")
    public ResponseEntity<List<Show>> getAllShows()
    {
        return ResponseEntity.ok(service.getAllShows());
    }

    @GetMapping("/getshowsbymovie/{id}")
    public ResponseEntity<List<Show>> getShowsByMovie(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getShowsByMovie(id));
    }

    @GetMapping("/getshowsbytheater/{id}")
    public ResponseEntity<List<Show>> getShowsByTheater(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getShowsByTheater(id));
    }

    @PutMapping("/updateshow/{id}")
    public ResponseEntity<Show> updateShow (@PathVariable Long id, @RequestBody ShowDTO showDTO)
    {
        return ResponseEntity.ok(service.updateShow(id,showDTO));
    }

    @DeleteMapping("/deleteshow/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id)
    {
        service.deleteShow(id);
        return ResponseEntity.ok().build();
    }
}
