package com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class DoctorRecordId {
    private String doctorRecordId;

    public DoctorRecordId() {
        this.doctorRecordId = UUID.randomUUID().toString();
    }

    public DoctorRecordId(String doctorRecordId) {
        if (doctorRecordId == null || doctorRecordId.isBlank()) {
            throw new IllegalArgumentException("Patient record profileId cannot be null or blank");
        }
        this.doctorRecordId = doctorRecordId;
    }

    public String doctorRecordId() {
        return doctorRecordId;
    }
}