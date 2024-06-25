package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateDiagnoseResource;

public class CreateDiagnoseCommandFromResourceAssembler {
    public static CreateDiagnoseCommand toCommandFromResource(CreateDiagnoseResource resource) {
        return new CreateDiagnoseCommand(resource.description(), resource.medicalRecordId());
    }
}