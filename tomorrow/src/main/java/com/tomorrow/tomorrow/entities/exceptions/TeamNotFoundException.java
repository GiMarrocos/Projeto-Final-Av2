package com.tomorrow.tomorrow.entities.exceptions;

public class TeamNotFoundException extends RuntimeException{

    public TeamNotFoundException(String error_message){
		
        super(error_message);
    }
}
