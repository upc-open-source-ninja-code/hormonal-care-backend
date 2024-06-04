package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Prescription;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.PrescriptionResource;

public class PrescriptionResourceFromEntityAssembler {
    public static PrescriptionResource toResourceFromEntity(Prescription entity) {
        return new PrescriptionResource(
                entity.getId(),
                entity.getMedicalRecord(),
                entity.getPrescriptionDate(),
                entity.getDoctorId(),
                entity.getPatientId(),
                entity.getNotes()
        );
    }
}