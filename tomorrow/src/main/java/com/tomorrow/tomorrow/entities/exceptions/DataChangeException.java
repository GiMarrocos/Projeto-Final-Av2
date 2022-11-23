package com.tomorrow.tomorrow.entities.exceptions;

public class DataChangeException extends RuntimeException{

    public DataChangeException(String error_message){
        super(error_message);
    }
}
