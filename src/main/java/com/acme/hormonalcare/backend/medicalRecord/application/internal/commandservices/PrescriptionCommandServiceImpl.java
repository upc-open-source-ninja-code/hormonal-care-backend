package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Prescription;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePrescriptionCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.PrescriptionCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrescriptionCommandServiceImpl implements PrescriptionCommandService {
    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionCommandServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Optional<Prescription> handle(CreatePrescriptionCommand command) {
        var prescription = new Prescription(command);
        prescriptionRepository.save(prescription);
        return Optional.of(prescription);
    }
}