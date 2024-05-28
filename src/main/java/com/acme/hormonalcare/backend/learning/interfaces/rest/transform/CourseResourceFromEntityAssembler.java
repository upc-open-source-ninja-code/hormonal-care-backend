package com.acme.hormonalcare.backend.learning.interfaces.rest.transform;

import com.acme.hormonalcare.backend.learning.domain.model.aggregates.Course;
import com.acme.hormonalcare.backend.learning.interfaces.rest.resources.CourseResource;

public class CourseResourceFromEntityAssembler {
    public static CourseResource toResourceFromEntity(Course entity) {
        return new CourseResource(entity.getId(), entity.getTitle(), entity.getDescription());
    }
}
