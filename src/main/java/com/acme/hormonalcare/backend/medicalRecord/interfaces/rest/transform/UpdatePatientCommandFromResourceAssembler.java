package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePatientCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateReasonOfConsultationCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdatePatientResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateReasonOfConsultationResource;

public class UpdatePatientCommandFromResourceAssembler {
    public static UpdatePatientCommand toCommandFromResource(Long id, UpdatePatientResource resource) {
        return new UpdatePatientCommand(
                id,
                resource.typeofblood()
        );
    }
}
