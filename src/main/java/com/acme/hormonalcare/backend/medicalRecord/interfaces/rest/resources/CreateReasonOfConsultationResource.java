package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record CreateReasonOfConsultationResource(
        String description,
        String symptoms
) { }
