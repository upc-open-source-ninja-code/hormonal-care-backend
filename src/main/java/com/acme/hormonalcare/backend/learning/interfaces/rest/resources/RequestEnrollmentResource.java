package com.acme.hormonalcare.backend.learning.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record RequestEnrollmentResource(
        @NotNull
        String studentRecordId,
        @NotNull
        Long courseId
) {
}