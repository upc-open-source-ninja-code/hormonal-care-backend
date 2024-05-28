package com.acme.hormonalcare.backend.profiles.interfaces.rest.transform;

import com.acme.hormonalcare.backend.profiles.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress(),
                entity.getStreetAddress());
    }
}
