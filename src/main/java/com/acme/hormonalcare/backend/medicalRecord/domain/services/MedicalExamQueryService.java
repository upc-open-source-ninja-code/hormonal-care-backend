package com.acme.hormonalcare.backend.medicalRecord.domain.services;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalExam;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalExamByIdQuery;
import java.util.Optional;

public interface MedicalExamQueryService {
    Optional<MedicalExam> handle(GetMedicalExamByIdQuery query);

}
