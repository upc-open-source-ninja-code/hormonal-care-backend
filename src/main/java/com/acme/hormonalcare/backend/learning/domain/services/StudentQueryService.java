package com.acme.hormonalcare.backend.learning.domain.services;

import com.acme.hormonalcare.backend.learning.domain.model.aggregates.Student;
import com.acme.hormonalcare.backend.learning.domain.model.queries.GetStudentByAcmeStudentRecordIdQuery;
import com.acme.hormonalcare.backend.learning.domain.model.queries.GetStudentByProfileIdQuery;

import java.util.Optional;

public interface StudentQueryService {
    Optional<Student> handle(GetStudentByProfileIdQuery query);
    Optional<Student> handle(GetStudentByAcmeStudentRecordIdQuery query);
}
