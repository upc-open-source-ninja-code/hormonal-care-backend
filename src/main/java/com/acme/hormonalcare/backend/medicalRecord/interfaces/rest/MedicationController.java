package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.*;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.*;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.*;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/medical-record/medications", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Medications", description = "Medication Management Endpoints")
public class MedicationController {
    private final MedicationCommandService medicationCommandService;
    private final MedicationQueryService medicationQueryService;
    private final MedicationTypeCommandService medicationTypeCommandService;
    private final MedicationTypeQueryService medicationTypeQueryService;
    private final PrescriptionCommandService prescriptionCommandService;
    private final PrescriptionQueryService prescriptionQueryService;

    public MedicationController(MedicationCommandService medicationCommandService, MedicationQueryService medicationQueryService,
                                MedicationTypeCommandService medicationTypeCommandService, MedicationTypeQueryService medicationTypeQueryService,
                                PrescriptionCommandService prescriptionCommandService, PrescriptionQueryService prescriptionQueryService) {
        this.medicationCommandService = medicationCommandService;
        this.medicationQueryService = medicationQueryService;
        this.medicationTypeCommandService = medicationTypeCommandService;
        this.medicationTypeQueryService = medicationTypeQueryService;
        this.prescriptionCommandService = prescriptionCommandService;
        this.prescriptionQueryService = prescriptionQueryService;
    }

    @PostMapping
    public ResponseEntity<MedicationResource> createMedication(@RequestBody CreateMedicationResource resource) {
        var createMedicationCommand = CreateMedicationCommandFromResourceAssembler.toCommandFromResource(resource);
        var medication = medicationCommandService.handle(createMedicationCommand);
        if (medication.isEmpty()) return ResponseEntity.badRequest().build();
        var medicationResource = MedicationResourceFromEntityAssembler.toResourceFromEntity(medication.get());
        return new ResponseEntity<>(medicationResource, HttpStatus.CREATED);
    }

    @GetMapping("/{medicationId}")
    public ResponseEntity<MedicationResource> getMedicationById(@PathVariable Long medicationId) {
        var getMedicationByIdQuery = new GetMedicationByIdQuery(medicationId);
        var medication = medicationQueryService.handle(getMedicationByIdQuery);
        if (medication.isEmpty()) return ResponseEntity.notFound().build();
        var medicationResource = MedicationResourceFromEntityAssembler.toResourceFromEntity(medication.get());
        return ResponseEntity.ok(medicationResource);
    }

    @GetMapping
    public ResponseEntity<List<MedicationResource>> getAllMedications() {
        var getAllMedicationsQuery = new GetAllMedicationsQuery();
        var medications = medicationQueryService.handle(getAllMedicationsQuery);
        var medicationResources = medications.stream()
                .map(MedicationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(medicationResources);
    }

    @PostMapping("/medicationTypes")
    public ResponseEntity<MedicationTypeResource> createMedicationType(@RequestBody CreateMedicationTypeResource resource) {
        var createMedicationTypeCommand = CreateMedicationTypeCommandFromResourceAssembler.toCommandFromResource(resource);
        var medicationType = medicationTypeCommandService.handle(createMedicationTypeCommand);
        if (medicationType.isEmpty()) return ResponseEntity.badRequest().build();
        var medicationTypeResource = MedicationTypeResourceFromEntityAssembler.toResourceFromEntity(medicationType.get());
        return new ResponseEntity<>(medicationTypeResource, HttpStatus.CREATED);
    }

    @GetMapping("/medicationTypes")
    public ResponseEntity<List<MedicationTypeResource>> getAllMedicationTypes() {
        var getAllMedicationTypesQuery = new GetAllMedicationTypesQuery();
        var medicationTypes = medicationTypeQueryService.handle(getAllMedicationTypesQuery);
        var medicationTypeResources = medicationTypes.stream()
                .map(MedicationTypeResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(medicationTypeResources);
    }

    @PostMapping("/prescriptions")
    public ResponseEntity<PrescriptionResource> createPrescription(@RequestBody CreatePrescriptionResource resource) {
        var createPrescriptionCommand = CreatePrescriptionCommandFromResourceAssembler.toCommandFromResource(resource);
        var prescription = prescriptionCommandService.handle(createPrescriptionCommand);
        if (prescription.isEmpty()) return ResponseEntity.badRequest().build();
        var prescriptionResource = PrescriptionResourceFromEntityAssembler.toResourceFromEntity(prescription.get());
        return new ResponseEntity<>(prescriptionResource, HttpStatus.CREATED);
    }

    @GetMapping("/prescriptions")
    public ResponseEntity<List<PrescriptionResource>> getAllPrescriptions() {
        var getAllPrescriptionsQuery = new GetAllPrescriptionsQuery();
        var prescriptions = prescriptionQueryService.handle(getAllPrescriptionsQuery);
        var prescriptionResources = prescriptions.stream()
                .map(PrescriptionResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(prescriptionResources);
    }
}