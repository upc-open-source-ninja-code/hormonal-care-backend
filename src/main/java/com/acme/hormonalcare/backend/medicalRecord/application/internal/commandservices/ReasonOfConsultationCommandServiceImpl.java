package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateReasonOfConsultationCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateReasonOfConsultationCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.ReasonOfConsultationCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.ReasonOfConsultationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReasonOfConsultationCommandServiceImpl implements ReasonOfConsultationCommandService {

    private final ReasonOfConsultationRepository reasonOfConsultationRepository;

    public ReasonOfConsultationCommandServiceImpl(ReasonOfConsultationRepository reasonOfConsultationRepository) {
        this.reasonOfConsultationRepository = reasonOfConsultationRepository;
    }

    @Override
    public Optional<ReasonOfConsultation> handle(CreateReasonOfConsultationCommand command) {
        var reasonOfConsultation = new ReasonOfConsultation(command);
        reasonOfConsultationRepository.save(reasonOfConsultation);
        return Optional.of(reasonOfConsultation);
    }

    @Override
    public Optional<ReasonOfConsultation> handle(UpdateReasonOfConsultationCommand command) {
        var id = command.id();
        if (!reasonOfConsultationRepository.existsById(id)) {
            throw new IllegalArgumentException("ReasonOfConsultation with id "+ command.id() +"does not exists");
        }
        var result = reasonOfConsultationRepository.findById(id);
        var reasonOfConsultationToUpdate = result.get();
        try {
            var updatedReasonOfConsultation = reasonOfConsultationRepository.save(reasonOfConsultationToUpdate.updateInformation(command.description(),command.symptoms()));
            return Optional.of(updatedReasonOfConsultation);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating reasonOfConsultation: " + e.getMessage());
        }

    }
}
