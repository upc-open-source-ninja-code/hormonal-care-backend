package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;


import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalExamCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateMedicalExamResource;

public class CreateMedicalExamCommandFromResourceAssembler {
    public static CreateMedicalExamCommand toCommandFromResource(CreateMedicalExamResource resource) {
        return new CreateMedicalExamCommand(
                resource.name()
        );
    }
}
