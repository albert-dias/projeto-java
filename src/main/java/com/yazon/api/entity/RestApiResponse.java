package com.yazon.api.entity;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class RestApiResponse<T> {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
    private T data;

    public RestApiResponse(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.data = data;
    }

    public RestApiResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public RestApiResponse(HttpStatus status){
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
