package com.acme.hormonalcare.backend.medicalRecord.domain.services;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.TypeExam;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTypeExamByIdQuery;
import java.util.Optional;

public interface TypeExamQueryService {
    Optional<TypeExam> handle(GetTypeExamByIdQuery query);
}
