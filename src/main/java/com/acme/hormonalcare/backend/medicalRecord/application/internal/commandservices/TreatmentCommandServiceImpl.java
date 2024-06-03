package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Treatment;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateTreatmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateTreatmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.TreatmentCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreatmentCommandServiceImpl implements TreatmentCommandService {
    private final TreatmentRepository treatmentRepository;

    public TreatmentCommandServiceImpl(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

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
}
