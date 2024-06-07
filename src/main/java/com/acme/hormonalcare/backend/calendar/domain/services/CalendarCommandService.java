package com.acme.hormonalcare.backend.calendar.domain.services;

import com.acme.hormonalcare.backend.calendar.domain.model.aggregates.Calendar;
import com.acme.hormonalcare.backend.calendar.domain.model.commands.CreateCalendarCommand;
import com.acme.hormonalcare.backend.calendar.domain.model.commands.UpdateCalendarCommand;

import java.util.Optional;

public interface CalendarCommandService {
    Optional<Calendar> handle(CreateCalendarCommand command);
    Optional<Calendar> handle(UpdateCalendarCommand command);
}