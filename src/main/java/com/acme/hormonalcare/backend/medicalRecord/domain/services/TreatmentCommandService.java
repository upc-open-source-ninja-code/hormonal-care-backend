package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Treatment;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateTreatmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateTreatmentCommand;

import java.util.Optional;

public interface TreatmentCommandService {
    Optional<Treatment> handle(CreateTreatmentCommand command);
    Optional<Treatment> handle(UpdateTreatmentCommand command);
}
