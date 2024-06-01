package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.AppointmentFee;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.PhotoProfile;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Specialty;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.SubSpecialty;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.PersonName;

public class Doctor {
    private PersonName name;
    private int age;
    private int phoneNumber;
    private PhotoProfile photoProfile;
    private ProfessionalIdentificationNumber professionalIdentificationNumber;
    private Specialty specialty;
    private SubSpecialty subSpecialty;
    private GraduationInstitution graduationInstitution;
    private GraduationYear graduationYear;
    private Certification certification;
    private DoctorCode doctorCode;
    private AppointmentFee appointmentFee;
}
