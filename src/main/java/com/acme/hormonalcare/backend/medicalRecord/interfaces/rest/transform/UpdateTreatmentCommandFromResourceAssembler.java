package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateTreatmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateTreatmentResource;

public class UpdateTreatmentCommandFromResourceAssembler {
    public static UpdateTreatmentCommand toCommandFromResource(Long id, UpdateTreatmentResource resource){
        return new UpdateTreatmentCommand(
                id,
                resource.description()
        );
    }
}
