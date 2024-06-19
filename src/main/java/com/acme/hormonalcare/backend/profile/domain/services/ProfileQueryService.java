package com.acme.hormonalcare.backend.profile.domain.services;

import com.acme.hormonalcare.backend.profile.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profile.domain.model.queries.GetAllProfilesQuery;
import com.acme.hormonalcare.backend.profile.domain.model.queries.GetProfileByEmailQuery;
import com.acme.hormonalcare.backend.profile.domain.model.queries.GetProfileByIdQuery;
import com.acme.hormonalcare.backend.profile.domain.model.queries.GetProfileByNameQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    List<Profile> handle(GetAllProfilesQuery query);
    Optional<Profile> handle(GetProfileByIdQuery query);
    Optional<Profile> handle(GetProfileByNameQuery query);
    Optional<Profile> handle(GetProfileByEmailQuery query);
}
