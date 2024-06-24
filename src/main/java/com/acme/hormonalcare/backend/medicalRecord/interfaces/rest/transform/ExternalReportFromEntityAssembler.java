package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ExternalReport;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.ExternalReportResouce;

public class ExternalReportFromEntityAssembler {
    public static ExternalReportResouce toResourceFromEntity(ExternalReport entity){
        return new ExternalReportResouce(entity.getImage(), entity.getMedicalRecord().getId());
    }
}
