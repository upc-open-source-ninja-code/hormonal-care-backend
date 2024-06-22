package com.acme.hormonalcare.backend.iam.interfaces.rest.transform;

import com.acme.hormonalcare.backend.iam.domain.model.aggregates.User;
import com.acme.hormonalcare.backend.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(entity.getId(), entity.getUsername());
    }
}