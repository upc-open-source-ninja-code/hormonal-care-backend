package com.acme.hormonalcare.backend.learning.domain.model.commands;

public record UpdateCourseCommand(Long id, String title, String description) {
}