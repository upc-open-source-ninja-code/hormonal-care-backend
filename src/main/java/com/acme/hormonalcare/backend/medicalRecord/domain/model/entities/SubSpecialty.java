package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.SubSpecialties;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

public class SubSpecialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(unique = true, length = 20)
    private SubSpecialties subSpecialties;

    public SubSpecialty() {}

    public SubSpecialty(SubSpecialties subSpecialties) {
        this.subSpecialties = subSpecialties;
    }

    public static SubSpecialty getDefaultSubSpecialty() {
        return new SubSpecialty(SubSpecialties.DIABETES_AND_METABOLISM);
    }

    public static SubSpecialty toSubSpecialtyFromName(String name) {
        return new SubSpecialty(SubSpecialties.valueOf(name));
    }
/*
    public static List<SubSpecialty> validateSubSpecialtySet(List<SubSpecialty> subSpecialties) {
        if (subSpecialties == null || subSpecialties.isEmpty()) return List.of(new SubSpecialty(SubSpecialties.GENERAL));
        return subSpecialties;
    }
*/
}
