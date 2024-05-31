package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.MedicationType;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Prescription;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.*;
@Entity
public class Medication extends AuditableAbstractAggregateRoot<Medication> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @ManyToOne
    @JoinColumn(name = "medical_record_id")
    private Long medicalRecord;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @ManyToOne
    @JoinColumn(name = "medication_type_id")
    private MedicationType medicationType;

    @Embedded
    private DrugName drugName;

    @Embedded
    private Quantity quantity;

    @Embedded
    private Concentration concentration;

    @Embedded
    private Frequency frequency;

    @Embedded
    private Duration duration;

    public  Medication() {
    }

    public Medication(CreateMedicationCommand command) {
        this.medicalRecord = command.medicalRecord();
        this.prescription = command.prescription();
        this.medicationType = command.medicationType();
        this.drugName = new DrugName(command.drugName().name());
        this.quantity = new Quantity(command.quantity().amount(), command.quantity().unit());
        this.concentration = new Concentration(command.concentration().value(), command.concentration().unit());
        this.frequency = new Frequency(command.frequency().timesPerDay());
        this.duration = new Duration(command.duration().timePeriod());
    }


    public Medication(Long medicalRecord, Prescription prescription, MedicationType medicationType, DrugName drugName, Quantity quantity, Concentration concentration, Frequency frequency, Duration duration) {
        this.medicalRecord = medicalRecord;
        this.prescription = prescription;
        this.medicationType = medicationType;
        this.drugName = drugName;
        this.quantity = quantity;
        this.concentration = concentration;
        this.frequency = frequency;
        this.duration = duration;
    }

    public void updateDrugName(String drugName) {
        this.drugName = new DrugName(drugName);
    }

    public void updateQuantity(int amount, String unit) {
        this.quantity = new Quantity(amount, unit);
    }

    public void updateConcentration(int value, String unit) {
        this.concentration = new Concentration(value, unit);
    }

    public void updateFrequency(int timesPerDay) {
        this.frequency = new Frequency(timesPerDay);
    }

    public void updateDuration(String timePeriod) {
        this.duration = new Duration(timePeriod);
    }

    public String getDrugName() {
        return drugName.name();
    }

    public int getAmount() {return quantity.amount();}

    public String getUnit() {
        return quantity.unit();
    }

    public int getValue() {
        return concentration.value();
    }

    public String getConcentrationUnit() {return concentration.unit();}

    public int getTimesPerDay() {
        return frequency.timesPerDay();
    }

    public String getDuration() {return duration.timePeriod();}

}


