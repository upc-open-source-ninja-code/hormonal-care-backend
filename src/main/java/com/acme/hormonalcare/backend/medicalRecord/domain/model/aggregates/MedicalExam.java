package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalExamCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class MedicalExam extends AuditableAbstractAggregateRoot<MedicalExam> {
    private String name;

    @Getter
    @ManyToOne
    @JoinColumn(name = "typeExam_id",referencedColumnName = "id" )
    private TypeExam typeExam;

    public MedicalExam() {
    }
    
    public MedicalExam(String name, Long typeExam) {
        this.name = name;
    }

    public MedicalExam(CreateMedicalExamCommand command, TypeExam typeExam) {
        this.name = command.name();
        this.typeExam = typeExam;
    }



}
