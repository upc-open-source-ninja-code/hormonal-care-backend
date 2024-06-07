package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicalRecordCommand;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
public class MedicalRecord extends AuditableAbstractAggregateRoot<MedicalRecord> {
    @Getter
    @OneToOne
    @JoinColumn(name = "reason_of_consultation_id", referencedColumnName = "id")
    private ReasonOfConsultation reasonOfConsultation;

    public MedicalRecord() {
        this.reasonOfConsultation = new ReasonOfConsultation();
    }

    public MedicalRecord(ReasonOfConsultation reasonOfConsultation) {
        this.reasonOfConsultation = reasonOfConsultation;
    }

//    public MedicalRecord(CreateMedicalRecordCommand command) {
//        this.reasonOfConsultation = command.reasonOfConsultation();
//    }

    public Long getReasonOfConsultationId() {
        return reasonOfConsultation.getId();
    }
}
