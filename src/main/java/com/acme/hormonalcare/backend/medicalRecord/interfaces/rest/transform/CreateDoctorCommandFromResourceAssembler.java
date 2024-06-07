package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDoctorCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateDoctorResource;

public class CreateDoctorCommandFromResourceAssembler {
    public static CreateDoctorCommand toCommandFromResource(CreateDoctorResource resource) {
        return new CreateDoctorCommand(
                resource.professionalIdentificationNumber(),
                resource.subSpecialty(),
                resource.certification(),
                resource.appointmentFee(),
                resource.subscriptionId(),
                resource.profileId()
        );
    }
}
