package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

//import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.MedicationType;
//import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Prescription;

public record CreateMedicationResource(

        String name,
        int amount,
        String unitQ,
        int value,
        String unit,
        int timesPerDay,
        String timePeriod
) { }

