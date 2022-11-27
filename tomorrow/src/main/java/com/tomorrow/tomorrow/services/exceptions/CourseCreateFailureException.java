package com.tomorrow.tomorrow.services.exceptions;

public class CourseCreateFailureException extends RuntimeException{

    public CourseCreateFailureException(String error_message){
        super(error_message);
    }
}
