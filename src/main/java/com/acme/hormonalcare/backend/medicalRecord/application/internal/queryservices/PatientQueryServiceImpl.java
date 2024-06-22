package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Patient;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetPatientByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetPatientByPatientRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetPatientByProfileIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetProfileIdByPatientIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.PatientQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PatientQueryServiceImpl implements PatientQueryService {
    private final PatientRepository patientRepository;

    public PatientQueryServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Optional<Patient> handle(GetPatientByIdQuery query) {

        return patientRepository.findById(query.id());
    }

    @Override
    public Optional<Patient> handle(GetPatientByProfileIdQuery query) {
        return patientRepository.findByProfileId(query.profileId());
    }

    @Override
    public Optional<Patient> handle(GetPatientByPatientRecordIdQuery query) {
        return patientRepository.findByPatientRecordId(query.patientRecordId());
    }

    @Override
    public Optional<Long> handle(GetProfileIdByPatientIdQuery query) {
        return patientRepository.findById(query.patientId())
                .map(Patient::getProfileId);
    }
}


