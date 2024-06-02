package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record UpdateReasonOfConsultationResource(
        String description,
        String symptoms
) { }
