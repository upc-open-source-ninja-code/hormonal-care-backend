package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.aggregates.Diagnose;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDiagnoseByMedicalRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetExternalReportByMedicalRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.DiagnoseResourceFromEntityAssembler;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDiagnoseByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DiagnoseCommandService;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DiagnoseQueryService;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.*;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.*;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.DiagnoseResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateDiagnoseResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/medical-record/diagnoses",produces = MediaType.APPLICATION_JSON_VALUE)
public class DiagnoseController {
    private final DiagnoseCommandService diagnoseCommandService;
    private final DiagnoseQueryService diagnoseQueryService;

    public DiagnoseController(DiagnoseCommandService diagnoseCommandService, DiagnoseQueryService diagnoseQueryService) {
        this.diagnoseCommandService = diagnoseCommandService;
        this.diagnoseQueryService = diagnoseQueryService;
    }

    @PostMapping
    public ResponseEntity<DiagnoseResource> createDiagnose(@RequestBody CreateDiagnoseResource resource){
        var createDiagnoseCommand = CreateDiagnoseCommandFromResourceAssembler.toCommandFromResource(resource);
        var diagnose = diagnoseCommandService.handle(createDiagnoseCommand);
        if(diagnose.isEmpty()) return ResponseEntity.badRequest().build();
        var diagnoseResource = DiagnoseResourceFromEntityAssembler.toResourceFromEntity(diagnose.get());
        return new ResponseEntity<>(diagnoseResource, HttpStatus.CREATED);
    }

    @GetMapping("/{diagnoseId}")
    public ResponseEntity<DiagnoseResource> getDiagnoseById(@PathVariable Long diagnoseId){
        var getDiagnoseByIdQuery = new GetDiagnoseByIdQuery(diagnoseId);
        var diagnose = diagnoseQueryService.handle(getDiagnoseByIdQuery);
        if(diagnose.isEmpty()) return ResponseEntity.notFound().build();
        var diagnoseResource = DiagnoseResourceFromEntityAssembler.toResourceFromEntity(diagnose.get());
        return ResponseEntity.ok(diagnoseResource);
    }

    @PutMapping("/{diagnoseId}")
    public ResponseEntity<DiagnoseResource> updateDiagnose(@PathVariable Long diagnoseId, @RequestBody UpdateDiagnoseResource updateDiagnoseResource){
        var updateDiagnoseCommand = UpdateDiagnoseCommandFromResourceAssembler.toCommandFromResource(diagnoseId, updateDiagnoseResource);
        var updateDiagnose = diagnoseCommandService.handle(updateDiagnoseCommand);
        if(updateDiagnose.isEmpty()) return ResponseEntity.notFound().build();
        var diagnoseResource = DiagnoseResourceFromEntityAssembler.toResourceFromEntity(updateDiagnose.get());
        return ResponseEntity.ok(diagnoseResource);

    }

    @GetMapping("/medicalRecordId/{medicalRecordId}")
    public ResponseEntity<List<DiagnoseResource>> getDiagnoseByMedicalRecordId(@PathVariable Long medicalRecordId) {
        var getDiagnoseByMedicalRecordIdQuery = new GetDiagnoseByMedicalRecordIdQuery(medicalRecordId);
        var diagnoses = diagnoseQueryService.handle(getDiagnoseByMedicalRecordIdQuery);
        if (diagnoses.isEmpty()) return ResponseEntity.notFound().build();
        var diagnoseResources = diagnoses.stream()
                .map(DiagnoseResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(diagnoseResources);
    }

}