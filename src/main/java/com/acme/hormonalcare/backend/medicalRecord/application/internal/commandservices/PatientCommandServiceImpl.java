package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Patient;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePatientCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePatientCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.PatientCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PatientCommandServiceImpl implements PatientCommandService {
    private final PatientRepository patientRepository;

    public PatientCommandServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Optional<Patient> handle(CreatePatientCommand command) {
        var patient = new Patient(command);
        patientRepository.save(patient);
        return Optional.of(patient);
    }

    @Override
    public Optional<Patient> handle(UpdatePatientCommand command){
        var id = command.id();
        if (!patientRepository.existsById(id)) {
            throw new IllegalArgumentException("Patient with id "+ command.id() +"does not exists");
        }
        var result = patientRepository.findById(id);
        var patientToUpdate = result.get();
        try {
            var updatedPatient = patientRepository.save(patientToUpdate.updateInformation(command.typeofblood()));
            return Optional.of(updatedPatient);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating patient: " + e.getMessage());
        }
    }

}
