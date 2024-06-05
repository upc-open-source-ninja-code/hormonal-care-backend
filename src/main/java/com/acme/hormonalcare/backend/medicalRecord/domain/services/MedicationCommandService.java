package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Medication;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicationCommand;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MedicationCommandService {
    Optional<Medication> handle(CreateMedicationCommand command);
    Optional<Medication> handle(UpdateMedicationCommand command);

}
