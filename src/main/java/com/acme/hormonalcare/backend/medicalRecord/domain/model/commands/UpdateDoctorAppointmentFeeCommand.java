package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record UpdateDoctorAppointmentFeeCommand(
        Long id,
        String appointmentFee
) {

}
