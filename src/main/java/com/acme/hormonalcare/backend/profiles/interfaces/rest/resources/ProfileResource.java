package com.acme.hormonalcare.backend.profiles.interfaces.rest.resources;

public record ProfileResource(
        Long id,
        String fullName,
        String email,
        String streetAddress) { }
