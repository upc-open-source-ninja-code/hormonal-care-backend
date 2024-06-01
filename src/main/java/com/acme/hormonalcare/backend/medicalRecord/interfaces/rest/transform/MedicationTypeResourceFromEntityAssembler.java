package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.MedicationType;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.MedicationTypeResource;

public class MedicationTypeResourceFromEntityAssembler {
    public static MedicationTypeResource toResourceFromEntity(MedicationType entity) {
        return new MedicationTypeResource(entity.getId(), entity.getName());
    }
}