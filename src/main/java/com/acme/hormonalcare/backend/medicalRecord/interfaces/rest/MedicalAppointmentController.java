package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.DeleteMedicalAppointmentCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalAppointmentByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalAppointmentCommandService;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalAppointmentQueryService;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateMedicalAppointmentResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.MedicalAppointmentResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.UpdateMedicalAppointmentResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.CreateMedicalAppointmentCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.MedicalAppointmentResourceFromEntityAssembler;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.UpdateMedicalAppointmentCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/medicalAppointment", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicalAppointmentController {
    private final MedicalAppointmentCommandService medicalAppointmentCommandService;
    private final MedicalAppointmentQueryService medicalAppointmentQueryService;

    public MedicalAppointmentController(MedicalAppointmentCommandService medicalAppointmentCommandService, MedicalAppointmentQueryService medicalAppointmentQueryService) {
        this.medicalAppointmentCommandService = medicalAppointmentCommandService;
        this.medicalAppointmentQueryService = medicalAppointmentQueryService;
    }

    @PostMapping
    public ResponseEntity<MedicalAppointmentResource> createMedicalAppointment(@RequestBody CreateMedicalAppointmentResource resource){
        var createMedicalAppointmentCommand = CreateMedicalAppointmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var medicalAppointment = medicalAppointmentCommandService.handle(createMedicalAppointmentCommand);
        if(medicalAppointment.isEmpty()) return ResponseEntity.badRequest().build();
        var medicalAppointmentResource = MedicalAppointmentResourceFromEntityAssembler.toResourceFromEntity(medicalAppointment.get());
        return new ResponseEntity<>(medicalAppointmentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{medicalAppointmentId}")
    public ResponseEntity<MedicalAppointmentResource> getMedicalAppointmentById(@PathVariable Long medicalAppointmentId){
        var getMedicalAppointmentByIdQuery = new GetMedicalAppointmentByIdQuery(medicalAppointmentId);
        var medicalAppointment = medicalAppointmentQueryService.handle(getMedicalAppointmentByIdQuery);
        if(medicalAppointment.isEmpty()) return ResponseEntity.notFound().build();
        var medicalAppointmentResource = MedicalAppointmentResourceFromEntityAssembler.toResourceFromEntity(medicalAppointment.get());
        return ResponseEntity.ok(medicalAppointmentResource);
    }
    @PutMapping("/{medicalAppointmentId}")
    public ResponseEntity<MedicalAppointmentResource> updateMedicalAppointment(@PathVariable Long medicalAppointmentId, @RequestBody UpdateMedicalAppointmentResource resource){
        var updateMedicalAppointmentCommand = UpdateMedicalAppointmentCommandFromResourceAssembler.toCommandFromResource(medicalAppointmentId, resource);
        var updatedMedicalAppointment = medicalAppointmentCommandService.handle(updateMedicalAppointmentCommand);
        if(updatedMedicalAppointment.isEmpty()) return ResponseEntity.notFound().build();
        var updatedMedicalAppointmentResource = MedicalAppointmentResourceFromEntityAssembler.toResourceFromEntity(updatedMedicalAppointment.get());
        return ResponseEntity.ok(updatedMedicalAppointmentResource);
    }

    @DeleteMapping("/{medicalAppointmentId}")
    public ResponseEntity<Void> deleteMedicalAppointment(@PathVariable Long medicalAppointmentId){
        var deleteMedicalAppointmentCommand = new DeleteMedicalAppointmentCommand(medicalAppointmentId);
        medicalAppointmentCommandService.handle(deleteMedicalAppointmentCommand);
        return ResponseEntity.noContent().build();
    }
}