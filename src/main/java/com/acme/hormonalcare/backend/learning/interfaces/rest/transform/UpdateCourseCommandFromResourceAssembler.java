package com.acme.hormonalcare.backend.learning.interfaces.rest.transform;

import com.acme.hormonalcare.backend.learning.domain.model.commands.UpdateCourseCommand;
import com.acme.hormonalcare.backend.learning.interfaces.rest.resources.UpdateCourseResource;

public class UpdateCourseCommandFromResourceAssembler {
    public static UpdateCourseCommand toCommandFromResource(Long courseId, UpdateCourseResource resource) {
        return new UpdateCourseCommand(courseId, resource.title(), resource.description());
    }
}