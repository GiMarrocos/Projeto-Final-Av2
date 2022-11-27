package com.tomorrow.tomorrow.services.exceptions;

public class TeacherCreateFailureException extends RuntimeException{
    public TeacherCreateFailureException(String teacher_registration_failure) {
        super(teacher_registration_failure);
    }
}
