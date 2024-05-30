package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;

public record CreateMedicationCommand(MedicalRecord medicalRecord, Prescription prescription, MedicationType medicationType, DrugName drugName, Quantity quantity, Concentration concentration, Frequency frequency, Duration duration) {
}
