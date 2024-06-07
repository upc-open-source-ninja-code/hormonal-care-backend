package com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public record EventDate(LocalDate date) {
    public EventDate {
        if (date == null) {
            throw new IllegalArgumentException("Event date cannot be null");
        }
    }
}