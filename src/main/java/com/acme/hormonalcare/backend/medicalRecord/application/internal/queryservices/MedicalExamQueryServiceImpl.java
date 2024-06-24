package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;


import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalExam;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalExamByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalExamByMedicalRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalExamQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicalExamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MedicalExamQueryServiceImpl implements MedicalExamQueryService {

    private final MedicalExamRepository medicalExamRepository;

    public MedicalExamQueryServiceImpl(MedicalExamRepository medicalExamRepository) {
        this.medicalExamRepository = medicalExamRepository;
    }

    @Override
    public Optional<MedicalExam> handle(GetMedicalExamByIdQuery query) {
        return medicalExamRepository.findById(query.id());
    }

    @Override
    public Optional<MedicalExam> handle(GetMedicalExamByMedicalRecordIdQuery query) {
        return medicalExamRepository.findByMedicalRecordId(query.medicalRecordId());
    }

}

