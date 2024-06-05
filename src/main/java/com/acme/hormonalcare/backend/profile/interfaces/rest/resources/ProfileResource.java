package com.acme.hormonalcare.backend.profile.interfaces.rest.resources;

import java.util.Date;

public record ProfileResource(
        String firstName,
        String lastName,
        String gender,
        Integer age,
        String phoneNumber,
        String email,
        String Image,
        Date birthday) {
}
