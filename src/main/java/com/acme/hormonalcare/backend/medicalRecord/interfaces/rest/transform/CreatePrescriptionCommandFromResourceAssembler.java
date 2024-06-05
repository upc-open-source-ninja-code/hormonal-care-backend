package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePrescriptionCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreatePrescriptionResource;

public class CreatePrescriptionCommandFromResourceAssembler {
    public static CreatePrescriptionCommand toCommandFromResource(CreatePrescriptionResource resource) {
        return new CreatePrescriptionCommand(
                resource.DoctorId(),
                resource.PatientId(),
                resource.prescriptionDate(),
                resource.notes()
        );
    }
}