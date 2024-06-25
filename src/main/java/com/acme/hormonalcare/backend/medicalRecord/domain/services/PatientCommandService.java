package com.acme.hormonalcare.backend.medicalRecord.domain.services;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Patient;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePatientCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePatientCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePatientDoctorIdCommand;

import java.util.Optional;

public interface PatientCommandService {
    Optional<Patient> handle(CreatePatientCommand command);
    Optional<Patient> handle(UpdatePatientCommand command);
    Optional<Patient> handle(UpdatePatientDoctorIdCommand command);
}
