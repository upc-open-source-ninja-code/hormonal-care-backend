package com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories;


import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalExamRepository extends JpaRepository<MedicalExam, Long> {
    List<MedicalExam> findByMedicalRecordId(Long medicalRecordId);
}
