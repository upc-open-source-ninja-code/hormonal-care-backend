package com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record CodeDoctor(String codeDoctor) {

}
