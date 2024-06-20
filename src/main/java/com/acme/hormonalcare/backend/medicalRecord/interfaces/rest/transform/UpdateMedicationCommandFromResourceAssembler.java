package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicationCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateMedicationResource;

public class UpdateMedicationCommandFromResourceAssembler {
    public static UpdateMedicationCommand toCommandFromResource(Long id, UpdateMedicationResource resource) {
        return new UpdateMedicationCommand(
                id,
                resource.medicalRecordId(),
                resource.prescriptionId(),
                resource.medicationTypeId(),
                resource.name(),
                resource.amount(),
                resource.unitQ(),
                resource.value(),
                resource.unit(),
                resource.timesPerDay(),
                resource.timePeriod()
        );
    }
}

