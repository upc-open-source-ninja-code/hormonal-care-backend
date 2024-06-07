package com.acme.hormonalcare.backend.medicalRecord.domain.model.queries;

import java.time.LocalDate;

public record GetMedicalAppointmentByEventDate(LocalDate date) {
}
