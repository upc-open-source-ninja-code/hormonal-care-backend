package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePatientDoctorIdCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdatePatientDoctorIdResource;

public class UpdatePatientDoctorIdCommandFromResourceAssembler {
    public static UpdatePatientDoctorIdCommand toCommandFromResource(Long id, UpdatePatientDoctorIdResource resource) {
        return new UpdatePatientDoctorIdCommand(
                id,
                resource.doctorId()
        );
    }
}
