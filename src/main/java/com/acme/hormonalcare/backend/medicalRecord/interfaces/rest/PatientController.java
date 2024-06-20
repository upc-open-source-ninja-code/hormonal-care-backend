package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.PatientRecordId;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetPatientByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetPatientByPatientRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.PatientRecordId;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.PatientCommandService;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.PatientQueryService;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreatePatientResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.PatientResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdatePatientResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.CreatePatientCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.PatientResourceFromEntityAssembler;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.UpdatePatientCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value="/api/v1/medical-record/patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
    private final PatientCommandService patientCommandService;
    private final PatientQueryService patientQueryService;

    public PatientController(PatientCommandService patientCommandService, PatientQueryService patientQueryService) {
        this.patientCommandService = patientCommandService;
        this.patientQueryService = patientQueryService;
    }

    @PostMapping
    public ResponseEntity<PatientResource> createPatient(@RequestBody CreatePatientResource resource) {
        var createPatientCommand = CreatePatientCommandFromResourceAssembler.toCommandFromResource(resource);
        var optionalPatient = patientCommandService.handle(createPatientCommand);
        if (optionalPatient.isPresent()) {
            var patient = optionalPatient.get();
            if (patient.getPatientRecordId().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            var getPatientByPatientRecordIdQuery = new GetPatientByPatientRecordIdQuery(new PatientRecordId(patient.getPatientRecordId()));
            var patientQueryResult = patientQueryService.handle(getPatientByPatientRecordIdQuery);
            if (patientQueryResult.isEmpty()) return ResponseEntity.badRequest().build();
            var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patientQueryResult.get());
            return new ResponseEntity<>(patientResource, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }





    @GetMapping("/{patientRecordId}")
    public ResponseEntity<PatientResource> getPatientByPatientRecordId(@PathVariable String patientRecordId) {
        var PatientRecordId = new PatientRecordId(patientRecordId);
        var getPatientByPatientRecordIdQuery = new GetPatientByPatientRecordIdQuery(PatientRecordId);
        var patient = patientQueryService.handle(getPatientByPatientRecordIdQuery);
        if (patient.isEmpty()) {return ResponseEntity.notFound().build();}
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patient.get());
        return ResponseEntity.ok(patientResource);
    }


    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResource> getPatientById(@PathVariable Long patientId) {
        var getPatientByIdQuery = new GetPatientByIdQuery(patientId);
        var patient = patientQueryService.handle(getPatientByIdQuery);
        if (patient.isEmpty()) return ResponseEntity.notFound().build();
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(patient.get());
        return ResponseEntity.ok(patientResource);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientResource> updatePatient(@PathVariable Long patientId, @RequestBody UpdatePatientResource updatePatientResource) {
        var updatePatientCommand = UpdatePatientCommandFromResourceAssembler.toCommandFromResource(patientId, updatePatientResource);
        var updatedPatient = patientCommandService.handle(updatePatientCommand);
        if (updatedPatient.isEmpty()) return ResponseEntity.badRequest().build();
        var patientResource = PatientResourceFromEntityAssembler.toResourceFromEntity(updatedPatient.get());
        return ResponseEntity.ok(patientResource);
    }
}


