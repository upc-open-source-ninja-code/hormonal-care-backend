package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record UpdateMedicationTypeCommand(Long id, String typeName) {
}
