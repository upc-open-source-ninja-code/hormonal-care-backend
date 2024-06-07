package com.acme.hormonalcare.backend.profile.domain.model.queries;

import com.acme.hormonalcare.backend.profile.domain.model.valueobjects.PersonName;

public record GetProfileByNameQuery(PersonName name) {
}
