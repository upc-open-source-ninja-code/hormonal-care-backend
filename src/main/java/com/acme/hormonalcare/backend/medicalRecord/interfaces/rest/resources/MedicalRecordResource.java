package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record MedicalRecordResource(
        Long id,
        Long reason_of_consultation_id
) {
}
