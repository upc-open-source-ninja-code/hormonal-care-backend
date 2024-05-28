package com.acme.hormonalcare.backend.learning.interfaces.rest.transform;

import com.acme.hormonalcare.backend.learning.domain.model.commands.CreateCourseCommand;
import com.acme.hormonalcare.backend.learning.interfaces.rest.resources.CreateCourseResource;

public class CreateCourseCommandFromResourceAssembler {
    public static CreateCourseCommand toCommandFromResource(CreateCourseResource resource) {
        return new CreateCourseCommand(resource.title(), resource.description());
    }
}
