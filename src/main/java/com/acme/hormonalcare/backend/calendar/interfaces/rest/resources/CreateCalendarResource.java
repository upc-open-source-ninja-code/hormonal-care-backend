package com.acme.hormonalcare.backend.calendar.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateCalendarResource(
        LocalDate eventDate,
        String startTime,
        String endTime,
        String title,
        String patientEmail
) {
}
