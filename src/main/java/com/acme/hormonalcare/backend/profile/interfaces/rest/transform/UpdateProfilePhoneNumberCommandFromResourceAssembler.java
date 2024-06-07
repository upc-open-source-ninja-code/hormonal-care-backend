package com.acme.hormonalcare.backend.profile.interfaces.rest.transform;

import com.acme.hormonalcare.backend.profile.domain.model.commands.UpdateProfilePhoneNumberCommand;
import com.acme.hormonalcare.backend.profile.interfaces.rest.resources.UpdateProfilePhoneNumberResource;

public class UpdateProfilePhoneNumberCommandFromResourceAssembler {
    public static UpdateProfilePhoneNumberCommand toCommandFromResource(Long id, UpdateProfilePhoneNumberResource resource){
        return new UpdateProfilePhoneNumberCommand(
                id,
                resource.phoneNumber()
        );
    }
}
