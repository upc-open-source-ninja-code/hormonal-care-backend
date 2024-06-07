package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record UpdateDoctorAppointmentFeeResource(
        Long id,
        String appointmentFee
) {
}
