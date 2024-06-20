package com.acme.hormonalcare.backend.medicalRecord.application.internal.queryservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Doctor;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetAllDoctorsQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDoctorByDoctorRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDoctorByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDoctorByProfileIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DoctorQueryService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorQueryServiceImpl implements DoctorQueryService {
    private final DoctorRepository doctorRepository;

    public DoctorQueryServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Optional<Doctor> handle(GetDoctorByIdQuery query) {
        
        return doctorRepository.findById(query.id());
    }

    @Override
    public List<Doctor> handle(GetAllDoctorsQuery query) {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> handle(GetDoctorByDoctorRecordIdQuery query) {
        return doctorRepository.findByDoctorRecordId(query.doctorRecordId());
    }

    @Override
    public Optional<Doctor> handle(GetDoctorByProfileIdQuery query) {
        return doctorRepository.findByProfileId(query.profileId());
    }

}
