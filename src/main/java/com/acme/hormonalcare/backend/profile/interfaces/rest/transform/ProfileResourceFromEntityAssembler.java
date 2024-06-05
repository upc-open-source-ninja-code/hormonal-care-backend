package com.acme.hormonalcare.backend.profile.interfaces.rest.transform;

import com.acme.hormonalcare.backend.profile.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profile.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity){
        return new ProfileResource(
                entity.getName().getFullName(),
                entity.getAge().getAge(),
                entity.getGender().getGender(),
                entity.getPhoneNumber().getPhoneNumber(),
                entity.getEmail().getEmail(),
                entity.getBirthday().getBirthday(),
                entity.getImage()
        );
    }
}

/*
String firstName,
        String lastName,
        String gender,
        Integer age,
        String phoneNumber,
        String email,
        String Image,
        Date birthday)
 */