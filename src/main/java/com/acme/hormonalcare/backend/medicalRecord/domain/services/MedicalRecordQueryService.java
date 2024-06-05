package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalRecord;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalRecordByIdQuery;

import java.util.Optional;

public interface MedicalRecordQueryService {
    Optional<MedicalRecord> handle(GetMedicalRecordByIdQuery query);
}
