package com.acme.hormonalcare.backend.learning.interfaces.rest.transform;

import com.acme.hormonalcare.backend.learning.domain.model.commands.RequestEnrollmentCommand;
import com.acme.hormonalcare.backend.learning.domain.model.valueobjects.AcmeStudentRecordId;
import com.acme.hormonalcare.backend.learning.interfaces.rest.resources.RequestEnrollmentResource;

public class RequestEnrollmentCommandFromResourceAssembler {
    public static RequestEnrollmentCommand toCommandFromResource(RequestEnrollmentResource resource) {
        return new RequestEnrollmentCommand(new AcmeStudentRecordId(resource.studentRecordId()), resource.courseId());
    }
}