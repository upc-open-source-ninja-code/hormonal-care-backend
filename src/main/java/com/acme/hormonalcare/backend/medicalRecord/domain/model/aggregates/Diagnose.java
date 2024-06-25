package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDiagnoseCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;


@Getter
@Entity

public class Diagnose extends AuditableAbstractAggregateRoot<Diagnose>{
    private String description;

    @Getter
    @ManyToOne
    @JoinColumn(name = "medicalRecord_id",referencedColumnName = "id" )
    private MedicalRecord medicalRecord;

    public Diagnose(){
    }

    public Diagnose(String description, Long medicalRecord){

        this.description = description;
    }
    public Diagnose(CreateDiagnoseCommand command, MedicalRecord medicalRecord){

        this.description = command.description();
        this.medicalRecord = medicalRecord;
    }
    public Diagnose updateInformation(String description, MedicalRecord medicalRecord){
        this.description = description;
        this.medicalRecord = medicalRecord;
        return this;
    }
}