package com.acme.hormonalcare.backend.profile.interfaces.rest.transform;

import com.acme.hormonalcare.backend.profile.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profile.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity){
        return new ProfileResource(
                entity.getName().getFullName(),
                entity.getGender().getGender(),
                entity.getAge().age(),
                entity.getPhoneNumber(),
                entity.getEmail().email(),
                entity.getImage(),
                entity.getBirthday().birthday(),
                entity.getUser().getId()
        );
    }
}
