package com.acme.hormonalcare.backend.profiles.domain.model.queries;

import com.acme.hormonalcare.backend.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress email) { }
