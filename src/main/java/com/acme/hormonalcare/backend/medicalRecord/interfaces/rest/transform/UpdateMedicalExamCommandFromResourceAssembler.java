package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicalExamCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateMedicalExamResource;

public class UpdateMedicalExamCommandFromResourceAssembler {
    public static UpdateMedicalExamCommand toCommandFromResource(Long id, UpdateMedicalExamResource resource) {
        return new UpdateMedicalExamCommand(
                id,
                resource.name(),
                resource.typeExamId()
        );
    }
}

