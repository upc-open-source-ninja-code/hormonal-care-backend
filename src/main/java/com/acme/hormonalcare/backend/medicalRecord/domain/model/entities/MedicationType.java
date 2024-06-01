package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;


import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationTypeCommand;
import com.acme.hormonalcare.backend.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
public class MedicationType extends AuditableModel {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String typeName;

    public MedicationType() {
    }
    public MedicationType(CreateMedicationTypeCommand command) {
        this.typeName = command.typeName();
    }
    public MedicationType(String typeName) {
        this.typeName = typeName;
    }

    public void updateTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return typeName;
    }
}