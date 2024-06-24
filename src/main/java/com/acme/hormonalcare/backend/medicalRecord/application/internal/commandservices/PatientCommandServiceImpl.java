package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;
import com.acme.hormonalcare.backend.medicalRecord.application.internal.outboundservices.acl.ExternalProfileService;
import com.acme.hormonalcare.backend.medicalRecord.domain.events.PatientCreatedEvent;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Doctor;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Patient;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreatePatientCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePatientCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdatePatientDoctorIdCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.PatientCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.DoctorRepository;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.PatientRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PatientCommandServiceImpl implements PatientCommandService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final ExternalProfileService externalProfileService;
    private final ApplicationEventPublisher eventPublisher;

    public PatientCommandServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository, ExternalProfileService externalProfileService, ApplicationEventPublisher eventPublisher) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.externalProfileService = externalProfileService;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Optional<Patient> handle(CreatePatientCommand command) {

        Long doctorId = command.doctorId();
        if (doctorId == null || doctorId == 0) {
            doctorId = null;
        } else if (!doctorRepository.existsById(doctorId)) {
            throw new IllegalArgumentException("Doctor with id " + doctorId + " does not exist");
        }
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
                    command.birthday(),
                    command.userId());
        } else{
            patientRepository.findByProfileId(profileId.get()).ifPresent(patient -> {
                throw new IllegalArgumentException("Patient already exists");
            });
            doctorRepository.findByProfileId(profileId.get()).ifPresent(doctor -> {
                throw new IllegalArgumentException("Doctor already exists");
            });

        }
        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");


        var patient = new Patient(profileId.get(),command.typeofblood(), doctorId);
        patientRepository.save(patient);
        eventPublisher.publishEvent(new PatientCreatedEvent(patient.getId()));
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

    @Override
    public Optional<Patient> handle(UpdatePatientDoctorIdCommand command){
        var id = command.id();
        if (!patientRepository.existsById(id)) {
            throw new IllegalArgumentException("Patient with id "+ command.id() +"does not exists");
        }
        var result = patientRepository.findById(id);
        var patientToUpdate = result.get();
        try {
            Long doctorId = command.doctorId();
            if (doctorId == null || doctorId == 0) {
                doctorId = null;
            } else if (!doctorRepository.existsById(doctorId)) {
                throw new IllegalArgumentException("Doctor with id " + doctorId + " does not exist");
            }
            var updatedPatient = patientRepository.save(patientToUpdate.updateDoctorId(doctorId));
            return Optional.of(updatedPatient);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating patient: " + e.getMessage());
        }
    }


}
