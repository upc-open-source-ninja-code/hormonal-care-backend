package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditionalCertifications {
    private String url;

    public AdditionalCertifications(String url) {
        this.url = url;
    }
}