package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateTypeExamCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class TypeExam extends AuditableAbstractAggregateRoot<ReasonOfConsultation> {
    private String name;

    public TypeExam() {
    }
    public TypeExam(String name) {
        this.name = name;
    }
    public TypeExam(CreateTypeExamCommand command) {
        this.name = command.name();
    }
}
