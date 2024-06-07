package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateTreatmentCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;


@Getter
@Entity
public class Treatment extends AuditableAbstractAggregateRoot<Treatment> {
    private String description;

    public Treatment(){
    }

    public Treatment(String description){
        this.description = description;
    }

    public Treatment(CreateTreatmentCommand command){
        this.description = command.description();
    }

    public Treatment updateInformation (String description){
        this.description = description;
        return this;
    }
}
