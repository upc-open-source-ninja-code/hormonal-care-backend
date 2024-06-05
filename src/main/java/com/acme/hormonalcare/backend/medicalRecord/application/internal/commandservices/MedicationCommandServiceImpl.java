package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Medication;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicationCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.MedicationType;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Prescription;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicationCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.*;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class MedicationCommandServiceImpl implements MedicationCommandService {
    private final MedicationRepository medicationRepository;
    private final MedicationTypeRepository medicationTypeRepository;
    private final PrescriptionRepository prescriptionRepository;

    public MedicationCommandServiceImpl(MedicationRepository medicationRepository, MedicationTypeRepository medicationTypeRepository, PrescriptionRepository prescriptionRepository) {
        this.medicationRepository = medicationRepository;
        this.medicationTypeRepository = medicationTypeRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Optional<Medication> handle(CreateMedicationCommand command) {
        Prescription prescription = prescriptionRepository.findById(command.prescriptionId()).orElseThrow(() -> new RuntimeException("Prescription not found"));
        MedicationType medicationType = medicationTypeRepository.findById(command.medicalTypeId()).orElseThrow(() -> new RuntimeException("MedicationType not found"));
        var medication = new Medication(command, prescription, medicationType);
        medicationRepository.save(medication);
        return Optional.of(medication);
    }


    @Override
    public Optional<Medication> handle(UpdateMedicationCommand command) {
        var medication = medicationRepository.findById(command.id());

        if (medication.isEmpty()) {
            return Optional.empty();
        }

        var prescription = prescriptionRepository.findById(command.prescriptionId());
        var medicationType = medicationTypeRepository.findById(command.medicationTypeId());

        if (prescription.isEmpty() || medicationType.isEmpty()) {
            return Optional.empty();
        }

        medication.get().update(command, prescription.get(), medicationType.get());

        medicationRepository.save(medication.get());
        return Optional.of(medication.get());
    }
}