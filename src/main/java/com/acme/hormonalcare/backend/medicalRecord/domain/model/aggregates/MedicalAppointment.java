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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "event_date")) })
    private EventDate eventDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "time", column = @Column(name = "start_time")) })
    private StartTime startTime;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "time", column = @Column(name = "end_time")) })
    private EndTime endTime;

    private String title;

    private String description;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "email", column = @Column(name = "patientEmail")) })
    private PatientEmail patientEmail;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "email", column = @Column(name = "doctorEmail")) })
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
