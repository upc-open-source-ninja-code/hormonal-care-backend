package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ExternalReport;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateExternalReportCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateExternalReportCommand;

import java.util.Optional;

public interface ExternalReportCommandService {
    Optional<ExternalReport> handle(CreateExternalReportCommand command);
    Optional<ExternalReport> handle(UpdateExternalReportCommand command);
}
