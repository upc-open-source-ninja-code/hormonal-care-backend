package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

import java.time.LocalDate;

public record MedicalAppointmentResource(
        LocalDate eventDate,
        String startTime,
        String endTime,
        String title,
        String description,
        Long doctorId,
        Long patientId
) {}