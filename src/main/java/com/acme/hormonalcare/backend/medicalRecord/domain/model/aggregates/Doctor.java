package com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.Certification;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.entities.SubSpecialty;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.ProfileId;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class Doctor extends AuditableAbstractAggregateRoot<Doctor> {
    private String professionalIdentificationNumber;

    @Embedded
    private ProfileId profileId;
    @Embedded
    private SubSpecialty subSpecialty;
    @Embedded
    private Certification certification;

    //private Subscription subscriptionId;
    //private String appointmentFee;
}
