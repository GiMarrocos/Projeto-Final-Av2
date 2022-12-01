package com.tomorrow.tomorrow.entities.exceptions;

public class TeacherNotFoundException extends RuntimeException{

    public TeacherNotFoundException(String error_message){
        super(error_message);
    }
}
