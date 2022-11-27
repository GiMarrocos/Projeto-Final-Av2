package com.tomorrow.tomorrow.entities.exceptions;

public class StudentCreateFailureException extends RuntimeException{

    public StudentCreateFailureException(String student_registration_failure) {
        super(student_registration_failure);
    }
}
