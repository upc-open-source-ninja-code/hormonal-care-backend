package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationTypeCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateMedicationTypeResource;

public class CreateMedicationTypeCommandFromResourceAssembler {
    public static CreateMedicationTypeCommand toCommandFromResource(CreateMedicationTypeResource resource) {
        return new CreateMedicationTypeCommand(resource.typeName());
    }
}