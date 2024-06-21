package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicalAppointmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateMedicalAppointmentResource;

public class UpdateMedicalAppointmentCommandFromResourceAssembler {
    public static UpdateMedicalAppointmentCommand toCommandFromResource(Long id, UpdateMedicalAppointmentResource resource) {
        return new UpdateMedicalAppointmentCommand(
                id,
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

