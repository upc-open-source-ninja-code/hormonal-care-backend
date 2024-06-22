package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Diagnose;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDiagnoseCommand;

import java.util.Optional;

public interface DiagnoseCommandService {
    Optional<Diagnose> handle(CreateDiagnoseCommand command);
    Optional<Diagnose> handle(UpdateDiagnoseCommand command);
}