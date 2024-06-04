package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Prescription;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetPrescriptionByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetAllPrescriptionsQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.PrescriptionQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionQueryServiceImpl implements PrescriptionQueryService {
    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionQueryServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Optional<Prescription> handle(GetPrescriptionByIdQuery query) {
        return prescriptionRepository.findById(query.prescriptionId());
    }

    @Override
    public List<Prescription> handle(GetAllPrescriptionsQuery query) {
        return prescriptionRepository.findAll();
    }
}