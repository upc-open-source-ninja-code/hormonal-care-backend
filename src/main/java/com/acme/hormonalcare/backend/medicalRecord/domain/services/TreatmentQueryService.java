package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Treatment;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTreatmentByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTreatmentByMedicalRecordIdQuery;

import java.util.Optional;

public interface TreatmentQueryService {
    Optional<Treatment> handle(GetTreatmentByIdQuery query);
    Optional<Treatment> handle(GetTreatmentByMedicalRecordIdQuery query);
}
