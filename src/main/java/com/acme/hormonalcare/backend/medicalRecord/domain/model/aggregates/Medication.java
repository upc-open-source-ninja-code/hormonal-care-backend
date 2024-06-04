/*package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationCommand;
//import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.MedicationType;
//import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Prescription;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;
import com.acme.hormonalcare.backend.profiles.domain.model.valueobjects.StreetAddress;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.*;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import lombok.Getter;
@Getter
@Entity
public class Medication extends AuditableAbstractAggregateRoot<Medication> {
/*
    // @ManyToOne
    @Getter
    @JoinColumn(name = "medical_record_id")
    private Long medicalRecord;

    @Getter
    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @Getter
    @ManyToOne
    @JoinColumn(name = "medication_type_id")
    private MedicationType medicationType;
*/

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "name")) })
    private DrugName drugName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "amount")),
        @AttributeOverride(name = "unitQ", column = @Column(name = "unitQ")) })
    private Quantity quantity;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "value_concentration")),
            @AttributeOverride(name = "unit", column = @Column(name = "unit_concentration")) })
    private Concentration concentration;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "timesPerDay", column = @Column(name = "timesPerDay"))})
    private Frequency frequency;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "timePeriod", column = @Column(name = "timePeriod"))})
    private Duration duration;

    public Medication() {
    }

    public Medication(CreateMedicationCommand command) {
        //this.medicalRecord = command.medicalRecordId();
        //this.prescription = command.prescriptionId();
        //this.medicationType = command.medicationTypeId();
        this.drugName = new DrugName(command.name());
        this.quantity = new Quantity(command.amount(), command.unitQ());
        this.concentration = new Concentration(command.value(), command.unit());
        this.frequency = new Frequency(command.timesPerDay());
        this.duration = new Duration(command.timePeriod());
    }


    public Medication(String name, int amount, String unitQ, int value_concentration, String unit_concentration, int timesPerDay, String timePeriod) {
       //this.medicalRecord = medicalRecord;
       //this.prescription = prescription;
       //this.medicationType = medicationType;
        this.drugName = new DrugName(name);
        this.quantity = new Quantity(amount, unitQ);
        this.concentration = new Concentration(value_concentration, unit_concentration);
        this.frequency = new Frequency(timesPerDay);
        this.duration = new Duration(timePeriod);
    }


      public String getDrugName() {return drugName.name();}
      public String getQuantity() {return quantity.amount() + " " + quantity.unitQ();}
     public String getConcentration() {return concentration.value_concentration() + " " + concentration.unit_concentration();}
      public String getFrequency() {return frequency.timesPerDay() + " times per day";}
      public String getDuration() {return duration.timePeriod();}

}*/




