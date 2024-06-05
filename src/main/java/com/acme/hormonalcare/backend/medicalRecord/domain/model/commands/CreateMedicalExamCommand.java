package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.TypeExam;

public record CreateMedicalExamCommand(String name, TypeExam typeExamId) {
}
