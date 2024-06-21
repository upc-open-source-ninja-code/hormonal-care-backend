package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalAppointment;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalAppointmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.DeleteMedicalAppointmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateMedicalAppointmentCommand;

import java.util.Optional;

public interface MedicalAppointmentCommandService {
    Optional<MedicalAppointment> handle(CreateMedicalAppointmentCommand command);
    Optional<MedicalAppointment> handle(UpdateMedicalAppointmentCommand command);
    void handle(DeleteMedicalAppointmentCommand command);
}
