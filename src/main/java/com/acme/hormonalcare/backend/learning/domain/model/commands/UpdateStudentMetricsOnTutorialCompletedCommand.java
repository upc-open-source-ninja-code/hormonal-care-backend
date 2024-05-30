package com.acme.hormonalcare.backend.learning.domain.model.commands;

import com.acme.hormonalcare.backend.learning.domain.model.valueobjects.AcmeStudentRecordId;

public record UpdateStudentMetricsOnTutorialCompletedCommand(AcmeStudentRecordId studentRecordId) {
}