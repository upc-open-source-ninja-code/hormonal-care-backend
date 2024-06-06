package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Diagnose;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetAllDiagnosesQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDiagnoseByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DiagnoseQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.DiagnoseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnoseQueryServiceImpl implements DiagnoseQueryService {
    private final DiagnoseRepository diagnoseRepository;

    public DiagnoseQueryServiceImpl(DiagnoseRepository diagnoseRepository) {
        this.diagnoseRepository = diagnoseRepository;
    }

    @Override
    public List<Diagnose> handle(GetAllDiagnosesQuery query) {
        return diagnoseRepository.findAll();
    }

    @Override
    public Optional<Diagnose> handle(GetDiagnoseByIdQuery query) {
        return diagnoseRepository.findById(query.id());
    }
}
