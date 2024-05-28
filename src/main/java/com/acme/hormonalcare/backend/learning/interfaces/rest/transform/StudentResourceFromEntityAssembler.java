package com.acme.hormonalcare.backend.learning.interfaces.rest.transform;

import com.acme.hormonalcare.backend.learning.domain.model.aggregates.Student;
import com.acme.hormonalcare.backend.learning.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student student) {
        return new StudentResource(
                student.getStudentRecordId(),
                student.getProfileId(),
                student.getTotalCompletedCourses(),
                student.getTotalTutorials()
        );
    }
}