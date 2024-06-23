package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateTreatmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateTreatmentResource;

public class CreateTreatmentCommandFromResourceAssembler {
    public static CreateTreatmentCommand toCommandFromResource(CreateTreatmentResource resource){
        return new CreateTreatmentCommand(resource.description(), resource.medicalRecordId());
    }
}
