package com.acme.hormonalcare.backend.calendar.domain.services;

import com.acme.hormonalcare.backend.calendar.domain.model.aggregates.Calendar;
import com.acme.hormonalcare.backend.calendar.domain.model.queries.GetAllCalendarsQuery;
import com.acme.hormonalcare.backend.calendar.domain.model.queries.GetCalendarByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CalendarQueryService {
    List<Calendar> handle(GetAllCalendarsQuery query);
    Optional<Calendar> handle(GetCalendarByIdQuery query);
}