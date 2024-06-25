package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Diagnose;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ExternalReport;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalRecord;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateExternalReportCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DiagnoseCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicalRecordRepository;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.DiagnoseRepository;

import java.util.Optional;

@Service
public class DiagnoseCommandServiceImpl implements DiagnoseCommandService {
    private final DiagnoseRepository diagnoseRepository;
    private final MedicalRecordRepository medicalRecordRepository;


    public DiagnoseCommandServiceImpl(DiagnoseRepository diagnoseRepository, MedicalRecordRepository medicalRecordRepository) {
        this.diagnoseRepository = diagnoseRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public Optional<Diagnose> handle(CreateDiagnoseCommand command) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(command.medicalRecordId()).orElseThrow(() -> new RuntimeException("MedicalRecord does not exits"));
        var Diagnose = new Diagnose(command, medicalRecord);
        diagnoseRepository.save(Diagnose);
        return Optional.of(Diagnose);
    }

    @Override
    public Optional<Diagnose> handle(UpdateDiagnoseCommand command) {
        var id = command.id();
        if (!diagnoseRepository.existsById(id))
            throw new IllegalArgumentException("Diagnose with id "+ id +" does not exist");
        MedicalRecord medicalRecord = medicalRecordRepository.findById(command.medicalRecordId()).orElseThrow(() -> new RuntimeException("MedicalRecord does not exits"));
        var result = diagnoseRepository.findById(id);
        var diagnoseToUpdate = result.get();
        try{
            var updatedDiagnose = diagnoseRepository.save(diagnoseToUpdate.updateInformation(command.description(), medicalRecord));
            return Optional.of(updatedDiagnose);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating external report with id "+ id);
        }
    }
}