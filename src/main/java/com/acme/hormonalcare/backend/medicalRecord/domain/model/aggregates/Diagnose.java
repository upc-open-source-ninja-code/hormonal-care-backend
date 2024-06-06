package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDiagnoseCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;


@Getter
@Entity

public class Diagnose extends AuditableAbstractAggregateRoot<Diagnose>{
    private String diagnose;
    private String description;

    public Diagnose(){
        this.diagnose = Strings.EMPTY;
        this.description = Strings.EMPTY;
    }

    public Diagnose(String diagnose, String description){
        this();
        this.diagnose = diagnose;
        this.description = description;
    }
    public Diagnose(CreateDiagnoseCommand command){
        this();
        this.diagnose = command.diagnose();
        this.description = command.description();
    }

    public Diagnose updateInformation(String diagnose, String description){
        this.diagnose = diagnose;
        this.description = description;
        return this;
    }
}
