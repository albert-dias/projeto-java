package com.yazon.api.exception;

public class EventFullException  extends RuntimeException{
    public EventFullException(){
        super("Error não esperado");
    }

    public EventFullException(String message){
        super(message);
    }
}
