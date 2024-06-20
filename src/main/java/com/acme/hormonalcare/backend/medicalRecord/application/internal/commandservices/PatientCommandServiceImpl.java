package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;
import com.acme.hormonalcare.backend.medicalRecord.application.internal.outboundservices.acl.ExternalProfileService;
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
    private final ExternalProfileService externalProfileService;

    public PatientCommandServiceImpl(PatientRepository patientRepository, ExternalProfileService externalProfileService) {
        this.patientRepository = patientRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<Patient> handle(CreatePatientCommand command) {

        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());
        if (profileId.isEmpty()){
            profileId = externalProfileService.createProfile(
                    command.firstName(),
                    command.lastName(),
                    command.gender(),
                    command.age(),
                    command.phoneNumber(),
                    command.email(),
                    command.Image(),
                    command.birthday());
        } else{
            patientRepository.findByProfileId(profileId.get()).ifPresent(patient -> {
                throw new IllegalArgumentException("Patient already exists");
            });

        }
        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");



        var patient = new Patient(profileId.get(),command.typeofblood());
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
