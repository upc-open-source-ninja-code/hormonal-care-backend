package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;



public record CreateMedicationResource(
        Long medicalRecordId,
        Long medicalTypeId,
        Long prescriptionId,
        String name,
        int amount,
        String unitQ,
        int value,
        String unit,
        int timesPerDay,
        String timePeriod
) {

}

