
package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;
public record CreateDiagnoseCommand(String description, Long medicalRecordId) {
}
