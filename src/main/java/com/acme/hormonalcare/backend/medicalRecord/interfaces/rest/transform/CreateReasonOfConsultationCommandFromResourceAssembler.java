package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateReasonOfConsultationCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateReasonOfConsultationResource;

public class CreateReasonOfConsultationCommandFromResourceAssembler {
    public static CreateReasonOfConsultationCommand toCommandFromResource(CreateReasonOfConsultationResource resource) {
        return new CreateReasonOfConsultationCommand(
                resource.description(),
                resource.symptoms()
        );
    }
}
