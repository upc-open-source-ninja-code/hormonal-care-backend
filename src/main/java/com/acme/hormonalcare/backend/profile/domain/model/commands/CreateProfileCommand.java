package com.acme.hormonalcare.backend.profile.domain.model.commands;

import java.util.Date;

public record CreateProfileCommand(String firstName, String lastName, String gender, Integer age, String phoneNumber, String email, String Image, Date birthday) {
}
