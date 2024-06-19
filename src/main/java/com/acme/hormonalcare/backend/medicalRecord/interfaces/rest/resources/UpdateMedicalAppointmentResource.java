package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

import java.time.LocalDate;

public record UpdateMedicalAppointmentResource(
        Long id,
        LocalDate eventDate,
        String startTime,
        String endTime,
        String title,
        String description,
        String doctorEmail,
        String patientEmail
) {
}
