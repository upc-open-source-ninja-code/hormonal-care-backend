package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ExternalReport;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Treatment;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetExternalReportByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetExternalReportByMedicalRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTreatmentByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTreatmentByMedicalRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.ExternalReportQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.ExternalReportRepository;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExternalReportQueryServiceImpl implements ExternalReportQueryService {
    private final ExternalReportRepository externalReportRepository;

    public ExternalReportQueryServiceImpl(ExternalReportRepository externalReportRepository) {
        this.externalReportRepository = externalReportRepository;
    }

    @Override
    public Optional<ExternalReport> handle(GetExternalReportByIdQuery query) {
        return externalReportRepository.findById(query.id());
    }

    @Override
    public List<ExternalReport> handle(GetExternalReportByMedicalRecordIdQuery query) {
        return externalReportRepository.findByMedicalRecordId(query.medicalRecordId());
    }
}
