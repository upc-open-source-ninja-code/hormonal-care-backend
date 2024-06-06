package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Diagnose;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetAllDiagnosesQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDiagnoseByIdQuery;

import java.util.List;
import java.util.Optional;

public interface DiagnoseQueryService {
    List<Diagnose> handle(GetAllDiagnosesQuery query);

    Optional<Diagnose> handle(GetDiagnoseByIdQuery query);
}
