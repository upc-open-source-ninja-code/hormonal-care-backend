package com.acme.hormonalcare.backend.calendar.interfaces.rest.transform;

import com.acme.hormonalcare.backend.calendar.domain.model.commands.UpdateCalendarCommand;

import com.acme.hormonalcare.backend.calendar.interfaces.rest.resources.UpdateCalendarResource;

public class UpdateCalendarCommandFromResourceAssembler {
    public static UpdateCalendarCommand toCommandFromResource(Long id, UpdateCalendarResource resource) {
        return new UpdateCalendarCommand(
                id,
                resource.eventDate(),
                resource.startTime(),
                resource.endTime(),
                resource.title(),
                resource.patientEmail()
        );
    }
}