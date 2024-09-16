package com.yazon.api.controller;

import com.yazon.api.entity.ClientEntity;
import com.yazon.api.entity.RestApiResponse;
import com.yazon.api.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    @GetMapping("/")
    public ResponseEntity<RestApiResponse<List<ClientEntity>>> findAll(){

        List<ClientEntity> data = this.clientService.findAll();
        RestApiResponse<List<ClientEntity>> result = new RestApiResponse<>(HttpStatus.OK, "OK!", data);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestApiResponse<ClientEntity>> findOne(@RequestParam String id){
        RestApiResponse<ClientEntity> result = new RestApiResponse<>(HttpStatus.OK);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/")
    public ResponseEntity<RestApiResponse<ClientEntity>> create (@RequestBody ClientEntity client){
        RestApiResponse<ClientEntity> result = new RestApiResponse<>(HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
