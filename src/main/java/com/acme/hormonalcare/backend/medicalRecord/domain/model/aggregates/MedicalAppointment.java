package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalAppointmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class MedicalAppointment extends AuditableAbstractAggregateRoot<MedicalAppointment> {

    private LocalDate eventDate;

    private String startTime;

    private String endTime;

    private String title;

    private String description;

    @Getter
    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id" )
    private Patient patient;


    @Getter
    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id" )
    private Doctor doctor;



    public MedicalAppointment() {
    }

    public MedicalAppointment(LocalDate eventDate, String startTime, String endTime, String title, String description, Patient patient  ,  Doctor doctor) {
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.description = description;
        this.patient = patient;
        this.doctor = doctor;
    }

    public MedicalAppointment(CreateMedicalAppointmentCommand command, Patient patient  ,  Doctor doctor) {
        this.eventDate = command.eventDate();
        this.startTime = command.startTime();
        this.endTime = command.endTime();
        this.title = command.title();
        this.description = command.description();
        this.patient = patient;
        this.doctor = doctor;
    }

    public MedicalAppointment updateInformation(LocalDate eventDate, String startTime, String endTime, String title, String description, Patient patient  ,  Doctor doctor) {
        this.eventDate =  eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.description = description;
        this.patient = patient;
        this.doctor = doctor;

        return this;
    }
}
