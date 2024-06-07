package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Doctor;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.DoctorResource;

public class DoctorResourceFromEntityAssembler {
    public static DoctorResource toResourceFromEntity(Doctor entity){
        return new DoctorResource(
            entity.getProfessionalIdentificationNumber().professionalIdentificationNumber(),
            entity.getSubSpecialty().subSpecialty(),
            entity.getCertification().certification(),
            entity.getAppointmentFee(),
            entity.getSubscriptionId(),
            entity.getProfileId().profileId()
        );
    }
}

/*
        String professionalIdentificationNumber,
        String subSpecialty,
        String certification,
        String appointmentFee,
        String subscriptionId,
        Long profileId
 */