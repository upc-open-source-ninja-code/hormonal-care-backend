package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record CreateMedicationCommand(String name, int amount, String unitQ, int value, String unit, int timesPerDay, String timePeriod) {
}

