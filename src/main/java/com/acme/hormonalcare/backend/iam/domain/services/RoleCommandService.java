package com.acme.hormonalcare.backend.iam.domain.services;

import com.acme.hormonalcare.backend.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
