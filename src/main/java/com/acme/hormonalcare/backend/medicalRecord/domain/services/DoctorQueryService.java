package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Doctor;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetAllDoctorsQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDoctorByDoctorRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDoctorByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDoctorByProfileIdQuery;

import java.util.List;
import java.util.Optional;

public interface DoctorQueryService {
    Optional<Doctor> handle(GetDoctorByIdQuery query);
    List<Doctor> handle(GetAllDoctorsQuery query);
    Optional<Doctor> handle(GetDoctorByDoctorRecordIdQuery query);
    Optional<Doctor> handle(GetDoctorByProfileIdQuery query);
}
