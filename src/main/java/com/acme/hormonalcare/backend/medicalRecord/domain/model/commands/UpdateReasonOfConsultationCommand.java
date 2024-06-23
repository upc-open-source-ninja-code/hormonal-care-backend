package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record UpdateReasonOfConsultationCommand(Long id, String description, String symptoms, Long medicalRecordId) {
}
