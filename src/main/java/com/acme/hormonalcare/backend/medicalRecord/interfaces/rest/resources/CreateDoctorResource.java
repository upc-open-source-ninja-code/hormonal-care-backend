package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources;

import java.util.Date;

public record CreateDoctorResource(
        String firstName,
        String lastName,
        String gender,
        Integer age,
        String phoneNumber,
        String email,
        String Image,
        Date birthday,
        Long professionalIdentificationNumber,
        String subSpecialty,
        String certification,
        Long appointmentFee,
        Long subscriptionId
) {
}
