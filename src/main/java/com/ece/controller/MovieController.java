package com.ece.controller;

import com.ece.model.dto.Movies;
import com.ece.service.OmdApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private OmdApiService omdApiService;

    @GetMapping("/")
    public List<Movies> getAllMovies(){
        return omdApiService.getAllMovies();
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search) {
        return omdApiService.search(search);
    }
}
