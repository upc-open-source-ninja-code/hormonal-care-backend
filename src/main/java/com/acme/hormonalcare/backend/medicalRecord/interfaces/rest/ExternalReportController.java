package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetExternalReportByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetExternalReportByMedicalRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTreatmentByMedicalRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.ExternalReportCommandService;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.ExternalReportQueryService;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.*;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ExternalReportResouce> CreateExternalReport(@RequestBody CreateExternalReportResource resource){
        var createExternalReportCommand = CreateExternalReportCommandFromResourceAssembler.toCommandFromResource(resource);
        var externalreport = externalReportCommandService.handle(createExternalReportCommand);
        if(externalreport.isEmpty()) return ResponseEntity.badRequest().build();
        var externalreportResource = ExternalReportFromEntityAssembler.toResourceFromEntity(externalreport.get());
        return new ResponseEntity<>(externalreportResource, HttpStatus.CREATED);
    }

    @GetMapping("/{externalReportId}")

    public ResponseEntity<ExternalReportResouce> getExternalReportById(@PathVariable Long externalReportId){
        var getExternalReportByIdQuery = new GetExternalReportByIdQuery(externalReportId);
        var externalreport = externalReportQueryService.handle(getExternalReportByIdQuery);
        if(externalreport.isEmpty()) return ResponseEntity.notFound().build();
        var externalreportResource = ExternalReportFromEntityAssembler.toResourceFromEntity(externalreport.get());
        return ResponseEntity.ok(externalreportResource);
    }

    @PutMapping("/{externalReportId}")
    public ResponseEntity<ExternalReportResouce> updateExternalReport(@PathVariable Long externalReportId, @RequestBody UpdateExternalReportResource updateExternalReportResource){
        var updateExternalReportCommand = UpdateExternalReportCommandFromResourceAssembler.toCommandFromResource(externalReportId, updateExternalReportResource);
        var updateExternalReport = externalReportCommandService.handle(updateExternalReportCommand);
        if(updateExternalReport.isEmpty()) return ResponseEntity.notFound().build();
        var externalreportResource = ExternalReportFromEntityAssembler.toResourceFromEntity(updateExternalReport.get());
        return ResponseEntity.ok(externalreportResource);

    }

    @GetMapping("/medicalRecordId/{medicalRecordId}")
    public ResponseEntity<ExternalReportResouce> getTreatmentByMedicalRecordId(@PathVariable Long medicalRecordId) {
        var getExternalReportByIdQuery = new GetExternalReportByMedicalRecordIdQuery(medicalRecordId);
        var externalreport = externalReportQueryService.handle(getExternalReportByIdQuery);
        if (externalreport.isEmpty()) return ResponseEntity.notFound().build();
        var externalreportResource = ExternalReportFromEntityAssembler.toResourceFromEntity(externalreport.get());
        return ResponseEntity.ok(externalreportResource);
    }

}
