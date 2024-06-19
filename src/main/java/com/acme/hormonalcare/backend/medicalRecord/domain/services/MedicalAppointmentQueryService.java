package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalAppointment;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetAllMedicalAppointmentQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalAppointmentByEventDate;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalAppointmentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface MedicalAppointmentQueryService {
    List<MedicalAppointment> handle(GetAllMedicalAppointmentQuery query);
    Optional<MedicalAppointment> handle(GetMedicalAppointmentByIdQuery query);
}
