package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;


import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.TypeExam;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateTypeExamCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalExamCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.TypeExamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TypeExamCommandServiceImpl implements MedicalExamCommandService {
    private final TypeExamRepository typeExamRepository;

    public TypeExamCommandServiceImpl(TypeExamRepository typeExamRepository) {
        this.typeExamRepository = typeExamRepository;
    }

    @Override
    public Optional<TypeExam> handle(CreateTypeExamCommand command) {
        var typeExam = new TypeExam(command);
        typeExamRepository.save(typeExam);
        return Optional.of(typeExam);
    }
}


