package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetReasonOfConsultationByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetReasonOfConsultationByMedicalRecordIdQuery;

import java.util.Optional;

public interface ReasonOfConsultationQueryService {
    Optional<ReasonOfConsultation> handle(GetReasonOfConsultationByIdQuery query);
    Optional<ReasonOfConsultation> handle(GetReasonOfConsultationByMedicalRecordIdQuery query);
}
