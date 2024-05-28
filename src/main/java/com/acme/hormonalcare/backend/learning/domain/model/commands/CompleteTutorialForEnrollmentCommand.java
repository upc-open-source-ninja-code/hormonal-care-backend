package com.acme.hormonalcare.backend.learning.domain.model.commands;

public record CompleteTutorialForEnrollmentCommand(Long enrollmentId, Long tutorialId) {
}
