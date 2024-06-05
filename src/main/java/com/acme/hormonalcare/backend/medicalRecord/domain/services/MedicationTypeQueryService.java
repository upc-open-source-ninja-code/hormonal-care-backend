package com.acme.hormonalcare.backend.medicalRecord.domain.services;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.MedicationType;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface MedicationTypeQueryService {
    List<MedicationType> handle(GetAllMedicationTypesQuery query);
    Optional<MedicationType> handle(GetMedicationTypeByIdQuery query);
}