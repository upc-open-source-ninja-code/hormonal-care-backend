package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record CreateTreatmentCommand(String description, Long medicalRecordId) {

}
