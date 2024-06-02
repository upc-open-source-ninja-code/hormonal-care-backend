package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;

import lombok.Getter;

@Getter
public class Specialty {
    private String name;

    public Specialty(String name) {
        this.name = name;
    }

}