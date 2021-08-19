package com.ece.controller;


import com.ece.model.dto.Movie;
import com.ece.repository.MovieRepository;
import com.ece.service.OmdApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private OmdApiService omdApiService;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping ("/search")
    public ResponseEntity search(@RequestParam("search") String search) {
        return ResponseEntity.ok(omdApiService.search(search));
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
}