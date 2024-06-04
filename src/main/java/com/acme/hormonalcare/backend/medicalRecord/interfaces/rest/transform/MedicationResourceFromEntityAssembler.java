package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Medication;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.MedicationResource;

public class MedicationResourceFromEntityAssembler {
    public static MedicationResource toResourceFromEntity(Medication entity) {
        return new MedicationResource(
                //entity.getMedicalRecord(),
                //entity.getPrescription().getId(),
                //entity.getMedicationType().getId(),
                entity.getId(),
                entity.getDrugName(),
                entity.getQuantity(),
                entity.getConcentration(),
                entity.getFrequency(),
                entity.getDuration()
        );
    }
}