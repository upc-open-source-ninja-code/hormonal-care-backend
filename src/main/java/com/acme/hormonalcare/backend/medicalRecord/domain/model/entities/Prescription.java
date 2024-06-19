package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePrescriptionCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePrescriptionCommand;
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


    //@Column (nullable = false)
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private Long doctorId;


    //@Column (nullable = false)
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private Long patientId;

    private Date prescriptionDate;
    private String notes;

    public Prescription() {
    }

    public Prescription( Date prescriptionDate, Long doctorId, Long patientId, String notes) {
        this.prescriptionDate = prescriptionDate;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.notes = notes;
    }
    public Prescription(CreatePrescriptionCommand command) {
        this.prescriptionDate = command.prescriptionDate();
        this.notes = command.notes();
    }

    public Prescription updateInformation(UpdatePrescriptionCommand command) {
        this.prescriptionDate = command.prescriptionDate();
        this.notes = command.notes();
        return this;
    }


}