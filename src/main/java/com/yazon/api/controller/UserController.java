package com.yazon.api.controller;

import com.yazon.api.entity.RestApiResponse;
import com.yazon.api.entity.UserEntity;
import com.yazon.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;


    @GetMapping("/")
    public ResponseEntity<RestApiResponse<List<UserEntity>>> findAll(){

        List<UserEntity>  data = this.userService.findAll();

        RestApiResponse<List<UserEntity>> result = new RestApiResponse<>(HttpStatus.OK, "OK!", data);

        return ResponseEntity.ok(result);
    }

    public ResponseEntity<RestApiResponse<UserEntity>> authenticate(@RequestBody String login, @RequestBody String password) throws Exception {

        Optional<UserEntity> user = this.userService.authenticate(login, password);

        RestApiResponse<UserEntity> result = new RestApiResponse<>(HttpStatus.OK, "OK!", user.get());

        return ResponseEntity.ok(result);
    }


}
