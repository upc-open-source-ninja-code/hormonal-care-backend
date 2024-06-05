
package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationCommand;
        import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateMedicationResource;

public class CreateMedicationCommandFromResourceAssembler {
    public static CreateMedicationCommand toCommandFromResource(CreateMedicationResource resource) {
        return new CreateMedicationCommand(
                resource.medicalTypeId(),
                resource.prescriptionId(),
                resource.name(),
                resource.amount(),
                resource.unitQ(),
                resource.value(),
                resource.unit(),
                resource.timesPerDay(),
                resource.timePeriod());
    }
}