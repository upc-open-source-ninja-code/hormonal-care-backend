package com.acme.hormonalcare.backend.profile.domain.services;
import com.acme.hormonalcare.backend.profile.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profile.domain.model.commands.CreateProfileCommand;
import com.acme.hormonalcare.backend.profile.domain.model.commands.UpdateProfileImageCommand;
import com.acme.hormonalcare.backend.profile.domain.model.commands.UpdateProfilePhoneNumberCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
    Optional<Profile> handle(UpdateProfilePhoneNumberCommand command);
    Optional<Profile> handle(UpdateProfileImageCommand command);
}
