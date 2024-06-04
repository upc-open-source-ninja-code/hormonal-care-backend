package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePrescriptionCommand;
import com.acme.hormonalcare.backend.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
@Getter
@Entity
public class Prescription extends AuditableModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne

    @JoinColumn(name = "medical_record_id")
    private Long medicalRecord;


    //@Column (nullable = false)
    @JoinColumn(name = "doctor_id")
    private Long doctorId;


    //@Column (nullable = false)
    @JoinColumn(name = "patient_id")
    private Long patientId;

    private Date prescriptionDate;
    private String notes;

    public Prescription() {
    }

    public Prescription(Long medicalRecord, Date prescriptionDate, Long doctorId, Long patientId, String notes) {
        this.medicalRecord = medicalRecord;
        this.prescriptionDate = prescriptionDate;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.notes = notes;
    }
    public Prescription(CreatePrescriptionCommand command) {
        //this.medicalRecord = command.medicalRecord();
        this.prescriptionDate = command.prescriptionDate();
        //this.doctorId = command.doctorId();
        //this.patientId = command.patientId();
        this.notes = command.notes();
    }


}