package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;


import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.DeleteDiagnoseCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetAllDiagnosesQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDiagnoseByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DiagnoseCommandService;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DiagnoseQueryService;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateDiagnoseResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.DiagnoseResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.CreateDiagnoseCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.DiagnoseResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/v1/diagnoses", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Diagnoses", description = "Diagnose Management Endpoints")
public class DiagnoseController {
    private final DiagnoseCommandService diagnoseCommandService;
    private final DiagnoseQueryService diagnoseQueryService;

    public DiagnoseController(DiagnoseCommandService diagnoseCommandService, DiagnoseQueryService diagnoseQueryService) {
        this.diagnoseCommandService = diagnoseCommandService;
        this.diagnoseQueryService = diagnoseQueryService;
    }
    @PostMapping
    public ResponseEntity<DiagnoseResource> createDiagnose(@RequestBody CreateDiagnoseResource createDiagnoseResource) {
        var createDiagnoseCommand = CreateDiagnoseCommandFromResourceAssembler.toCommandFromResource(createDiagnoseResource);
        var diagnoseId = diagnoseCommandService.handle(createDiagnoseCommand);
        if (diagnoseId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getDiagnoseByIdQuery = new GetDiagnoseByIdQuery(diagnoseId);
        var diagnose = diagnoseQueryService.handle(getDiagnoseByIdQuery);
        var diagnoseResource = DiagnoseResourceFromEntityAssembler.toResourceFromEntity(diagnose.get());
        return new ResponseEntity<>(diagnoseResource, HttpStatus.CREATED);
    }

    @GetMapping("/{diagnoseId}")
    public ResponseEntity<DiagnoseResource> getDiagnose(@PathVariable Long diagnoseId) {
        var getDiagnoseByIdQuery = new GetDiagnoseByIdQuery(diagnoseId);
        var diagnose = diagnoseQueryService.handle(getDiagnoseByIdQuery);
        if (diagnose.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var diagnoseResource = DiagnoseResourceFromEntityAssembler.toResourceFromEntity(diagnose.get());
        return new ResponseEntity<>(diagnoseResource, HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<DiagnoseResource>> getAllDiagnoses() {
        var getAllDiagnosesQuery = new GetAllDiagnosesQuery();
        var diagnoses = diagnoseQueryService.handle(getAllDiagnosesQuery);
        var diagnoseResources = diagnoses.stream().map(DiagnoseResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(diagnoseResources);
    }
    @DeleteMapping("/{diagnoseId}")
    public ResponseEntity<Void> deleteDiagnose(@PathVariable Long diagnoseId) {
        var deleteDiagnoseCommand = new DeleteDiagnoseCommand(diagnoseId);
        diagnoseCommandService.handle(deleteDiagnoseCommand);
        return ResponseEntity.noContent().build();
    }
}




