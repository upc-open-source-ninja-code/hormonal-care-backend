package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePrescriptionCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdatePrescriptionResource;

public class UpdatePrescriptionCommandFromResourceAssembler {
    public static UpdatePrescriptionCommand toCommandFromResource(Long id, UpdatePrescriptionResource resource) {
        return new UpdatePrescriptionCommand(
                id,
                resource.doctorId(),
                resource.patientId(),
                resource.prescriptionDate(),
                resource.notes()
        );
    }
}