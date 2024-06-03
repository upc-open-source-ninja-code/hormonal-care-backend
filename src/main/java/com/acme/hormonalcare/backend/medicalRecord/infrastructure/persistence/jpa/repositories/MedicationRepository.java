package com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Medication;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.Concentration;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.DrugName;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.Duration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    Optional<Medication> findByDrugName(DrugName drugName);
    boolean existsByDrugName(DrugName drugName);

   //List<Medication> findByMedicalRecordId(Long medicalRecordId);
    //boolean existsMedicationByMedicalRecordId(Long medicalRecordId);

    Optional<Medication> findByPrescriptionId(Long prescriptionId);
    boolean existsByPrescriptionId(Long prescriptionId);

    Optional<Medication> findByMedicationTypeId(Long typeId);
    boolean existsByMedicationTypeId(Long typeId);

}