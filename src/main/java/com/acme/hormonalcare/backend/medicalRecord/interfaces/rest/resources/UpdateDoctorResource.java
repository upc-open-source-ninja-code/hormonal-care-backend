package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record UpdateDoctorResource(
        Long id,
        Long appointmentFee,
        Long subscriptionId
) {
}
