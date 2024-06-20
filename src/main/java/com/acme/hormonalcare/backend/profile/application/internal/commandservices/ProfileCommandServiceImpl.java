package com.acme.hormonalcare.backend.profile.application.internal.commandservices;

import com.acme.hormonalcare.backend.profile.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profile.domain.model.commands.CreateProfileCommand;
import com.acme.hormonalcare.backend.profile.domain.model.commands.UpdateProfileImageCommand;
import com.acme.hormonalcare.backend.profile.domain.model.commands.UpdateProfilePhoneNumberCommand;
import com.acme.hormonalcare.backend.profile.domain.services.ProfileCommandService;
import com.acme.hormonalcare.backend.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {
        var profile = new Profile(command);
        profileRepository.save(profile);
        return Optional.of(profile);
    }

    @Override
    public Optional<Profile> handle(UpdateProfilePhoneNumberCommand command) {
        var id = command.id();
        if (!profileRepository.existsById(id))
            throw new IllegalArgumentException("Profile with id "+ id +" does not exist");
        var result = profileRepository.findById(id);
        var profileToUpdate = result.get();
        try {
            var updateProfile = profileRepository.save(profileToUpdate.upsetPhoneNumber(command.phoneNumber()));
            return Optional.of(updateProfile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating profile with id "+ id);
        }
    }

    @Override
    public Optional<Profile> handle(UpdateProfileImageCommand command) {
        var id = command.id();
        if (!profileRepository.existsById(id))
            throw new IllegalArgumentException("Profile with id "+ id +" does not exist");
        var result = profileRepository.findById(id);
        var profileToUpdate = result.get();
        try {
            var updateProfile = profileRepository.save(profileToUpdate.upsetImage(command.image()));
            return Optional.of(updateProfile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating profile with id "+ id);
        }
    }
}
