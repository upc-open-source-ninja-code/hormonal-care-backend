package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record ReasonOfConsultationResource(
        String description,
        String symptoms,
        Long medicalRecordId
) {
}
