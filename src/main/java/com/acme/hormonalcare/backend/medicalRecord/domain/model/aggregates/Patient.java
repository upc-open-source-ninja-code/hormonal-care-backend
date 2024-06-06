package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePatientCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Patient extends AuditableAbstractAggregateRoot<Patient> {

    private String typeofblood;

    public Patient() {
        this.typeofblood = "";
    }
    public Patient(String typeofblood) {

        this.typeofblood = typeofblood;
    }
    public Patient(CreatePatientCommand command) {

        this.typeofblood = command.typeofblood();
    }
    public Patient updateInformation(String typeofblood) {
        this.typeofblood = typeofblood;
        return this;
    }
}
