package com.acme.hormonalcare.backend.profile.application.internal.queryservices;

import com.acme.hormonalcare.backend.profile.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profile.domain.model.queries.GetAllProfilesQuery;
import com.acme.hormonalcare.backend.profile.domain.model.queries.GetProfileByEmailQuery;
import com.acme.hormonalcare.backend.profile.domain.model.queries.GetProfileByIdQuery;
import com.acme.hormonalcare.backend.profile.domain.model.queries.GetProfileByNameQuery;
import com.acme.hormonalcare.backend.profile.domain.services.ProfileQueryService;
import com.acme.hormonalcare.backend.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;

import java.util.List;
import java.util.Optional;

public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return List.of();
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.id());
    }

    @Override
    public Optional<Profile> handle(GetProfileByNameQuery query) {
        return profileRepository.findByName(query.name());
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.email());
    }
}
