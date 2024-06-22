package com.acme.hormonalcare.backend.iam.interfaces.rest.transform;

import com.acme.hormonalcare.backend.iam.domain.model.commands.SignInCommand;
import com.acme.hormonalcare.backend.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}
