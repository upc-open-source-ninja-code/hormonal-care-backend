package com.acme.hormonalcare.backend.profile.interfaces.rest.transform;

import com.acme.hormonalcare.backend.profile.domain.model.commands.UpdateProfileImageCommand;
import com.acme.hormonalcare.backend.profile.interfaces.rest.resources.UpdateProfileImageResource;

public class UpdateProfileImageCommandFromResourceAssembler {
    public static UpdateProfileImageCommand toCommandFromResource(Long id, UpdateProfileImageResource resource){
        return new UpdateProfileImageCommand(
                id,
                resource.Image()
        );
    }
}
