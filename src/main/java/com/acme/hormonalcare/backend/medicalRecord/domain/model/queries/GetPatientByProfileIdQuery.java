package com.acme.hormonalcare.backend.medicalRecord.domain.model.queries;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.ProfileId;

public record GetPatientByProfileIdQuery(ProfileId profileId) {
}
