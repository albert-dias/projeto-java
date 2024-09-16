package com.yazon.api.exception;

import com.yazon.api.entity.RestApiResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

public class RestExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestApiResponse> genericError(Exception exception){
        RestApiResponse threatResponse = new RestApiResponse<>(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
    @ExceptionHandler(ClassNotFoundException.class)
    private ResponseEntity<RestApiResponse> classNotFound(ClassNotFoundException exception){
        RestApiResponse threatResponse = new RestApiResponse<>(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }

    @ExceptionHandler(SQLException.class)
    private ResponseEntity<RestApiResponse> sqlErrorHandler(SQLException exception){
        RestApiResponse threatResponse = new RestApiResponse<>(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    } @ExceptionHandler(ExpiredJwtException.class)
    private ResponseEntity<RestApiResponse> expiredJwtException(SQLException exception){
        RestApiResponse threatResponse = new RestApiResponse<>(HttpStatus.FORBIDDEN, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
}
