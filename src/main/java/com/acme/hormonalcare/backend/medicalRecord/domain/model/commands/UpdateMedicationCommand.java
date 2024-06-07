package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record UpdateMedicationCommand(Long id,Long prescriptionId, Long medicationTypeId, String name, int amount, String unitQ, int value, String unit, int timesPerDay, String timePeriod) {
}
