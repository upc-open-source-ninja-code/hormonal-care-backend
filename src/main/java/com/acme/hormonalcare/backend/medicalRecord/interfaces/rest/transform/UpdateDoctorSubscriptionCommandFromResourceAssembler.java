package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDoctorSubscriptionCommand;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateDoctorSubscriptionResource;

public class UpdateDoctorSubscriptionCommandFromResourceAssembler {
    public static UpdateDoctorSubscriptionCommand toCommandFromResource(Long id, UpdateDoctorSubscriptionResource resource) {
        return new UpdateDoctorSubscriptionCommand(
                id,
                resource.subscriptionId()
        );
    }
}
