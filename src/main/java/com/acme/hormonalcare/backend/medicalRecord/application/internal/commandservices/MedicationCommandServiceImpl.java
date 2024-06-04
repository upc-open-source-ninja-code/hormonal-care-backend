package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Medication;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicationCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicationCommandServiceImpl implements MedicationCommandService {
    private final MedicationRepository medicationRepository;

    public MedicationCommandServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public Optional<Medication> handle(CreateMedicationCommand command) {
        var medication = new Medication(command);
        medicationRepository.save(medication);
        return Optional.of(medication);
    }
}