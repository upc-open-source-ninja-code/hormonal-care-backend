package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePrescriptionCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Prescription;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePrescriptionCommand;

import java.util.Optional;

public interface PrescriptionCommandService {
    Optional<Prescription> handle(CreatePrescriptionCommand command);
    Optional<Prescription> handle(UpdatePrescriptionCommand command);
}