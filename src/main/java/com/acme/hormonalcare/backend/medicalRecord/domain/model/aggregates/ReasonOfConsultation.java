package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateReasonOfConsultationCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class ReasonOfConsultation extends AuditableAbstractAggregateRoot<ReasonOfConsultation> {
    private String description;

    private String symptoms;

    public ReasonOfConsultation() {
    }

    public ReasonOfConsultation(String description, String symptoms) {
        this.description = description;
        this.symptoms = symptoms;
    }

    public ReasonOfConsultation (CreateReasonOfConsultationCommand command) {
        this.description = command.description();
        this.symptoms = command.symptoms();
    }

    public ReasonOfConsultation updateInformation (String description, String symptoms) {
        this.description = description;
        this.symptoms = symptoms;
        return this;
    }

}
