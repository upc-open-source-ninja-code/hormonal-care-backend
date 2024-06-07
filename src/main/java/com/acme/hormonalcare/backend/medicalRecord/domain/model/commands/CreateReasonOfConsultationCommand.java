package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record CreateReasonOfConsultationCommand(String description, String symptoms) {
}
