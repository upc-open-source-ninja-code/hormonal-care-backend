package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record UpdateExternalReportCommand (Long id, String image, Long medicalRecordId) {
}
