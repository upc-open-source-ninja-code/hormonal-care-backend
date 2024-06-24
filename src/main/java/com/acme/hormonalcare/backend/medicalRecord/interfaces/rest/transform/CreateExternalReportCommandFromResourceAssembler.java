package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateExternalReportCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateExternalReportResource;

public class CreateExternalReportCommandFromResourceAssembler {
    public static CreateExternalReportCommand toCommandFromResource(CreateExternalReportResource resource){
        return new CreateExternalReportCommand(resource.image(), resource.medicalRecordId());
    }
}
