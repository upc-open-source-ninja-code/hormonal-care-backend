package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record UpdateMedicalExamCommand(Long id, String name, Long typeExamId) {
}
