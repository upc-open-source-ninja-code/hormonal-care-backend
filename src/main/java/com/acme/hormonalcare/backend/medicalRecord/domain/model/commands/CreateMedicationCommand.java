package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;


import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.MedicationType;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Prescription;

public record CreateMedicationCommand(Long medicalRecordId, Prescription prescriptionId, MedicationType medicationTypeId, String name, int amount, String unitQ, int value, String unit, int timesPerDay, String timePeriod) {
}

