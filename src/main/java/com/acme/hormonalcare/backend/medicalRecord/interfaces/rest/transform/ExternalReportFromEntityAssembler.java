package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ExternalReport;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.ExternalReportResource;

public class ExternalReportFromEntityAssembler {
    public static ExternalReportResource toResourceFromEntity(ExternalReport entity){
        return new ExternalReportResource(entity.getImage(), entity.getMedicalRecord().getId());
    }
}
