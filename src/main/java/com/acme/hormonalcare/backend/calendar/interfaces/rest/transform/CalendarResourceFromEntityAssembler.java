package com.acme.hormonalcare.backend.calendar.interfaces.rest.transform;

import com.acme.hormonalcare.backend.calendar.domain.model.aggregates.Calendar;
import com.acme.hormonalcare.backend.calendar.interfaces.rest.resources.CalendarResource;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Medication;

public class CalendarResourceFromEntityAssembler {
    public static CalendarResource toResourceFromEntity(Calendar entity) {
        return new CalendarResource(
            entity.getId(),
            entity.getEventDate().date(),
            entity.getStartTime().time(),
            entity.getEndTime().time(),
            entity.getTitle(),
            entity.getPatientEmail().email()
        );
    }
}
