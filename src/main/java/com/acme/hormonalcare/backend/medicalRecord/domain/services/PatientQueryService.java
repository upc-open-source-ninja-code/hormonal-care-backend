package com.acme.hormonalcare.backend.medicalRecord.domain.services;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Patient;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetPatientByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetPatientByPatientRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetPatientByProfileIdQuery;

import java.util.Optional;

public interface PatientQueryService {
    Optional<Patient> handle(GetPatientByIdQuery query);
    Optional<Patient> handle(GetPatientByProfileIdQuery query);
    Optional<Patient> handle(GetPatientByPatientRecordIdQuery query);
}
