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

    private Long appointmentFee;

    @Embedded
    private CodeDoctor codeDoctor;

    private Long subscriptionId;

    @Embedded
    private ProfileId profileId;

    @Embedded
    @Column(name = "doctorRecord_id")
    private  DoctorRecordId doctorRecordId;


    public Doctor() {

    }


    public Doctor(
            ProfessionalIdentificationNumber professionalIdentificationNumber,
            SubSpecialty subSpecialty,
            Certification certification,
            Long appointmentFee,
            Long subscriptionId,
            Long profileId
    ) {
        this.professionalIdentificationNumber = professionalIdentificationNumber;
        this.subSpecialty = subSpecialty;
        this.certification = certification;
        this.appointmentFee = appointmentFee;
        this.subscriptionId = subscriptionId;
        this.codeDoctor = new CodeDoctor(generateCodeDoctor());
        this.profileId = new ProfileId(profileId);
        this.doctorRecordId = new DoctorRecordId();
    }

    public Doctor(
            ProfessionalIdentificationNumber professionalIdentificationNumber,
            SubSpecialty subSpecialty,
            Certification certification,
            Long appointmentFee,
            Long subscriptionId,
            ProfileId profileId
    ) {
        this.professionalIdentificationNumber = professionalIdentificationNumber;
        this.subSpecialty = subSpecialty;
        this.certification = certification;
        this.appointmentFee = appointmentFee;
        this.subscriptionId = subscriptionId;
        this.codeDoctor = new CodeDoctor(generateCodeDoctor());
        this.profileId = profileId;
        this.doctorRecordId = new DoctorRecordId();
    }

    public Doctor(CreateDoctorCommand command, ProfileId profileId){
        this.professionalIdentificationNumber = new ProfessionalIdentificationNumber(command.professionalIdentificationNumber());
        this.subSpecialty = new SubSpecialty(command.subSpecialty());
        this.certification = new Certification(command.certification());
        this.appointmentFee = command.appointmentFee();
        this.subscriptionId = command.subscriptionId();
        this.codeDoctor = new CodeDoctor(generateCodeDoctor());
        this.profileId =profileId;
        this.doctorRecordId = new DoctorRecordId();
    }


    public Doctor updateAppointmentFee(Long appointmentFee){
        this.appointmentFee = appointmentFee;
        return this;
    }

    public Doctor updateSubscriptionId(Long subscriptionId){
        this.subscriptionId = subscriptionId;
        return this;
    }

    private String generateCodeDoctor(){
        return "D" + System.currentTimeMillis();
    }

    public Long getProfileId() {
        return this.profileId.profileId();
    }

    public  String getDoctorRecordId() {
        return this.doctorRecordId.doctorRecordId();
    }


}
