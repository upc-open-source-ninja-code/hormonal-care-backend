package com.acme.hormonalcare.backend.profiles.domain.services;

import com.acme.hormonalcare.backend.profiles.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}
