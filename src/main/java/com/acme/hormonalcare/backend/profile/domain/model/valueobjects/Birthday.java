package com.acme.hormonalcare.backend.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public record Birthday(Date birthday) {
    public Birthday() {
        this(null);
    }

    public Birthday {
        if (birthday == null) {
            throw new IllegalArgumentException("Birthday cannot be null");
        }
    }

    public String getBirthday() {
        return birthday.toString();
    }
}
