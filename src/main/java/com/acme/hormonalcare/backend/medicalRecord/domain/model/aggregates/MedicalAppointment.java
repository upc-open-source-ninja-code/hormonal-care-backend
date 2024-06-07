package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalAppointmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class MedicalAppointment extends AuditableAbstractAggregateRoot<MedicalAppointment> {

    @Embedded
    private EventDate eventDate;
    @Embedded
    private StartTime startTime;
    @Embedded
    private EndTime endTime;

    private String title;

    private String description;

    @Embedded
    private PatientEmail patientEmail;
    @Embedded
    private DoctorEmail doctorEmail;

    public MedicalAppointment() {
    }

    public MedicalAppointment(EventDate eventDate, StartTime startTime, EndTime endTime, String title, String description, PatientEmail patientEmail, DoctorEmail doctorEmail) {
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.description = description;
        this.patientEmail = patientEmail;
        this.doctorEmail = doctorEmail;
    }

    public MedicalAppointment(CreateMedicalAppointmentCommand command) {
        this.eventDate = new EventDate(command.eventDate());
        this.startTime = new StartTime(command.startTime());
        this.endTime = new EndTime(command.endTime());
        this.title = command.title();
        this.description = command.description();
        this.patientEmail = new PatientEmail(command.patientEmail());
        this.doctorEmail = new DoctorEmail(command.doctorEmail());
    }

    public MedicalAppointment updateInformation(LocalDate eventDate, String startTime, String endTime, String title, String description, String patientEmail, String doctorEmail) {
        this.eventDate = new EventDate(eventDate);
        this.startTime = new StartTime(startTime);
        this.endTime = new EndTime(endTime);
        this.title = title;
        this.description = description;
        this.patientEmail = new PatientEmail(patientEmail);
        this.doctorEmail = new DoctorEmail(doctorEmail);
        return this;
    }
}
