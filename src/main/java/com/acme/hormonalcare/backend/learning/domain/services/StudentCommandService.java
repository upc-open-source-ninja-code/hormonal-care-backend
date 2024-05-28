package com.acme.hormonalcare.backend.learning.domain.services;

import com.acme.hormonalcare.backend.learning.domain.model.commands.CreateStudentCommand;
import com.acme.hormonalcare.backend.learning.domain.model.commands.UpdateStudentMetricsOnTutorialCompletedCommand;
import com.acme.hormonalcare.backend.learning.domain.model.valueobjects.AcmeStudentRecordId;

public interface StudentCommandService {
    AcmeStudentRecordId handle(CreateStudentCommand command);
    AcmeStudentRecordId handle(UpdateStudentMetricsOnTutorialCompletedCommand command);
}
