package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDoctorCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateDoctorResource;

public class CreateDoctorCommandFromResourceAssembler {
    public static CreateDoctorCommand toCommandFromResource(CreateDoctorResource resource) {
        return new CreateDoctorCommand(
                resource.firstName(),
                resource.lastName(),
                resource.gender(),
                resource.age(),
                resource.phoneNumber(),
                resource.email(),
                resource.Image(),
                resource.birthday(),
                resource.professionalIdentificationNumber(),
                resource.subSpecialty(),
                resource.certification(),
                resource.appointmentFee(),
                resource.subscriptionId()
        );
    }
}
