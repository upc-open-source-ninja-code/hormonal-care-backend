package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record UpdatePatientCommand(Long id, String typeofblood) {
}
