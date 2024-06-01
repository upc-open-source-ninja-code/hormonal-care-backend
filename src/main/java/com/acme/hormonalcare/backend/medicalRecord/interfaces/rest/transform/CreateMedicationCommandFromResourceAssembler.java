
package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.CreateMedicationCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.*;
        import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateMedicationResource;

public class CreateMedicationCommandFromResourceAssembler {
    public static CreateMedicationCommand toCommandFromResource(CreateMedicationResource resource) {
        return new CreateMedicationCommand(
                resource.medicalRecord(),
                resource.prescriptionId(),
                resource.medicationTypeId(),
                new DrugName(resource.name()),
                new Quantity(resource.amount(), resource.unitQ()),
                new Concentration(resource.value(), resource.unit()),
                new Frequency(resource.timesPerDay()),
                new Duration(resource.timePeriod()));
    }
}