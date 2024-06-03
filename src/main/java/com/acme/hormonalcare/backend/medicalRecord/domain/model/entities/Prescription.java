/*package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;

import com.acme.hormonalcare.backend.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class Prescription extends AuditableModel {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;

    @Getter
    private Date prescriptionDate;
    @Getter
    @Column (nullable = false)
    private Long doctorId;
    @Getter
    @Column (nullable = false)
    private Long patientId;
    @Getter
    private String notes;

    public Prescription() {
    }

    public Prescription(MedicalRecord medicalRecord, Date prescriptionDate, Long doctorId, Long patientId, String notes) {
        this.medicalRecord = medicalRecord;
        this.prescriptionDate = prescriptionDate;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.notes = notes;
    }

    public void updateNotes(String notes) {
        this.notes = notes;
    }
    public void updatePrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }


}*/