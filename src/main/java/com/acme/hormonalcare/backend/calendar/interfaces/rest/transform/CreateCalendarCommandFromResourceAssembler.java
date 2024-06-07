package com.acme.hormonalcare.backend.calendar.interfaces.rest.transform;

import com.acme.hormonalcare.backend.calendar.domain.model.commands.CreateCalendarCommand;
import com.acme.hormonalcare.backend.calendar.interfaces.rest.resources.CreateCalendarResource;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationCommand;

public class CreateCalendarCommandFromResourceAssembler {
    public static CreateCalendarCommand toCommandFromResource(CreateCalendarResource resource) {
        return new CreateCalendarCommand(
          resource.eventDate(),
                resource.startTime(),
            resource.endTime(),
            resource.title(),
            resource.patientEmail());
    }
}
