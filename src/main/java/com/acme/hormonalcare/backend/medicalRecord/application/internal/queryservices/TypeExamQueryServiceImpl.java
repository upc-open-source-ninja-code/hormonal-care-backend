package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.TypeExam;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTypeExamByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.TypeExamQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.TypeExamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TypeExamQueryServiceImpl implements TypeExamQueryService {
    private final TypeExamRepository typeExamRepository;

    public TypeExamQueryServiceImpl(TypeExamRepository typeExamRepository) {
        this.typeExamRepository = typeExamRepository;
    }

    @Override
    public Optional<TypeExam> handle(GetTypeExamByIdQuery query) {
        return typeExamRepository.findById(query.id());

    }
}
