package com.acme.hormonalcare.backend.medicalRecord.domain.model.queries;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.PatientRecordId;

public record GetPatientByPatientRecordIdQuery(PatientRecordId patientRecordId) {
}
