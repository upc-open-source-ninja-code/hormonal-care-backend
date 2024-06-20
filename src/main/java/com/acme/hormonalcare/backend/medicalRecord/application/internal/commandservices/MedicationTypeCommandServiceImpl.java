package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicationTypeCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.MedicationType;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationTypeCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicationTypeCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicationTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicationTypeCommandServiceImpl implements MedicationTypeCommandService {
    private final MedicationTypeRepository medicationTypeRepository;

    public MedicationTypeCommandServiceImpl(MedicationTypeRepository medicationTypeRepository) {
        this.medicationTypeRepository = medicationTypeRepository;
    }

    @Override
    public Optional<MedicationType> handle(CreateMedicationTypeCommand command) {
        var medicationType = new MedicationType(command);
        medicationTypeRepository.save(medicationType);
        return Optional.of(medicationType);
    }

    @Override
    public Optional<MedicationType> handle(UpdateMedicationTypeCommand command) {
        var medicationType = medicationTypeRepository.findById(command.id());

        if (medicationType.isEmpty()) {
            return Optional.empty();
        }
        medicationType.get().update(command);
        medicationTypeRepository.save(medicationType.get());
        return Optional.of(medicationType.get());
    }
}