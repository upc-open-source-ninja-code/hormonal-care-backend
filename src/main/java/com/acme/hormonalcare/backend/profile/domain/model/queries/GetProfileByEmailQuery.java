package com.acme.hormonalcare.backend.profile.domain.model.queries;

import com.acme.hormonalcare.backend.profile.domain.model.valueobjects.Email;

public record GetProfileByEmailQuery(Email email) {
}
