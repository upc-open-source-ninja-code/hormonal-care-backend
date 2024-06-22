package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDiagnoseCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;


@Getter
@Entity

public class Diagnose extends AuditableAbstractAggregateRoot<Diagnose>{
    private String description;

    public Diagnose(){
    }

    public Diagnose(String description){
        this.description = description;
    }
    public Diagnose(CreateDiagnoseCommand command){
        this.description = command.description();
    }
    public Diagnose UpdateInformation(String description){
        this.description = description;
        return this;
    }
}
