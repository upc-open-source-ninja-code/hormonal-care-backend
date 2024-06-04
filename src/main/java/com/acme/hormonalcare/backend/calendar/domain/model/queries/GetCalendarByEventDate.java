package com.acme.hormonalcare.backend.calendar.domain.model.queries;

import java.time.LocalDate;

public record GetCalendarByEventDate(LocalDate date) {
}
