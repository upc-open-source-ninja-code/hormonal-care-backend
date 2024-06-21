package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalAppointment;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetAllMedicalAppointmentQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalAppointmentByEventDate;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalAppointmentByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalAppointmentByPatientIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalAppointmentQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicalAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalAppointmentQueryServiceImpl implements MedicalAppointmentQueryService {
    private final MedicalAppointmentRepository medicalAppointmentRepository;

    public MedicalAppointmentQueryServiceImpl(MedicalAppointmentRepository medicalAppointmentRepository) {
        this.medicalAppointmentRepository = medicalAppointmentRepository;
    }

    @Override
    public List<MedicalAppointment> handle(GetAllMedicalAppointmentQuery query) {
        return medicalAppointmentRepository.findAll();
    }

    @Override
    public Optional<MedicalAppointment> handle(GetMedicalAppointmentByIdQuery query) {
        return medicalAppointmentRepository.findById(query.id());
    }

    @Override
    public List<MedicalAppointment> handle(GetMedicalAppointmentByEventDate query) {
        return medicalAppointmentRepository.findByEventDate(query.date());

    }

    @Override
    public List<MedicalAppointment> handle(GetMedicalAppointmentByPatientIdQuery query) {
        return medicalAppointmentRepository.findByPatientId(query.patientId());

    }

}
