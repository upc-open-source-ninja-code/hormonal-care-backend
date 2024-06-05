package com.acme.hormonalcare.backend.calendar.application.internal.commandservices;

import com.acme.hormonalcare.backend.calendar.domain.model.aggregates.Calendar;
import com.acme.hormonalcare.backend.calendar.domain.model.commands.CreateCalendarCommand;
import com.acme.hormonalcare.backend.calendar.domain.model.commands.UpdateCalendarCommand;
import com.acme.hormonalcare.backend.calendar.domain.model.valueobjects.EventDate;
import com.acme.hormonalcare.backend.calendar.domain.model.valueobjects.StartTime;
import com.acme.hormonalcare.backend.calendar.domain.services.CalendarCommandService;
import com.acme.hormonalcare.backend.calendar.infrastructure.persistence.jpa.repositories.CalendarRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalendarCommandServiceImpl implements CalendarCommandService {

    private final CalendarRepository calendarRepository;

    public CalendarCommandServiceImpl(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Override
    public Optional<Calendar> handle(CreateCalendarCommand command) {
        var calendar = new Calendar(command);
        calendarRepository.save(calendar);
        return Optional.of(calendar);
    }

    @Override
    public Optional<Calendar> handle(UpdateCalendarCommand command) {
        var id = command.id();
        if (!calendarRepository.existsById(id)) {
            throw new IllegalArgumentException("Calendar with id "+ command.id() +" does not exists");
        }
        var result = calendarRepository.findById(id);
        var calendarToUpdate = result.get();
        try {
            var updatedCalendar = calendarRepository.save(calendarToUpdate.updateInformation(command.eventDate(),command.startTime(),command.endTime(), command.title(),command.patientEmail()));
            return Optional.of(updatedCalendar);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating calendar: " + e.getMessage());
        }
    }
}