package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDoctorCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateDoctorResource;

public class UpdateDoctorCommandFromResourceAssembler {
    public static UpdateDoctorCommand toCommandFromResource(Long id, UpdateDoctorResource resource) {
        return new UpdateDoctorCommand(
                id,
                resource.appointmentFee(),
                resource.subscriptionId()
        );
    }
}
