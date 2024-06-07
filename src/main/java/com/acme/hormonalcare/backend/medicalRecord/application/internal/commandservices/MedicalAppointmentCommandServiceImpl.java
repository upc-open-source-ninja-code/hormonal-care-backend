package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalAppointment;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalAppointmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicalAppointmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalAppointmentCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicalAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalAppointmentCommandServiceImpl implements MedicalAppointmentCommandService {


    private final MedicalAppointmentRepository medicalAppointmentRepository;

    public MedicalAppointmentCommandServiceImpl(MedicalAppointmentRepository medicalAppointmentRepository) {

        this.medicalAppointmentRepository = medicalAppointmentRepository;
    }

    @Override
    public Optional<MedicalAppointment> handle(CreateMedicalAppointmentCommand command) {
        var medicalAppointment = new MedicalAppointment(command);
        medicalAppointmentRepository.save(medicalAppointment);
        return Optional.of(medicalAppointment);
    }

    @Override
    public Optional<MedicalAppointment> handle(UpdateMedicalAppointmentCommand command) {
        var id = command.id();
        if(!medicalAppointmentRepository.existsById(id))
            throw new IllegalArgumentException("MedicalAppointment with id "+ id +" does not exist");
        var result = medicalAppointmentRepository.findById(id);
        var medicalAppointmentToUpdate = result.get();
        try{
            var updatedMedicalAppointment = medicalAppointmentRepository.save(medicalAppointmentToUpdate.updateInformation
                    (
                            command.eventDate(),
                            command.startTime(),
                            command.endTime(),
                            command.title(),
                            command.description(),
                            command.patientEmail(),
                            command.doctorEmail()
                    ));
            return Optional.of(updatedMedicalAppointment);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating medicalAppointment with id "+ id);
        }
    }
}
