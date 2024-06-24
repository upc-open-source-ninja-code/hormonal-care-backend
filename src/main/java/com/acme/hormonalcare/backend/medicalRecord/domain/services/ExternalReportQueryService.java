package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ExternalReport;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.*;

import java.util.Optional;

public interface ExternalReportQueryService {
    Optional<ExternalReport> handle(GetExternalReportByIdQuery query);
    Optional<ExternalReport> handle(GetExternalReportByMedicalRecordIdQuery query);
}
