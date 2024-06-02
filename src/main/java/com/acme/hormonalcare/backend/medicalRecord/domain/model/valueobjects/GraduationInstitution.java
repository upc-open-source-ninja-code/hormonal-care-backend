package com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record GraduationInstitution(String graduationInstitution) {
    public GraduationInstitution() {
        this(null);
    }

    public GraduationInstitution {
        if (graduationInstitution == null || graduationInstitution.isBlank()) {
            throw new IllegalArgumentException("Graduation institution must not be null or blank");
        }
    }

    public String getGraduationInstitution() {
        return String.format("%s", graduationInstitution);
    }
}
