package com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record GraduationYear(String graduationYear) {
    public GraduationYear() {
        this(null);
    }

    public GraduationYear {
        if (graduationYear == null || graduationYear.isBlank()) {
            throw new IllegalArgumentException("Graduation year must not be null or blank");
        }
    }

    public String getGraduationYear() {
        return String.format("%s", graduationYear);
    }
}
