package com.tomorrow.tomorrow.entities.exceptions;

public class HolidayCreateFailureException extends RuntimeException {
	
	public HolidayCreateFailureException(String error_message) {

		super(error_message);

	}
}
