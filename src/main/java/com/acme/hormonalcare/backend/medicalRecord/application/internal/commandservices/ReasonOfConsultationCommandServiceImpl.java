package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateReasonOfConsultationCommand;
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
        return Optional.empty();
    }
}
