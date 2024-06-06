package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePatientCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdatePatientResource;

public class UpdatePatientCommandFromResourceAssembler {
    public static UpdatePatientCommand toCommandFromResource(Long id, UpdatePatientResource resource) {
        return new UpdatePatientCommand(
                id,
                resource.typeofblood()
        );
    }
}
