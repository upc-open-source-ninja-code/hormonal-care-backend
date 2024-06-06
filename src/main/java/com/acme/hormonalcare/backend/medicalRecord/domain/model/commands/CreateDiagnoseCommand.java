package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;


public record CreateDiagnoseCommand(String diagnose, String description) {
}
