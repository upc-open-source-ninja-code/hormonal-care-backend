package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

import java.util.Date;

public record PrescriptionResource(
        Long id,
        Long doctorId,
        Long patientId,
        Date prescriptionDate,
        String notes) {
}