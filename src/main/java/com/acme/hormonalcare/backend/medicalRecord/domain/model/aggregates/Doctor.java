package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDoctorCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;



@Getter
@Entity
public class Doctor extends AuditableAbstractAggregateRoot<Doctor> {

    @Embedded
    private ProfessionalIdentificationNumber professionalIdentificationNumber;

    @Embedded
    private SubSpecialty subSpecialty;

    @Embedded
    private Certification certification;

    private String appointmentFee;

    @Embedded
    private CodeDoctor codeDoctor;

    private String subscriptionId;

    @Embedded
    private ProfileId profileId;

    public Doctor(ProfessionalIdentificationNumber professionalIdentificationNumber, SubSpecialty subSpecialty, Certification certification, String appointmentFee, String subscriptionId, Long profileId) {
        this.professionalIdentificationNumber = professionalIdentificationNumber;
        this.subSpecialty = subSpecialty;
        this.certification = certification;
        this.appointmentFee = appointmentFee;
        this.subscriptionId = subscriptionId;
        this.codeDoctor = new CodeDoctor(generateCodeDoctor());
        this.profileId = new ProfileId(profileId);
    }

    public Doctor(CreateDoctorCommand command){
        this.professionalIdentificationNumber = new ProfessionalIdentificationNumber(command.professionalIdentificationNumber());
        this.subSpecialty = new SubSpecialty(command.subSpecialty());
        this.certification = new Certification(command.certification());
        this.appointmentFee = command.appointmentFee();
        this.subscriptionId = command.subscriptionId();
        this.codeDoctor = new CodeDoctor(generateCodeDoctor());
        this.profileId = new ProfileId(command.profileId());
    }

    public Doctor() {
    }

    public Doctor(Long profileId){
        this();
        this.profileId = new ProfileId(profileId);
    }

    public Doctor(ProfileId profileId){
        this();
        this.profileId = profileId;
    }

    public Doctor updateAppointmentFee(String appointmentFee){
        this.appointmentFee = appointmentFee;
        return this;
    }

    public Doctor updateSubscriptionId(String subscriptionId){
        this.subscriptionId = subscriptionId;
        return this;
    }



    private String generateCodeDoctor(){
        return "D" + System.currentTimeMillis();
    }



}
