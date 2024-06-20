package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicationTypeCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateMedicationTypeResource;

public class UpdateMedicationTypeCommandFromResourceAssembler {
    public static UpdateMedicationTypeCommand toCommandFromResource(Long id, UpdateMedicationTypeResource resource) {
        return new UpdateMedicationTypeCommand(
                id,
                resource.typeName()
        );
    }
}