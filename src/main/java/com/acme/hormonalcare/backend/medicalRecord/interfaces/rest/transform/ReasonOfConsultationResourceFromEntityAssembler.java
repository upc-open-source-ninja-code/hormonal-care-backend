package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.ReasonOfConsultationResource;

public class ReasonOfConsultationResourceFromEntityAssembler {
    public static ReasonOfConsultationResource toResourceFromEntity(ReasonOfConsultation entity) {
        return new ReasonOfConsultationResource(
                entity.getDescription(),
                entity.getSymptoms());
    }
}
