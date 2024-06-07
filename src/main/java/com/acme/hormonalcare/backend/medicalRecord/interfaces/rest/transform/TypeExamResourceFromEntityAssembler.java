package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.TypeExam;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.TypeExamResource;

public class TypeExamResourceFromEntityAssembler {
    public static TypeExamResource toResourceFromEntity(TypeExam entity) {
        return new TypeExamResource(
                entity.getName()
        );
    }
}
