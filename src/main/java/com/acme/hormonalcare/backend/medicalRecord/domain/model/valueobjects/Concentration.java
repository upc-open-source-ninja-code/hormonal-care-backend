package com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Concentration(int value, String unit) {
    public Concentration {
        if (value <= 0) {
            throw new IllegalArgumentException("Concentration value must be greater than zero");
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException("Unit cannot be null or empty");
        }
    }
}
