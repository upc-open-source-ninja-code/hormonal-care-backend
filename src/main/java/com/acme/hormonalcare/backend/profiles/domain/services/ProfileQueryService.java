package com.acme.hormonalcare.backend.profiles.domain.services;

import com.acme.hormonalcare.backend.profiles.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profiles.domain.model.queries.GetAllProfilesQuery;
import com.acme.hormonalcare.backend.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.acme.hormonalcare.backend.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    List<Profile> handle(GetAllProfilesQuery query);
    Optional<Profile> handle(GetProfileByIdQuery query);
    Optional<Profile> handle(GetProfileByEmailQuery query);
}
