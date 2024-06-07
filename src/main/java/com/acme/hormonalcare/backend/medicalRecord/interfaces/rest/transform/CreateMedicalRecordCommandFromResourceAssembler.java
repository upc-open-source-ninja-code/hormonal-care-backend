package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalRecordCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateMedicalRecordResource;

public class CreateMedicalRecordCommandFromResourceAssembler {
    public static CreateMedicalRecordCommand toCommandFromResource(CreateMedicalRecordResource resource){
        return new CreateMedicalRecordCommand();
    }
}
