package com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    Optional<Treatment> findByMedicalRecordId(Long medicalRecordId);
}
