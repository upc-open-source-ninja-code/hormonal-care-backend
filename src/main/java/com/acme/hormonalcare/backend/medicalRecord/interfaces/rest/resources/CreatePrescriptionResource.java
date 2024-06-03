package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

import java.util.Date;

public record CreatePrescriptionResource(
        Date prescriptionDate,
        String notes) { }