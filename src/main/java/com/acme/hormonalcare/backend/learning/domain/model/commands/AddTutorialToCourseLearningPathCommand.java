package com.acme.hormonalcare.backend.learning.domain.model.commands;

public record AddTutorialToCourseLearningPathCommand(Long tutorialId, Long courseId) {
}
