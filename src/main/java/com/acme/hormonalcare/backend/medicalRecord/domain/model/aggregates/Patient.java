package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePatientCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.PatientRecordId;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.ProfileId;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import javax.print.Doc;

@Getter
@Entity
public class Patient extends AuditableAbstractAggregateRoot<Patient> {

    private String typeofblood;

    @Embedded
    @Column(name = "patientRecord_id")
    private final PatientRecordId patientRecordId;

    @Embedded
    private ProfileId profileId;

    @Getter
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Patient() {
        this.typeofblood = "";
        this.patientRecordId = new PatientRecordId();
        this.doctor = null;
    }
    public Patient(Long profileId, String typeofblood, Long doctor) {
        this.profileId = new ProfileId(profileId);
        this.typeofblood = typeofblood;
        this.patientRecordId = new PatientRecordId();
    }
    public Patient(ProfileId profileId, String typeofblood, Long doctor) {
        this.profileId = profileId;
        this.typeofblood = typeofblood;
        this.patientRecordId = new PatientRecordId();
    }

    public Patient(CreatePatientCommand command, ProfileId profileId, Doctor doctor) {
        this.typeofblood = command.typeofblood();
        this.profileId = profileId;
        this.patientRecordId = new PatientRecordId();
        this.doctor = doctor;
    }
    public Patient updateInformation(String typeofblood) {
        this.typeofblood = typeofblood;

        return this;
    }
    public Patient updateDoctorId(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }
    public String getPatientRecordId() {return this.patientRecordId.patientRecordId();}
    public Long getProfileId() {return this.profileId.profileId();}


}
