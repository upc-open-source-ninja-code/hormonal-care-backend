package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Diagnose;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DiagnoseCommandService;
import org.springframework.stereotype.Service;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.DiagnoseRepository;

import java.util.Optional;

@Service
public class DiagnoseCommandServiceImpl implements DiagnoseCommandService {
    private final DiagnoseRepository DiagnoseRepository;

    public DiagnoseCommandServiceImpl(DiagnoseRepository DiagnoseRepository) {
        this.DiagnoseRepository = DiagnoseRepository;
    }

    @Override
    public Optional<Diagnose> handle(CreateDiagnoseCommand command) {
        var Diagnose = new Diagnose(command);
        DiagnoseRepository.save(Diagnose);
        return Optional.of(Diagnose);
    }

    @Override
    public Optional<Diagnose> handle(UpdateDiagnoseCommand command) {
        var id = command.id();
        if (!DiagnoseRepository.existsById(id))
            throw new IllegalArgumentException("Diagnose with id "+ id +" not found");
        var diagnoseresult = DiagnoseRepository.findById(id);
        var DiagnoseToUpdate = diagnoseresult.get();
        try{
            var updatedDiagnose = DiagnoseRepository.save(DiagnoseToUpdate.UpdateInformation(command.description()));
            return Optional.of(updatedDiagnose);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating Diagnose");
        }
    }
}