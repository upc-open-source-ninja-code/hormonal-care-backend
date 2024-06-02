package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.*;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private PersonName name;
    private int age;
    private int phoneNumber;
    private PhotoProfile photoProfile;
    private ProfessionalIdentificationNumber professionalIdentificationNumber;
    @Getter
    private List<Specialty> specialties;
    @Getter
    private List<SubSpecialty> subSpecialties;
    private GraduationInstitution graduationInstitution;
    private GraduationYear graduationYear;
    @Getter
    private List<AdditionalCertifications> additionalCertifications;
    @Getter
    private DoctorCode doctorCode;
    private AppointmentFee appointmentFee;

    public Doctor(String firstname, String lastname, int age, int phoneNumber, PhotoProfile photoProfile,
                  ProfessionalIdentificationNumber professionalIdentificationNumber, GraduationInstitution graduationInstitution,
                  GraduationYear graduationYear, AppointmentFee appointmentFee) {
        this.name = new PersonName(firstname, lastname);
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.photoProfile = photoProfile;
        this.professionalIdentificationNumber = professionalIdentificationNumber;
        this.graduationInstitution = graduationInstitution;
        this.graduationYear = graduationYear;
        this.appointmentFee = appointmentFee;
        this.doctorCode = DoctorCode.create();
        this.additionalCertifications = new ArrayList<>();
        this.specialties = new ArrayList<>();
        this.subSpecialties = new ArrayList<>();
    }

    public void updateName(String firstName, String lastName) {
        this.name = new PersonName(firstName, lastName);
    }

    public void updateAge(int age) {
        this.age = age;
    }

    public void updatePhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updatePhotoProfile(PhotoProfile photoProfile) {
        this.photoProfile = photoProfile;
    }

    public void updateProfessionalIdentificationNumber(ProfessionalIdentificationNumber professionalIdentificationNumber) {
        this.professionalIdentificationNumber = professionalIdentificationNumber;
    }

    public void updateGraduationInstitution(GraduationInstitution graduationInstitution) {
        this.graduationInstitution = graduationInstitution;
    }

    public void updateGraduationYear(GraduationYear graduationYear) {
        this.graduationYear = graduationYear;
    }

    public void updateAppointmentFee(AppointmentFee appointmentFee) {
        this.appointmentFee = appointmentFee;
    }

    public void addAdditionalCertification(AdditionalCertifications additionalCertification) {
        this.additionalCertifications.add(additionalCertification);
    }

    public void addSpecialty(Specialty specialty) {
        this.specialties.add(specialty);
    }

    public void addSubSpecialty(SubSpecialty subSpecialty) {
        this.subSpecialties.add(subSpecialty);
    }

    public String getFullName() {
        return name.getFullName();
    }

}