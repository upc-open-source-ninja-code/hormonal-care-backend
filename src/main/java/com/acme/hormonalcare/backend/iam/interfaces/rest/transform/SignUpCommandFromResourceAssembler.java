package com.acme.hormonalcare.backend.iam.interfaces.rest.transform;

import com.acme.hormonalcare.backend.iam.domain.model.commands.SignUpCommand;
import com.acme.hormonalcare.backend.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(resource.username(), resource.password());
    }
}