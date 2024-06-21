package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalAppointment;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.MedicalAppointmentResource;

public class MedicalAppointmentResourceFromEntityAssembler {
    public static MedicalAppointmentResource toResourceFromEntity(MedicalAppointment entity) {
        return new MedicalAppointmentResource(
                entity.getEventDate(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getDoctor().getId(),
                entity.getPatient().getId()
        );
    }
}
