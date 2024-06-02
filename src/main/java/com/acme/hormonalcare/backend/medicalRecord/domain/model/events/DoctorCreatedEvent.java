package com.acme.hormonalcare.backend.medicalRecord.domain.model.events;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class DoctorCreatedEvent {
    private final String doctorId;
    private final LocalDateTime createdAt;

    public DoctorCreatedEvent(String doctorId, LocalDateTime createdAt) {
        this.doctorId = doctorId;
        this.createdAt = createdAt;
    }
}