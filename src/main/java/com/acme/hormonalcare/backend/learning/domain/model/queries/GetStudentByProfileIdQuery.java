package com.acme.hormonalcare.backend.learning.domain.model.queries;

import com.acme.center.platform.learning.domain.model.valueobjects.ProfileId;

public record GetStudentByProfileIdQuery(ProfileId profileId) {
}
