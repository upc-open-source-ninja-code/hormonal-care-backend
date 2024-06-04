package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class MedicalAppointment extends AuditableAbstractAggregateRoot<MedicalAppointment>{
    private long idPatient; //Patient entity
    private long idDoctor; //Doctor entity
    private long idMedicalRecord; //MedicalRecord entity

    private String title;
    private String description;

    private String date;
    private String startTime;
    private String endTime;

    private String createdBy; //VO
    private String meetingLink; //VO
    private boolean paymentStatus; //
}
