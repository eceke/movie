package com.ece.service;

import com.ece.model.dto.Movie;
import com.ece.model.dto.SearchResponse;
import com.ece.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    OmdApiService omdApiService;

    public List<Movie> search(String term) {
        List<Movie> movies = movieRepository.searchTitle(term.toUpperCase());
        if (movies.isEmpty()) {
            SearchResponse searchResponse = omdApiService.search(term);
            if (searchResponse.isResponse()) {
                searchResponse.getSearch().forEach(movieResponse -> {
                    Movie movie = new Movie(null, movieResponse.getTitle(), movieResponse.getYear(), movieResponse.getImdbId(), movieResponse.getType(), movieResponse.getPoster());
                    save(movie);
                    movies.add(movie);
                });
            }
        }
        return movies;
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }


}
