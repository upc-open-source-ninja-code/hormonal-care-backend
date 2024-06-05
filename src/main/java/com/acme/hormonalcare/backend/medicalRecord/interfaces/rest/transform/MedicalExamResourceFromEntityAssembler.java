package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;


import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalExam;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.MedicalExamResource;

public class MedicalExamResourceFromEntityAssembler {
    public static MedicalExamResource toResourceFromEntity(MedicalExam entity) {
        return new MedicalExamResource(
                entity.getName(),
                entity.getTypeExam().getId()
        );
    }
}
