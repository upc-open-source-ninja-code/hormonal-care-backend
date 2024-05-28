package com.acme.hormonalcare.backend.learning.interfaces.rest.resources;

public record StudentResource(String acmeStudentRecordId, Long profileId, Integer totalCompletedCourses, Integer totalTutorials) {
}