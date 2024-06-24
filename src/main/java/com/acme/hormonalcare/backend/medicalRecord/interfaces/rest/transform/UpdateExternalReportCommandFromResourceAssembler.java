package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateExternalReportCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateExternalReportResource;

public class UpdateExternalReportCommandFromResourceAssembler {
    public static UpdateExternalReportCommand toCommandFromResource(Long id, UpdateExternalReportResource resource){
        return new UpdateExternalReportCommand(
                id,
                resource.image(),
                resource.medicalRecordId()
        );
    }
}
