package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicationTypeCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.MedicationType;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationTypeCommand;

import java.util.Optional;

public interface MedicationTypeCommandService {
    Optional<MedicationType> handle(CreateMedicationTypeCommand command);
    Optional<MedicationType> handle(UpdateMedicationTypeCommand command);
}