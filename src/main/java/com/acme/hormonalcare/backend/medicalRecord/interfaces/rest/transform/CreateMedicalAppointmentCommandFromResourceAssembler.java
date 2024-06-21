package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalAppointmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateMedicalAppointmentResource;

public class CreateMedicalAppointmentCommandFromResourceAssembler {
    public static CreateMedicalAppointmentCommand toCommandFromResource(CreateMedicalAppointmentResource resource) {
        return new CreateMedicalAppointmentCommand(
                resource.eventDate(),
                resource.startTime(),
                resource.endTime(),
                resource.title(),
                resource.description(),
                resource.doctorId(),
                resource.patientId()
        );
    }
}


