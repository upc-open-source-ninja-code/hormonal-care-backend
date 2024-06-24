package com.acme.hormonalcare.backend.profile.interfaces.rest.transform;

import com.acme.hormonalcare.backend.profile.domain.model.commands.CreateProfileCommand;
import com.acme.hormonalcare.backend.profile.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource){
        return new CreateProfileCommand(
                resource.firstName(),
                resource.lastName(),
                resource.gender(),
                resource.age(),
                resource.phoneNumber(),
                resource.email(),
                resource.Image(),
                resource.birthday(),
                resource.userId()
        );
    }
}


