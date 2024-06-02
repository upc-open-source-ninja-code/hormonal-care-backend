package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.*;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;

public record CreateDoctorCommand(String firstname, String lastname, int age, int phoneNumber, PhotoProfile photoProfile,
                                  ProfessionalIdentificationNumber professionalIdentificationNumber, GraduationInstitution graduationInstitution,
                                  GraduationYear graduationYear, AppointmentFee appointmentFee) {
}