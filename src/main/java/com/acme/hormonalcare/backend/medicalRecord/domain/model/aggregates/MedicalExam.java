package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalExamCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
@Getter
@Entity
public class MedicalExam extends AuditableAbstractAggregateRoot<ReasonOfConsultation> {
    private String name;
    @Getter
    @ManyToOne
    @JoinColumn(name = "typeExam_id", )
    private TypeExam typeExam;

    public MedicalExam() {
    }
    
    public MedicalExam(String name, TypeExam typeExam) {
        this.name = name;
        this.typeExam = typeExam;
    }

    public MedicalExam(CreateMedicalExamCommand command) {
        this.name = command.name();
        this.typeExam = command.typeExamId();

    }

}
