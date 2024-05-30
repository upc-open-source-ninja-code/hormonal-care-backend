package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;


import com.acme.hormonalcare.backend.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class MedicationType extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String typeName;

    public MedicationType() {
    }

    public MedicationType(String typeName) {
        this.typeName = typeName;
    }

    public void updateTypeName(String typeName) {
        this.typeName = typeName;
    }

}