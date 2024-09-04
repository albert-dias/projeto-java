package com.yazon.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @GetMapping("/")
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(new String("findAll"));
    }

}
