package com.acme.hormonalcare.backend.learning.domain.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long aLong) {
        super("Course with id " + aLong + " not found");
    }
}