package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record DoctorResource(
        String professionalIdentificationNumber,
        String subSpecialty,
        String certification,
        Long appointmentFee,
        Long subscriptionId,
        Long profileId,
        String doctorRecordId
) {
}
