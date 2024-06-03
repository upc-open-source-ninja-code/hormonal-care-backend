package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetReasonOfConsultationByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.ReasonOfConsultationQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.ReasonOfConsultationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReasonOfConsultationQueryServiceImpl implements ReasonOfConsultationQueryService {
    private final ReasonOfConsultationRepository reasonOfConsultationRepository;

    public ReasonOfConsultationQueryServiceImpl(ReasonOfConsultationRepository reasonOfConsultationRepository) {
        this.reasonOfConsultationRepository = reasonOfConsultationRepository;
    }

    @Override
    public Optional<ReasonOfConsultation> handle(GetReasonOfConsultationByIdQuery query) {
        return reasonOfConsultationRepository.findById(query.id());
    }
}
