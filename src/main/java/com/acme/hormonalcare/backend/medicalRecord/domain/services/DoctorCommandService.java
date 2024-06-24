package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Doctor;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDoctorCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDoctorCommand;

import java.util.Optional;

public interface DoctorCommandService {
    Optional<Doctor> handle(CreateDoctorCommand command);
    Optional<Doctor> handle(UpdateDoctorCommand command);
}
