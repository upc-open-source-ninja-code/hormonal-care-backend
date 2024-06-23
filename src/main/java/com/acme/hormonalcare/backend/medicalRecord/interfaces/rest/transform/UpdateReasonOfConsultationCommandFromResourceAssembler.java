package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateReasonOfConsultationCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateReasonOfConsultationResource;

public class UpdateReasonOfConsultationCommandFromResourceAssembler {
    public static UpdateReasonOfConsultationCommand toCommandFromResource(Long id, UpdateReasonOfConsultationResource resource) {
        return new UpdateReasonOfConsultationCommand(
                id,
                resource.description(),
                resource.symptoms(),
                resource.medicalRecordId()
        );
    }
}
