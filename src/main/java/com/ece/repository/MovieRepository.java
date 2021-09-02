package com.ece.repository;

import com.ece.model.dto.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query(value = "SELECT movie FROM Movie movie WHERE upper(movie.title) LIKE %:term%")
    public List<Movie> searchTitle(@Param("term") String term);


}
