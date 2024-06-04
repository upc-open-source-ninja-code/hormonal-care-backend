package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalExamCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;
@Getter
@Entity
public class MedicalExam extends AuditableAbstractAggregateRoot<ReasonOfConsultation> {
    private String name;

    public MedicalExam() {
    }
    public MedicalExam(String name) {
        this.name = name;
    }
    public MedicalExam(CreateMedicalExamCommand command) {
        this.name = command.name();
    }

}
