package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record UpdateDoctorSubscriptionResource(
        Long id,
        String subscriptionId
) {
}
