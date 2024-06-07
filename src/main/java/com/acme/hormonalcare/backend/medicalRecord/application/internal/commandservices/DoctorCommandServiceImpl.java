package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Doctor;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDoctorCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDoctorAppointmentFeeCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDoctorSubscriptionCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DoctorCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorCommandServiceImpl implements DoctorCommandService {

    private final DoctorRepository doctorRepository;

    public DoctorCommandServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Optional<Doctor> handle(CreateDoctorCommand command) {
        var doctor = new Doctor(command);
        doctorRepository.save(doctor);
        return Optional.of(doctor);
    }

    @Override
    public Optional<Doctor> handle(UpdateDoctorAppointmentFeeCommand command) {
        var id = command.id();
        if (!doctorRepository.existsById(id))
            throw new IllegalArgumentException("Doctor with id "+ id +" does not exist");
        var result = doctorRepository.findById(id);
        var doctorToUpdate = result.get();
        try{
            var updatedDoctor = doctorRepository.save(doctorToUpdate.updateSubscriptionId(command.appointmentFee()));
            return Optional.of(updatedDoctor);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating doctor with id "+ id);
        }
    }

    @Override
    public Optional<Doctor> handle(UpdateDoctorSubscriptionCommand command) {
        var id = command.id();
        if (!doctorRepository.existsById(id))
            throw new IllegalArgumentException("Doctor with id "+ id +" does not exist");
        var result = doctorRepository.findById(id);
        var doctorToUpdate = result.get();
        try{
            var updatedDoctor = doctorRepository.save(doctorToUpdate.updateSubscriptionId(command.subscriptionId()));
            return Optional.of(updatedDoctor);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating doctor with id "+ id);
        }
    }

}


/*
@Override
    public Optional<Treatment> handle(CreateTreatmentCommand command) {
        var treatment = new Treatment(command);
        treatmentRepository.save(treatment);
        return Optional.of(treatment);
    }

    @Override
    public Optional<Treatment> handle(UpdateTreatmentCommand command) {
        var id = command.id();
        if (!treatmentRepository.existsById(id))
            throw new IllegalArgumentException("Treatment with id "+ id +" does not exist");
        var result = treatmentRepository.findById(id);
        var treatmentToUpdate = result.get();
        try{
            var updatedTreatment = treatmentRepository.save(treatmentToUpdate.updateInformation(command.description()));
            return Optional.of(updatedTreatment);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating treatment with id "+ id);
        }
    }
 */