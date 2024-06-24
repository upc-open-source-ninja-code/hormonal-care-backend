package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

public record PatientResource(
        String typeofblood, String patientRecordId, Long profileId, Long doctorId) {
}
