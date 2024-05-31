package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateReasonOfConsultationCommand;

import java.util.Optional;

public interface ReasonOfConsultationCommandService {
    Optional<ReasonOfConsultation> handle(CreateReasonOfConsultationCommand command);
}
