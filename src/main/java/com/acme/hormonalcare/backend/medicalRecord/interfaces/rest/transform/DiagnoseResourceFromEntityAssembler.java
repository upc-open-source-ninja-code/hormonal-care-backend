package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Diagnose;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.DiagnoseResource;

public class DiagnoseResourceFromEntityAssembler {
    public static DiagnoseResource toResourceFromEntity(Diagnose entity) {
        return new DiagnoseResource(entity.getId(), entity.getDiagnose(), entity.getDescription());
    }
}
