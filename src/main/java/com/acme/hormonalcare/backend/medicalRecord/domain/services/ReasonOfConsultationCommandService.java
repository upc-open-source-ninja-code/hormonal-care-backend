package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateReasonOfConsultationCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateReasonOfConsultationCommand;

import java.util.Optional;

public interface ReasonOfConsultationCommandService {
    Optional<ReasonOfConsultation> handle(CreateReasonOfConsultationCommand command);
    Optional<ReasonOfConsultation> handle(UpdateReasonOfConsultationCommand command);
}
