package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;


import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalExam;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalExamCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalExamCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicalExamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MedicalExamCommandServiceImpl implements MedicalExamCommandService {

    private final MedicalExamRepository medicalExamRepository;

    public MedicalExamCommandServiceImpl(MedicalExamRepository medicalExamRepository) {
        this.medicalExamRepository = medicalExamRepository;
    }

    @Override
    public Optional<MedicalExam> handle(CreateMedicalExamCommand command) {
        var medicalExam = new MedicalExam(command);
        medicalExamRepository.save(medicalExam);
        return Optional.of(medicalExam);
    }

}
