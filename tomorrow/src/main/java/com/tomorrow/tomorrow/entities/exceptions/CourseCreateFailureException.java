package com.tomorrow.tomorrow.entities.exceptions;

public class CourseCreateFailureException extends RuntimeException{
	
	public CourseCreateFailureException(String error_message){
		
        super(error_message);
    }
}
