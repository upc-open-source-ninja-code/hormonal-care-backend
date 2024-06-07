package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalRecord;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalRecordByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalRecordQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalRecordQueryServiceImpl implements MedicalRecordQueryService {
    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordQueryServiceImpl(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public Optional<MedicalRecord> handle(GetMedicalRecordByIdQuery query) {
        return medicalRecordRepository.findById(query.id());
    }
}
