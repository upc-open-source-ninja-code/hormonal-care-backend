package com.acme.hormonalcare.backend.medicalRecord.domain.model.queries;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.DrugName;

public record GetMedicationByDrugNameQuery(DrugName drugName) {
}
