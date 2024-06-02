package com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record ProfessionalIdentificationNumber(String professionalIdentificationNumber) {
    public ProfessionalIdentificationNumber() {
        this(null);
    }

    public ProfessionalIdentificationNumber {
        if (professionalIdentificationNumber == null || professionalIdentificationNumber.isBlank()) {
            throw new IllegalArgumentException("Professional identification number must not be null or blank");
        }
    }

    public String getProfessionalIdentificationNumber() {
        return String.format("%s", professionalIdentificationNumber);
    }
}
