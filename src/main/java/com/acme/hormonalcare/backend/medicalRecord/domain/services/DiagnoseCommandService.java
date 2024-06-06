package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.DeleteDiagnoseCommand;

public interface DiagnoseCommandService {
    Long handle(CreateDiagnoseCommand command);
    void handle(DeleteDiagnoseCommand command);

}
