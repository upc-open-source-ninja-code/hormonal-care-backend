package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

import java.util.Date;

public record CreatePrescriptionCommand(Long medicalRecord, Date prescriptionDate, Long doctorId, Long patientId, String notes) {
}
