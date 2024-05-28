package com.acme.hormonalcare.backend.learning.infrastructure.persistence.jpa.repositories;

import com.acme.hormonalcare.backend.learning.domain.model.aggregates.Student;
import com.acme.hormonalcare.backend.learning.domain.model.valueobjects.AcmeStudentRecordId;
import com.acme.hormonalcare.backend.learning.domain.model.valueobjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByAcmeStudentRecordId(AcmeStudentRecordId studentRecordId);
    Optional<Student> findByProfileId(ProfileId profileId);
}