package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record CreateDoctorResource(
        String professionalIdentificationNumber,
        String subSpecialty,
        String certification,
        String appointmentFee,
        String subscriptionId,
        Long profileId
) {
}
