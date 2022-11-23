package com.tomorrow.tomorrow.entities.exceptions;

public class EntityObjectNotFoundException extends RuntimeException{

    public EntityObjectNotFoundException(String error_message){
        super(error_message);
    }
}
