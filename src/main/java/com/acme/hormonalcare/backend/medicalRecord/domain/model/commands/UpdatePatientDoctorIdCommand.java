package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

public record UpdatePatientDoctorIdCommand(Long id, Long doctorId) {
}
