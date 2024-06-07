package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record UpdateDoctorSubscriptionCommand(
        Long id,
        String subscriptionId
) {
}
