package com.ece.controller;


import com.ece.model.dto.Movie;
import com.ece.repository.MovieRepository;
import com.ece.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;

    @GetMapping ("/search")
    public ResponseEntity search(@RequestParam("term") String term) {
        return ResponseEntity.ok(movieService.search(term));
    }

    @GetMapping ("/all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(movieRepository.findAll());
    }

    @PostMapping("/movie")
    public ResponseEntity<List<Movie>> save(@RequestBody Movie movie) {
        try {
            movieRepository.save(movie);
            return new ResponseEntity(movie, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<List<Movie>> getById(@PathVariable("id") Long id ) {
        try {
            Optional<Movie> movies = movieRepository.findById(id);
            return new ResponseEntity(movies.get(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
