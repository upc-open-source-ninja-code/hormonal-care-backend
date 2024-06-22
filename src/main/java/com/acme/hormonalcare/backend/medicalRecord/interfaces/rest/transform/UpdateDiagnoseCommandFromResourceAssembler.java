package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateDiagnoseResource;

public class UpdateDiagnoseCommandFromResourceAssembler {
    public static UpdateDiagnoseCommand toCommandFromResource(Long id, UpdateDiagnoseResource resource){
        return new UpdateDiagnoseCommand(
                id,
                resource.description()
        );
    }
}