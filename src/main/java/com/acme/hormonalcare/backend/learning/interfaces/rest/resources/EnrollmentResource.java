package com.acme.hormonalcare.backend.learning.interfaces.rest.resources;

public record EnrollmentResource(Long enrollmentId, String studentRecordId, Long courseId, String status) {
}