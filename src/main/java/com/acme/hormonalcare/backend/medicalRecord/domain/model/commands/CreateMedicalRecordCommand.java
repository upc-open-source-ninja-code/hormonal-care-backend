package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record CreateMedicalRecordCommand(
        Long patientId
) {
}
