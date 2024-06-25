package com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ReasonOfConsultationRepository extends JpaRepository<ReasonOfConsultation, Long> {
    List<ReasonOfConsultation> findByMedicalRecordId(Long medicalRecordId);
}
