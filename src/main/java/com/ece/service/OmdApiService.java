package com.ece.service;

import com.ece.model.dto.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OmdApiService {

    @Autowired
    RestTemplate restTemplate;

    static List<Movies> movies = Arrays.asList(
            new Movies("movOne", "nameOne", "5"),
            new Movies("movTwo", "nameTwo", "7"),
            new Movies("movThr", "nameThr", "2")
        );


    public List<Movies> getAllMovies(){
        return movies;
    }

    public String search(String search){
        String url= "https://www.omdbapi.com/?apikey=3ffeafaa&s="+ search;
        ResponseEntity<String> reponse= restTemplate.getForEntity(url,String.class);
        return reponse.getBody();
    }
}
