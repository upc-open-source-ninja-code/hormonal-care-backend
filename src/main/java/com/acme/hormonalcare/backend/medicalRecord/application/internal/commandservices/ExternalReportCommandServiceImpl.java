package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ExternalReport;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalRecord;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Treatment;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateExternalReportCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateTreatmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateExternalReportCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateTreatmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.ExternalReportCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.ExternalReportRepository;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicalRecordRepository;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalReportCommandServiceImpl implements ExternalReportCommandService {
    private final ExternalReportRepository externalReportRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    public ExternalReportCommandServiceImpl(ExternalReportRepository externalReportRepository, MedicalRecordRepository medicalRecordRepository) {
        this.externalReportRepository = externalReportRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public Optional<ExternalReport> handle(CreateExternalReportCommand command) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(command.medicalRecordId()).orElseThrow(() -> new RuntimeException("MedicalRecord does not exits"));
        var externalreport = new ExternalReport(command, medicalRecord);
        externalReportRepository.save(externalreport);
        return Optional.of(externalreport);
    }
    @Override
    public Optional<ExternalReport> handle(UpdateExternalReportCommand command) {
        var id = command.id();
        if (!externalReportRepository.existsById(id))
            throw new IllegalArgumentException("External report with id "+ id +" does not exist");
        MedicalRecord medicalRecord = medicalRecordRepository.findById(command.medicalRecordId()).orElseThrow(() -> new RuntimeException("MedicalRecord does not exits"));
        var result = externalReportRepository.findById(id);
        var externalreportToUpdate = result.get();
        try{
            var updatedExternalReport = externalReportRepository.save(externalreportToUpdate.updateInformation(command.image(), medicalRecord));
            return Optional.of(updatedExternalReport);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating external report with id "+ id);
        }
    }
}
