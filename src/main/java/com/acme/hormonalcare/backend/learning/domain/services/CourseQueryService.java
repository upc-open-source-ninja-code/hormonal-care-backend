package com.acme.hormonalcare.backend.learning.domain.services;

import com.acme.hormonalcare.backend.learning.domain.model.aggregates.Course;
import com.acme.hormonalcare.backend.learning.domain.model.entities.LearningPathItem;
import com.acme.hormonalcare.backend.learning.domain.model.queries.GetAllCoursesQuery;
import com.acme.hormonalcare.backend.learning.domain.model.queries.GetCourseByIdQuery;
import com.acme.hormonalcare.backend.learning.domain.model.queries.GetLearningPathItemByCourseIdAndTutorialIdQuery;

import java.util.List;
import java.util.Optional;

public interface CourseQueryService {
    Optional<Course> handle(GetCourseByIdQuery query);
    List<Course> handle(GetAllCoursesQuery query);
    Optional<LearningPathItem> handle(GetLearningPathItemByCourseIdAndTutorialIdQuery query);
}
