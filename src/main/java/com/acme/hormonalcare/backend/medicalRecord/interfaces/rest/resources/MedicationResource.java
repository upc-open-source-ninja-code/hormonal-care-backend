package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record MedicationResource(
        //Long medicalRecord,
        //Long prescriptionId,
        //Long medicationTypeId,
        Long id,
        String drugName,
        String quantity,
        String concentration,
        String frequency,
        String duration) {
}