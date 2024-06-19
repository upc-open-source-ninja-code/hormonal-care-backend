package com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StartTime(String time) {
    public StartTime {
        if (time == null || time.isBlank()) {
            throw new IllegalArgumentException("Start time cannot be null or empty");
        }
    }
}