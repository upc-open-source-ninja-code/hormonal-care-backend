package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetReasonOfConsultationByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.ReasonOfConsultationQueryService;

import java.util.Optional;

public class ReasonOfConsultationQueryServiceImpl implements ReasonOfConsultationQueryService {
    @Override
    public Optional<ReasonOfConsultation> handle(GetReasonOfConsultationByIdQuery query) {
        return Optional.empty();
    }
}
