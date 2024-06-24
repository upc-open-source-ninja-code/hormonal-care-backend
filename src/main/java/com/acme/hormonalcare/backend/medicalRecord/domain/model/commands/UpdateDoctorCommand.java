package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record UpdateDoctorCommand(
        Long id,
        Long appointmentFee,
        Long subscriptionId)
{
}
