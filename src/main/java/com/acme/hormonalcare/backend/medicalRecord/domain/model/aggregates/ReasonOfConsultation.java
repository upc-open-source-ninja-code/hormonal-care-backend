package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateReasonOfConsultationCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

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
}
