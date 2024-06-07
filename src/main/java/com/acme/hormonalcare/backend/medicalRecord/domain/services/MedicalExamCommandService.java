package com.acme.hormonalcare.backend.medicalRecord.domain.services;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalExam;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalExamCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicalExamCommand;
import java.util.Optional;

public interface MedicalExamCommandService {
    Optional<MedicalExam> handle(CreateMedicalExamCommand command);
    Optional<MedicalExam> handle(UpdateMedicalExamCommand command);
}
