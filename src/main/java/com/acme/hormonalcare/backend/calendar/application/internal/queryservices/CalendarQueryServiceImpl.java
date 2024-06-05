package com.acme.hormonalcare.backend.calendar.application.internal.queryservices;

import com.acme.hormonalcare.backend.calendar.domain.model.aggregates.Calendar;
import com.acme.hormonalcare.backend.calendar.domain.model.queries.GetAllCalendarsQuery;
import com.acme.hormonalcare.backend.calendar.domain.model.queries.GetCalendarByIdQuery;
import com.acme.hormonalcare.backend.calendar.domain.services.CalendarQueryService;
import com.acme.hormonalcare.backend.calendar.infrastructure.persistence.jpa.repositories.CalendarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarQueryServiceImpl implements CalendarQueryService {
    private final CalendarRepository calendarRepository;

    public CalendarQueryServiceImpl(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Override
    public List<Calendar> handle(GetAllCalendarsQuery query) {
        return List.of();
    }

    @Override
    public Optional<Calendar> handle(GetCalendarByIdQuery query) {
        return calendarRepository.findById(query.id());
    }
}