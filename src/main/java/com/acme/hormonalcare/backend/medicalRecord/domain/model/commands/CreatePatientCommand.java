package com.acme.hormonalcare.backend.medicalRecord.domain.model.commands;

import java.util.Date;

public record CreatePatientCommand(
        String firstName,
        String lastName,
        String gender,
        Integer age,
        String phoneNumber,
        String email,
        String Image,
        Date birthday,
        String typeofblood,
        Long doctorId) {
}
