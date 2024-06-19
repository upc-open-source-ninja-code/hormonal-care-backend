package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

import java.util.Date;

public record CreateDoctorCommand(
        String professionalIdentificationNumber,
        String subSpecialty,
        String certification,
        String appointmentFee,
        String subscriptionId,
        Long profileId
) {
}

