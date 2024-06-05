package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalRecord;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalRecordCommand;

import java.util.Optional;

public interface MedicalRecordCommandService {
    Optional<MedicalRecord> handle(CreateMedicalRecordCommand command);
}
