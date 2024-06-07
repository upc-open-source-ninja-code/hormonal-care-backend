package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;


import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalExam;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.TypeExam;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalExamCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicalExamCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalExamCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicalExamRepository;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.TypeExamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MedicalExamCommandServiceImpl implements MedicalExamCommandService {

    private final MedicalExamRepository medicalExamRepository;
    private final TypeExamRepository typeExamRepository;

    public MedicalExamCommandServiceImpl(MedicalExamRepository medicalExamRepository, TypeExamRepository typeExamRepository) {
        this.medicalExamRepository = medicalExamRepository;
        this.typeExamRepository = typeExamRepository;
    }

    @Override
    public Optional<MedicalExam> handle(CreateMedicalExamCommand command) {
        TypeExam typeExam = typeExamRepository.findById(command.typeExamId()).orElseThrow(() -> new RuntimeException("TypeExam no encontrado"));
        var medicalExam = new MedicalExam(command, typeExam);
        medicalExamRepository.save(medicalExam);
        return Optional.of(medicalExam);
    }

    @Override
    public Optional<MedicalExam> handle(UpdateMedicalExamCommand command) {
        var id = command.id();
        if (!medicalExamRepository.existsById(id)) {
            throw new IllegalArgumentException("MedicalExam with id "+ command.id() +"does not exists");
        }
        TypeExam typeExam = typeExamRepository.findById(command.typeExamId()).orElseThrow(() -> new RuntimeException("El TypeExam no existe"));
        var result = medicalExamRepository.findById(id);
        var medicalExamToUpdate = result.get();
        try {
            var updatedMedicalExam = medicalExamRepository.save(medicalExamToUpdate.updateInformation(command.name(), typeExam));
            return Optional.of(updatedMedicalExam);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating medicalExam: " + e.getMessage());
        }
    }

}
