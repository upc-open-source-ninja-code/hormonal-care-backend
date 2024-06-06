package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Diagnose;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.DeleteDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DiagnoseCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.DiagnoseRepository;
import org.springframework.stereotype.Service;

@Service
public class DiagnoseCommandServiceImpl implements DiagnoseCommandService {

    private final DiagnoseRepository diagnoseRepository;

    public DiagnoseCommandServiceImpl(DiagnoseRepository diagnoseRepository) {
        this.diagnoseRepository = diagnoseRepository;
    }

    @Override
    public Long handle(CreateDiagnoseCommand command) {
        var diagnose = new Diagnose(command);
        return diagnose.getId();

    }

    @Override
    public void handle(DeleteDiagnoseCommand command) {
        diagnoseRepository.deleteById(command.id());

    }

}
