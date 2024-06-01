package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Medication;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.*;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicationQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationQueryServiceImpl implements MedicationQueryService {
    private final MedicationRepository medicationRepository;

    public MedicationQueryServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public List<Medication> handle(GetAllMedicationsQuery query) {
        return medicationRepository.findAll();
    }

    @Override
    public Optional<Medication> handle(GetMedicationByIdQuery query) {
        return medicationRepository.findById(query.id());
    }

   /* @Override
    public List<Medication> handle(GetMedicationsByMedicalRecordIdQuery query) {
        return medicationRepository.findByMedicalRecordId(query.medicalRecordId());
    }*/

    @Override
    public List<Medication> handle(GetMedicationsByPrescriptionIdQuery query) {
        return medicationRepository.findByPrescriptionId(query.prescriptionId());
    }

    @Override
    public List<Medication> handle(GetMedicationsByTypeIdQuery query) {
        return medicationRepository.findByMedicationTypeId(query.medicationTypeId());
    }

    @Override
    public List<Medication> handle(GetMedicationByDrugNameQuery query) {
        return medicationRepository.findByDrugName(query.drugName());
    }
}