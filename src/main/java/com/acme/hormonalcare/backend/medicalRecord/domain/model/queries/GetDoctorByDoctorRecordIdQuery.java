package com.acme.hormonalcare.backend.medicalRecord.domain.model.queries;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.DoctorRecordId;

public record GetDoctorByDoctorRecordIdQuery(DoctorRecordId doctorRecordId){
}
