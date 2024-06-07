package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalRecord;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.MedicalRecordResource;

public class MedicalRecordResourceFromEntityAssembler {
    public static MedicalRecordResource toResourceFromEntity(MedicalRecord entity){
        return new MedicalRecordResource(
                entity.getId(),
                entity.getReasonOfConsultationId()
        );
    }
}
