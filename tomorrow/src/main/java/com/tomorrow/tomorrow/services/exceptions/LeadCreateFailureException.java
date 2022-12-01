package com.tomorrow.tomorrow.services.exceptions;

public class LeadCreateFailureException extends RuntimeException{

    public LeadCreateFailureException(String error_message){
        super(error_message);
    }
}
