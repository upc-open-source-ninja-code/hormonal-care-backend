package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

import java.util.Date;

public record CreatePrescriptionCommand(Date prescriptionDate, String notes) {
}
