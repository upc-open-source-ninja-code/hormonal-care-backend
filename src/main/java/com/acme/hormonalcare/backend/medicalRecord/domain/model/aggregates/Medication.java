package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.*;
@Entity
public class Medication extends AuditableAbstractAggregateRoot<Medication> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;

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


    public Medication(CreateMedicationCommand command) {
        this.medicalRecord = command.getMedicalRecord();
        this.prescription = command.getPrescription();
        this.medicationType = command.getMedicationType();
        this.drugName = new DrugName(command.getDrugName());
        this.quantity = new Quantity(command.getAmount(), command.getUnit());
        this.concentration = new Concentration(command.getValue(), command.getConcentrationUnit());
        this.frequency = new Frequency(command.getTimesPerDay());
        this.duration = new Duration(command.getDuration());
    }

    public medication() {

    }

    public medication(MedicalRecord medicalRecord, Prescription prescription, MedicationType medicationType, DrugName drugName, Quantity quantity, Concentration concentration, Frequency frequency, Duration duration) {
        this.medicalRecord = medicalRecord;
        this.prescription = prescription;
        this.medicationType = medicationType;
        this.drugName = drugName;
        this.quantity = quantity;
        this.concentration = concentration;
        this.frequency = frequency;
        this.duration = duration;
    }

    // Métodos de actualización
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
        return drugName.getDrugName();
    }

    public int getAmount() {
        return quantity.getAmount();
    }
    public String getUnit() {
        return quantity.getUnit();
    }
    public int getValue() {
        return concentration.getValue();
    }
    public String getConcentrationUnit() {
        return concentration.getConcentrationUnit();
    }
    public int getTimesPerDay() {
        return frequency.getTimesPerDay();
    }
    public String getDuration() {
        return duration.getTimePeriod();
    }

}


