package com.ece.service;

import com.ece.model.dto.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OmdApiService {

    @Autowired
    RestTemplate restTemplate;

    public SearchResponse search(String search){
        String url= "https://www.omdbapi.com/?apikey=3ffeafaa&s="+ search;
        ResponseEntity<SearchResponse> response= restTemplate.getForEntity(url, SearchResponse.class);
        return response.getBody();
    }
}
