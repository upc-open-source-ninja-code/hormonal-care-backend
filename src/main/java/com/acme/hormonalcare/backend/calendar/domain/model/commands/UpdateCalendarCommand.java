package com.acme.hormonalcare.backend.calendar.domain.model.commands;

import java.time.LocalDate;

public record UpdateCalendarCommand(Long id, LocalDate eventDate, String startTime, String endTime, String title, String patientEmail) {
}
