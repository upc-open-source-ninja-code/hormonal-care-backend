package com.acme.hormonalcare.backend.profile.domain.model.commands;

public record UpdateProfilePhoneNumberCommand(
        Long id,
        String phoneNumber
) {
}
