package com.ece.controller;

import com.ece.model.dto.Movies;
import com.ece.service.OmdApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private OmdApiService omdApiService;

    @GetMapping("/")
    public List<Movies> getAllMovies(){
        return omdApiService.getAllMovies();
    }

    @GetMapping ("/search")
    public ResponseEntity search(@RequestParam("search") String search) {
        return ResponseEntity.ok(omdApiService.search(search));
    }
}
