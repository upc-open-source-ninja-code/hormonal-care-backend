package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Prescription;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface PrescriptionQueryService {
    List<Prescription> handle(GetAllPrescriptionsQuery query);
    Optional<Prescription> handle(GetPrescriptionByIdQuery query);
}