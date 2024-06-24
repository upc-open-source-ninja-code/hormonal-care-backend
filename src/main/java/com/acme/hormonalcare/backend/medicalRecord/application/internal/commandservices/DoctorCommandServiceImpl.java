package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.application.internal.outboundservices.acl.ExternalProfileService;
import com.acme.hormonalcare.backend.medicalRecord.domain.events.DoctorCreatedEvent;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Doctor;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDoctorCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDoctorCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.Certification;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.ProfessionalIdentificationNumber;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.SubSpecialty;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DoctorCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.DoctorRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorCommandServiceImpl implements DoctorCommandService {

    private final DoctorRepository doctorRepository;
    private final ExternalProfileService externalProfileService;
    private final ApplicationEventPublisher eventPublisher;

    public DoctorCommandServiceImpl(DoctorRepository doctorRepository, ExternalProfileService externalProfileService, ApplicationEventPublisher eventPublisher) {
        this.doctorRepository = doctorRepository;
        this.externalProfileService = externalProfileService;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Optional<Doctor> handle(CreateDoctorCommand command) {
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
            doctorRepository.findByProfileId(profileId.get()).ifPresent(doctor -> {
                throw new IllegalArgumentException("Doctor already exists");
            });
        }
        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        var doctor = new Doctor(
                new ProfessionalIdentificationNumber(command.professionalIdentificationNumber()),
                new SubSpecialty(command.subSpecialty()),
                new Certification(command.certification()),
                command.appointmentFee(),
                command.subscriptionId(),
                profileId.get()
        );
        doctorRepository.save(doctor);
        eventPublisher.publishEvent(new DoctorCreatedEvent(doctor.getId()));
        return Optional.of(doctor);
    }

    @Override
    public Optional<Doctor> handle(UpdateDoctorCommand command) {
        var id = command.id();
        if (!doctorRepository.existsById(id))
            throw new IllegalArgumentException("Doctor with id "+ id +" does not exist");
        var result = doctorRepository.findById(id);
        var doctorToUpdate = result.get();
        try{
            var updatedDoctor = doctorRepository.save(doctorToUpdate.updateInformation(command.appointmentFee(), command.subscriptionId()));
            return Optional.of(updatedDoctor);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating doctor with id "+ id);
        }
    }


}


