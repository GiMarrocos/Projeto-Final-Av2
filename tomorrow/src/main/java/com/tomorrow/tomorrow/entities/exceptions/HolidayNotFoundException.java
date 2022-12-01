package com.tomorrow.tomorrow.entities.exceptions;

public class HolidayNotFoundException extends RuntimeException {

	public HolidayNotFoundException(String error_message){
		
        super(error_message);
		
    }
	
}
