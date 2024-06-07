package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDoctorAppointmentFeeCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateDoctorAppointmentFeeResource;

public class UpdateDoctorAppointmentFeeCommandFromResourceAssembler {
    public static UpdateDoctorAppointmentFeeCommand toCommandFromResource(Long id, UpdateDoctorAppointmentFeeResource resource) {
        return new UpdateDoctorAppointmentFeeCommand(
                id,
                resource.appointmentFee()
        );
    }
}
