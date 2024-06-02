package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.Year;
import java.util.concurrent.atomic.AtomicInteger;

@Embeddable
public class DoctorCode implements Serializable {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final String code;

    protected DoctorCode() {
        this.code = generateCode();
    }

    private DoctorCode(String code) {
        this.code = code;
    }

    public static DoctorCode create() {
        return new DoctorCode(generateCode());
    }

    private static String generateCode() {
        return String.format("d%s%03d", Year.now().getValue(), count.incrementAndGet());
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorCode that = (DoctorCode) o;

        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
