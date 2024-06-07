package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

import java.time.LocalDate;

public record UpdateMedicalAppointmentCommand(
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