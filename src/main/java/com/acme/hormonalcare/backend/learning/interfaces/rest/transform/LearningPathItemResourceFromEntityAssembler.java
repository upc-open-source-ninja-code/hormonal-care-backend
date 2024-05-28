package com.acme.hormonalcare.backend.learning.interfaces.rest.transform;

import com.acme.hormonalcare.backend.learning.domain.model.entities.LearningPathItem;
import com.acme.hormonalcare.backend.learning.interfaces.rest.resources.LearningPathItemResource;

public class LearningPathItemResourceFromEntityAssembler {
    public static LearningPathItemResource toResourceFromEntity(LearningPathItem entity) {
        return new LearningPathItemResource(entity.getId(), entity.getCourse().getId(), entity.getTutorialId());
    }
}