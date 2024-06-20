package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;

import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDoctorSubscriptionCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.commands.UpdateDoctorAppointmentFeeCommand;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDoctorByDoctorRecordIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetDoctorByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.valueobjects.DoctorRecordId;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DoctorCommandService;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.DoctorQueryService;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateDoctorResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.DoctorResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.CreateDoctorCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.DoctorResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/doctor/doctor", produces = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController {
    private final DoctorCommandService doctorCommandService;
    private final DoctorQueryService doctorQueryService;

    public DoctorController(DoctorCommandService doctorCommandService, DoctorQueryService doctorQueryService) {
        this.doctorCommandService = doctorCommandService;
        this.doctorQueryService = doctorQueryService;
    }

    @PostMapping
    public ResponseEntity<DoctorResource> createDoctor(@RequestBody CreateDoctorResource resource){
        var createDoctorCommand = CreateDoctorCommandFromResourceAssembler.toCommandFromResource(resource);
        var optionalDoctor = doctorCommandService.handle(createDoctorCommand);
        if (optionalDoctor.isPresent()) {
            var doctor = optionalDoctor.get();
            if (doctor.getDoctorRecordId().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            var getDoctorByDoctorRecordIdQuery = new GetDoctorByDoctorRecordIdQuery(new DoctorRecordId(doctor.getDoctorRecordId()));
            var doctorQueryResult = doctorQueryService.handle(getDoctorByDoctorRecordIdQuery);
            if (doctorQueryResult.isEmpty()) return ResponseEntity.badRequest().build();
            var doctorResource = DoctorResourceFromEntityAssembler.toResourceFromEntity(doctorQueryResult.get());
            return new ResponseEntity<>(doctorResource, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorResource> getDoctorById(@PathVariable Long doctorId){
        var getDoctorByIdQuery = new GetDoctorByIdQuery(doctorId);
        var doctor = doctorQueryService.handle(getDoctorByIdQuery);
        if(doctor.isEmpty()) return ResponseEntity.notFound().build();
        var doctorResource = DoctorResourceFromEntityAssembler.toResourceFromEntity(doctor.get());
        return ResponseEntity.ok(doctorResource);
    }

    @PutMapping("/{doctorId}/subscription")
    public ResponseEntity<DoctorResource> updateDoctorSubscription(@PathVariable Long doctorId, @RequestBody Long subscription){
        var updateDoctorSubscriptionCommand = new UpdateDoctorSubscriptionCommand(doctorId, subscription);
        var updatedDoctor = doctorCommandService.handle(updateDoctorSubscriptionCommand);
        if(updatedDoctor.isEmpty()) return ResponseEntity.notFound().build();
        var doctorResource = DoctorResourceFromEntityAssembler.toResourceFromEntity(updatedDoctor.get());
        return ResponseEntity.ok(doctorResource);
    }

    @PutMapping("/{doctorId}/appointmentFee")
    public ResponseEntity<DoctorResource> updateDoctorAppointmentFee(@PathVariable Long doctorId, @RequestBody Long appointmentFee){
        var updateDoctorAppointmentFeeCommand = new UpdateDoctorAppointmentFeeCommand(doctorId, appointmentFee);
        var updatedDoctor = doctorCommandService.handle(updateDoctorAppointmentFeeCommand);
        if(updatedDoctor.isEmpty()) return ResponseEntity.notFound().build();
        var doctorResource = DoctorResourceFromEntityAssembler.toResourceFromEntity(updatedDoctor.get());
        return ResponseEntity.ok(doctorResource);
    }
}