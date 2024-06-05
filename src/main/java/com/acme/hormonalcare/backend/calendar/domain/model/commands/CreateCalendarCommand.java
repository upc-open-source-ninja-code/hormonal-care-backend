package com.acme.hormonalcare.backend.calendar.domain.model.commands;

import java.time.LocalDate;

public record CreateCalendarCommand(LocalDate eventDate, String startTime, String endTime, String title, String patientEmail) {
}