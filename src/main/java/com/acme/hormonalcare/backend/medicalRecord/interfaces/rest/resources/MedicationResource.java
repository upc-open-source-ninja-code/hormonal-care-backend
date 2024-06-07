package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record MedicationResource(
        Long id,
        Long prescriptionId,
        Long medicationTypeId,
        String drugName,
        String quantity,
        String concentration,
        String frequency,
        String duration) {
}