package com.tomorrow.tomorrow.services.exceptions;

public class TeamCreateFailureException extends RuntimeException{

    public TeamCreateFailureException(String error_message){

        super(error_message);
		
    }
}
