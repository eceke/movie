package com.ece.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @GetMapping("/search")
    public ResponseEntity search(){
        return ResponseEntity.ok("search");
    }
}
