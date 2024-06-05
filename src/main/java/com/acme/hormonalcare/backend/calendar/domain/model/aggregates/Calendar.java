package com.acme.hormonalcare.backend.calendar.domain.model.aggregates;

import com.acme.hormonalcare.backend.calendar.domain.model.commands.CreateCalendarCommand;
import com.acme.hormonalcare.backend.calendar.domain.model.valueobjects.*;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class Calendar extends AuditableAbstractAggregateRoot<Calendar> {

    @Getter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "eventDate")) })
    private EventDate eventDate;

    @Getter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "time", column = @Column(name = "startTime")) })
    private StartTime startTime;

    @Getter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "time", column = @Column(name = "endTime")) })
    private EndTime endTime;

    @Getter
    @Column(name = "title")
    private String title;

    @Getter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "email", column = @Column(name = "patientEmail")) })
    private PatientEmail patientEmail;

    public Calendar() {
    }
    public Calendar(CreateCalendarCommand command) {
        this.eventDate = new EventDate(command.eventDate());
        this.startTime = new StartTime(command.startTime());
        this.endTime = new EndTime(command.endTime());
        this.title = command.title();
        this.patientEmail = new PatientEmail(command.patientEmail());
    }
    public Calendar(EventDate eventDate, StartTime startTime, EndTime endTime, String title, PatientEmail patientEmail) {
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.patientEmail = patientEmail;
    }
    public Calendar updateInformation (LocalDate eventDate, String startTime, String endTime, String title, String patientEmail) {
        this.eventDate = new EventDate(eventDate);
        this.startTime = new StartTime(startTime);
        this.endTime = new EndTime(endTime);
        this.title = title;
        this.patientEmail = new PatientEmail(patientEmail);
        return this;
    }

}