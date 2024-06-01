package com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Medication;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.DrugName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    List<Medication> findByDrugName(DrugName drugName);
    boolean existsMedicationByDrugName(DrugName drugName);

   //List<Medication> findByMedicalRecordId(Long medicalRecordId);
    //boolean existsMedicationByMedicalRecordId(Long medicalRecordId);

    List<Medication> findByPrescriptionId(Long prescriptionId);
    boolean existsMedicationByPrescriptionId(Long prescriptionId);

    List<Medication> findByMedicationTypeId(Long typeId);
    boolean existsMedicationByMedicationTypeId(Long typeId);

}