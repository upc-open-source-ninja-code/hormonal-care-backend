package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Medication;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface MedicationQueryService {
    List<Medication> handle(GetAllMedicationsQuery query);
    Optional<Medication> handle(GetMedicationByIdQuery query);
    Optional<Medication> handle(GetMedicationByDrugNameQuery query);
    Optional<Medication> handle(GetMedicationsByPrescriptionIdQuery query);
    Optional<Medication> handle(GetMedicationsByTypeIdQuery query);
}