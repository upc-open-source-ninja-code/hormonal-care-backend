package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalAppointment;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.MedicalAppointmentResource;

public class MedicalAppointmentResourceFromEntityAssembler {
    public static MedicalAppointmentResource toResourceFromEntity(MedicalAppointment entity) {
        return new MedicalAppointmentResource
                (
                entity.getEventDate().date(),
                entity.getStartTime().toString(),
                entity.getEndTime().toString(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getDoctorEmail().email(),
                entity.getPatientEmail().email()
        );
    }
}
