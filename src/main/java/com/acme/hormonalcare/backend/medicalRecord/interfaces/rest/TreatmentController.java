package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTreatmentByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTreatmentByMedicalRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.TreatmentCommandService;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.TreatmentQueryService;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateTreatmentResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.TreatmentResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateTreatmentResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.CreateTreatmentCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.TreatmentResourceFromEntityAssembler;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.UpdateTreatmentCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/medical-record/treatments",produces = MediaType.APPLICATION_JSON_VALUE)
public class TreatmentController {
    private final TreatmentCommandService treatmentCommandService;
    private final TreatmentQueryService treatmentQueryService;

    public TreatmentController(TreatmentCommandService treatmentCommandService, TreatmentQueryService treatmentQueryService) {
        this.treatmentCommandService = treatmentCommandService;
        this.treatmentQueryService = treatmentQueryService;
    }

    @PostMapping
    public ResponseEntity<TreatmentResource> createTreatment(@RequestBody CreateTreatmentResource resource){
        var createTreatmentCommand = CreateTreatmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var treatment = treatmentCommandService.handle(createTreatmentCommand);
        if(treatment.isEmpty()) return ResponseEntity.badRequest().build();
        var treatmentResource = TreatmentResourceFromEntityAssembler.toResourceFromEntity(treatment.get());
        return new ResponseEntity<>(treatmentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{treatmentId}")
    public ResponseEntity<TreatmentResource> getTreatmentById(@PathVariable Long treatmentId){
        var getTreatmentByIdQuery = new GetTreatmentByIdQuery(treatmentId);
        var treatment = treatmentQueryService.handle(getTreatmentByIdQuery);
        if(treatment.isEmpty()) return ResponseEntity.notFound().build();
        var treatmentResource = TreatmentResourceFromEntityAssembler.toResourceFromEntity(treatment.get());
        return ResponseEntity.ok(treatmentResource);
    }

    @PutMapping("/{treatmentId}")
    public ResponseEntity<TreatmentResource> updateTreatment(@PathVariable Long treatmentId, @RequestBody UpdateTreatmentResource updateTreatmentResource){
        var updateTreatmentCommand = UpdateTreatmentCommandFromResourceAssembler.toCommandFromResource(treatmentId, updateTreatmentResource);
        var updateTreatment = treatmentCommandService.handle(updateTreatmentCommand);
        if(updateTreatment.isEmpty()) return ResponseEntity.notFound().build();
        var treatmentResource = TreatmentResourceFromEntityAssembler.toResourceFromEntity(updateTreatment.get());
        return ResponseEntity.ok(treatmentResource);

    }

    @GetMapping("/medicalRecordId/{medicalRecordId}")
    public ResponseEntity<TreatmentResource> getTreatmentByMedicalRecordId(@PathVariable Long medicalRecordId) {
        var getTreatmentByMedicalRecordIdQuery = new GetTreatmentByMedicalRecordIdQuery(medicalRecordId);
        var treatment = treatmentQueryService.handle(getTreatmentByMedicalRecordIdQuery);
        if (treatment.isEmpty()) return ResponseEntity.notFound().build();
        var treatmentResource = TreatmentResourceFromEntityAssembler.toResourceFromEntity(treatment.get());
        return ResponseEntity.ok(treatmentResource);
    }

}
