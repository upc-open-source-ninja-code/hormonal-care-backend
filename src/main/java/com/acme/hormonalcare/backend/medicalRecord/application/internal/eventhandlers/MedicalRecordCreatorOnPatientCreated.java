package com.acme.hormonalcare.backend.medicalRecord.application.internal.eventhandlers;

import com.acme.hormonalcare.backend.medicalRecord.domain.events.PatientCreatedEvent;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalRecord;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Patient;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicalRecordRepository;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.PatientRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MedicalRecordCreatorOnPatientCreated {
    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;

    public MedicalRecordCreatorOnPatientCreated(MedicalRecordRepository medicalRecordRepository, PatientRepository patientRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.patientRepository = patientRepository;
    }

    @EventListener
    public void handle(PatientCreatedEvent event) {
        Patient patient = patientRepository.findById(event.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Patient with id " + event.getPatientId() + " does not exist"));
        MedicalRecord medicalRecord = new MedicalRecord(patient);
        medicalRecordRepository.save(medicalRecord);
    }
}
