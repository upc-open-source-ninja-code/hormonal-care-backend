package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Treatment;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.TreatmentResource;

public class TreatmentResourceFromEntityAssembler {
    public static TreatmentResource toResourceFromEntity(Treatment entity){
        return new TreatmentResource(entity.getDescription());
    }
}
