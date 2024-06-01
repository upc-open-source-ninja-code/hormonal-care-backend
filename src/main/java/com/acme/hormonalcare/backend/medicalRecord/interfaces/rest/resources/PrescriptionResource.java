package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

import java.util.Date;

public record PrescriptionResource(
        Long id,
        Long medicalRecord,
        Date prescriptionDate,
        Long doctorId,
        Long patientId,
        String notes) {
}