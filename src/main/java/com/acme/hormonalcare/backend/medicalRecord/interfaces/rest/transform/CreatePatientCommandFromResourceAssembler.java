package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePatientCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreatePatientResource;

public class CreatePatientCommandFromResourceAssembler {
    public static CreatePatientCommand toCommandFromResource(CreatePatientResource resource){
        return new CreatePatientCommand(
                resource.firstName(),
                resource.lastName(),
                resource.gender(),
                resource.age(),
                resource.phoneNumber(),
                resource.email(),
                resource.Image(),
                resource.birthday(),
                resource.typeofblood(),
                resource.doctorId()
        );
    }
}
