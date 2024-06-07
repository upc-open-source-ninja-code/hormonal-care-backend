package com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfessionalIdentificationNumber(String professionalIdentificationNumber) {
    public ProfessionalIdentificationNumber {
        if (professionalIdentificationNumber == null || professionalIdentificationNumber.isBlank()) {
            throw new IllegalArgumentException("Professional Identification Number cannot be null or empty");
        }
    }
}
