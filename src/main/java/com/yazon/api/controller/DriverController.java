package com.yazon.api.controller;

import com.yazon.api.entity.ClientEntity;
import com.yazon.api.entity.DriverEntity;
import com.yazon.api.entity.RestApiResponse;
import com.yazon.api.repository.DriverRepository;
import com.yazon.api.service.ClientService;
import com.yazon.api.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }


    @GetMapping("/")
    public ResponseEntity<RestApiResponse<List<DriverEntity>>> findAll(){
        List<DriverEntity> data = this.driverService.findAll();
        RestApiResponse<List<DriverEntity>> result = new RestApiResponse<>(HttpStatus.OK, "OK!", data);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestApiResponse<DriverEntity>> findOne(@RequestParam String id) throws Exception {

        DriverEntity d = this.driverService.findOneById((long) Integer.parseInt(id));
        RestApiResponse<DriverEntity> result = new RestApiResponse<>(HttpStatus.OK,"OK!", d);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/")
    public ResponseEntity<RestApiResponse<DriverEntity>> create (@RequestBody DriverEntity drive){
        DriverEntity novo = this.driverService.create(drive);
        RestApiResponse<DriverEntity> result = new RestApiResponse<>(HttpStatus.CREATED, "OK!", novo);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
