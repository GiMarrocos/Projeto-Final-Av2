package com.tomorrow.tomorrow.entities.exceptions;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(String error_message){
        super(error_message);
    }
}
