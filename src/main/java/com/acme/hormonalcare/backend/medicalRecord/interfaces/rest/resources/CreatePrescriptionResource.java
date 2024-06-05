package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

import java.util.Date;

public record CreatePrescriptionResource(
        Long DoctorId,
        Long PatientId,
        Date prescriptionDate,
        String notes) { }

