package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetExternalReportByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetExternalReportByMedicalRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.ExternalReportResource;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.ExternalReportCommandService;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.ExternalReportQueryService;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.*;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/medical-record/external-reports",produces = MediaType.APPLICATION_JSON_VALUE)
public class ExternalReportController {
    private final ExternalReportCommandService externalReportCommandService;
    private final ExternalReportQueryService externalReportQueryService;

    public ExternalReportController(ExternalReportCommandService externalReportCommandService, ExternalReportQueryService externalReportQueryService) {
        this.externalReportCommandService = externalReportCommandService;
        this.externalReportQueryService = externalReportQueryService;
    }

    @PostMapping
    public ResponseEntity<ExternalReportResource> CreateExternalReport(@RequestBody CreateExternalReportResource resource){
        var createExternalReportCommand = CreateExternalReportCommandFromResourceAssembler.toCommandFromResource(resource);
        var externalreport = externalReportCommandService.handle(createExternalReportCommand);
        if(externalreport.isEmpty()) return ResponseEntity.badRequest().build();
        var externalreportResource = ExternalReportFromEntityAssembler.toResourceFromEntity(externalreport.get());
        return new ResponseEntity<>(externalreportResource, HttpStatus.CREATED);
    }

    @GetMapping("/{externalReportId}")

    public ResponseEntity<ExternalReportResource> getExternalReportById(@PathVariable Long externalReportId){
        var getExternalReportByIdQuery = new GetExternalReportByIdQuery(externalReportId);
        var externalreport = externalReportQueryService.handle(getExternalReportByIdQuery);
        if(externalreport.isEmpty()) return ResponseEntity.notFound().build();
        var externalreportResource = ExternalReportFromEntityAssembler.toResourceFromEntity(externalreport.get());
        return ResponseEntity.ok(externalreportResource);
    }

    @PutMapping("/{externalReportId}")
    public ResponseEntity<ExternalReportResource> updateExternalReport(@PathVariable Long externalReportId, @RequestBody UpdateExternalReportResource updateExternalReportResource){
        var updateExternalReportCommand = UpdateExternalReportCommandFromResourceAssembler.toCommandFromResource(externalReportId, updateExternalReportResource);
        var updateExternalReport = externalReportCommandService.handle(updateExternalReportCommand);
        if(updateExternalReport.isEmpty()) return ResponseEntity.notFound().build();
        var externalreportResource = ExternalReportFromEntityAssembler.toResourceFromEntity(updateExternalReport.get());
        return ResponseEntity.ok(externalreportResource);

    }



    @GetMapping("/medicalRecordId/{medicalRecordId}")
    public ResponseEntity<List<ExternalReportResource>> getTreatmentByMedicalRecordId(@PathVariable Long medicalRecordId) {
        var getExternalReportByMedicalRecordIdQuery = new GetExternalReportByMedicalRecordIdQuery(medicalRecordId);
        var externalReports = externalReportQueryService.handle(getExternalReportByMedicalRecordIdQuery);
        if (externalReports.isEmpty()) return ResponseEntity.notFound().build();
        var externalReportResources = externalReports.stream()
                .map(ExternalReportFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(externalReportResources);
    }


}
