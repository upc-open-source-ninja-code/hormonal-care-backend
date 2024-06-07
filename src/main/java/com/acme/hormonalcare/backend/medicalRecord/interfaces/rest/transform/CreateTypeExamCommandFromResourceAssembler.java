package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateTypeExamCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateTypeExamResource;

public class CreateTypeExamCommandFromResourceAssembler {
    public static CreateTypeExamCommand toCommandFromResource(CreateTypeExamResource resource) {
        return new CreateTypeExamCommand(
                resource.name()
        );
    }
}

