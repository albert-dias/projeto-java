package com.yazon.api.controller;

import com.yazon.api.entity.ClientEntity;
import com.yazon.api.entity.CollectEntity;
import com.yazon.api.entity.RestApiResponse;
import com.yazon.api.repository.CollectRepository;
import com.yazon.api.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/collects")
public class CollectController {

    @Autowired
    private CollectService collectService;
    public CollectController(CollectService collectService) {
        this.collectService = collectService;
    }

    @GetMapping("/")
    public ResponseEntity<RestApiResponse<List<CollectEntity>>> findAll(){

        List<CollectEntity> data = this.collectService.findAll();
        RestApiResponse<List<CollectEntity>> result = new RestApiResponse<>(HttpStatus.OK, "OK!", data);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestApiResponse<CollectEntity>> findOne(@RequestParam String id){
        RestApiResponse<CollectEntity> result = new RestApiResponse<>(HttpStatus.OK);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/")
    public ResponseEntity<RestApiResponse<CollectEntity>> create (@RequestBody CollectEntity client){
        RestApiResponse<CollectEntity> result = new RestApiResponse<>(HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/confirm/{id}")
    public ResponseEntity<RestApiResponse<Optional<CollectEntity>>> isConfirm(@RequestParam String id) throws Exception {
        var aux = this.collectService.isConfirm((long) Integer.parseInt(id));
        RestApiResponse<Optional<CollectEntity>> result = new RestApiResponse<>(HttpStatus.OK, "OK!", aux);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/cancel/{id}")
    public ResponseEntity<RestApiResponse<Optional<CollectEntity>>> isCancel(@RequestParam String id) throws Exception {
        var aux = this.collectService.isCancel((long) Integer.parseInt(id));
        RestApiResponse<Optional<CollectEntity>> result = new RestApiResponse<>(HttpStatus.OK, "OK!", aux);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/complete/{id}")
    public ResponseEntity<RestApiResponse<Optional<CollectEntity>>> isComplete(@RequestParam String id) throws Exception {
        var aux = this.collectService.isComplete((long) Integer.parseInt(id));
        RestApiResponse<Optional<CollectEntity>> result = new RestApiResponse<>(HttpStatus.OK, "OK!", aux);
        return ResponseEntity.ok(result);
    }

}
