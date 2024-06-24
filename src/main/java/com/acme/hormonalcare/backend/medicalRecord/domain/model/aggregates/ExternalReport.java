package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateExternalReportCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateTreatmentCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class ExternalReport extends AuditableAbstractAggregateRoot<Treatment> {
    private String image;

    @Getter
    @ManyToOne
    @JoinColumn(name = "medicalRecord_id",referencedColumnName = "id" )
    private MedicalRecord medicalRecord;

    public ExternalReport(){
    }

    public ExternalReport(String image, Long medicalRecord){
        this.image = image;

    }

    public ExternalReport(CreateExternalReportCommand command, MedicalRecord medicalRecord){

        this.image = command.image();
        this.medicalRecord = medicalRecord;
    }

    public ExternalReport updateInformation (String image, MedicalRecord medicalRecord){
        this.image = image;
        this.medicalRecord = medicalRecord;
        return this;
    }
}
