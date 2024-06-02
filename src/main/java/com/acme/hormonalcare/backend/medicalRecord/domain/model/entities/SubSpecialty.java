package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;

import lombok.Getter;

@Getter
public class SubSpecialty {
    private String name;

    public SubSpecialty(String name) {
        this.name = name;
    }

}