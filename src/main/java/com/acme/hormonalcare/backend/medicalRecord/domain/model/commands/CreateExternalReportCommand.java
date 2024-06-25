package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record CreateExternalReportCommand (String image, Long medicalRecordId) {

}