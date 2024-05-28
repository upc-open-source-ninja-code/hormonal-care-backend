package com.acme.hormonalcare.backend.learning.domain.model.queries;

import com.acme.hormonalcare.backend.learning.domain.model.valueobjects.AcmeStudentRecordId;

public record GetEnrollmentByAcmeStudentRecordIdAndCourseIdQuery(AcmeStudentRecordId acmeStudentRecordId, Long courseId) {
}