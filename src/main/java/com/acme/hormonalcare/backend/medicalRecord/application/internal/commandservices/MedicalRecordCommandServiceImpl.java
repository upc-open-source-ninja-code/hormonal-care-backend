package com.acme.hormonalcare.backend.medicalRecord.application.internal.commandservices;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.MedicalRecord;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.ReasonOfConsultation;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalRecordCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalRecordCommandService;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.MedicalRecordRepository;
import com.acme.hormonalcare.backend.medicalRecord.infrastructure.persistence.jpa.repositories.ReasonOfConsultationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MedicalRecordCommandServiceImpl implements MedicalRecordCommandService {
    private final MedicalRecordRepository medicalRecordRepository;
    private final ReasonOfConsultationRepository reasonOfConsultationRepository;

    public MedicalRecordCommandServiceImpl(MedicalRecordRepository medicalRecordRepository, ReasonOfConsultationRepository reasonOfConsultationRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.reasonOfConsultationRepository = reasonOfConsultationRepository;
    }

    @Transactional
    public Optional<MedicalRecord> handle(CreateMedicalRecordCommand command) {
        ReasonOfConsultation reasonOfConsultation = new ReasonOfConsultation();
        reasonOfConsultationRepository.save(reasonOfConsultation);
        MedicalRecord medicalRecord = new MedicalRecord(reasonOfConsultation);
        medicalRecordRepository.save(medicalRecord);
        return Optional.of(medicalRecord);
    }
}
