package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Treatment;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTreatmentByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTreatmentByMedicalRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.TreatmentQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreatmentQueryServiceImpl implements TreatmentQueryService {
    private final TreatmentRepository treatmentRepository;

    public TreatmentQueryServiceImpl(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public Optional<Treatment> handle(GetTreatmentByIdQuery query) {
        return treatmentRepository.findById(query.id());
    }

    @Override
    public Optional<Treatment> handle(GetTreatmentByMedicalRecordIdQuery query) {
        return treatmentRepository.findByMedicalRecordId(query.medicalRecordId());
    }
}
