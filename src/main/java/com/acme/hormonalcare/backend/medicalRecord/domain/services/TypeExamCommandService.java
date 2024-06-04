package com.acme.hormonalcare.backend.medicalRecord.domain.services;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.TypeExam;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateTypeExamCommand;
import java.util.Optional;

public interface TypeExamCommandService {
    Optional<TypeExam> handle(CreateTypeExamCommand command);
}
