
package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Diagnose;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDiagnoseByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDiagnoseByMedicalRecordIdQuery;

import java.util.Optional;

public interface DiagnoseQueryService {
    Optional<Diagnose> handle(GetDiagnoseByIdQuery query);
    Optional<Diagnose> handle(GetDiagnoseByMedicalRecordIdQuery query);
}
