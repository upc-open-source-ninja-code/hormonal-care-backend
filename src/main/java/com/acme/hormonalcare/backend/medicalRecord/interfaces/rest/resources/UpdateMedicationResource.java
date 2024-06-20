package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;


public record UpdateMedicationResource(
    Long medicalRecordId,
    Long medicationTypeId,
    Long prescriptionId,
    String name,
    int amount,
    String unitQ,
    int value,
    String unit,
    int timesPerDay,
    String timePeriod
) {}