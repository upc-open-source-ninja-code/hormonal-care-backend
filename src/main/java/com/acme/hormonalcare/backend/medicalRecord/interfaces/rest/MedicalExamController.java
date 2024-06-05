package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetMedicalExamByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalExamCommandService;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.MedicalExamQueryService;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateMedicalExamResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.MedicalExamResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.CreateMedicalExamCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.MedicalExamResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/medical-record/medical-exam", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicalExamController {


    private final MedicalExamCommandService medicalExamCommandService;
    private final MedicalExamQueryService medicalExamQueryService;

    public MedicalExamController(MedicalExamCommandService medicalExamCommandService, MedicalExamQueryService medicalExamQueryService) {
        this.medicalExamCommandService = medicalExamCommandService;
        this.medicalExamQueryService = medicalExamQueryService;
    }

    @PostMapping
    public ResponseEntity<MedicalExamResource> createMedicalExam(@RequestBody CreateMedicalExamResource resource) {
        var createMedicalExamCommand = CreateMedicalExamCommandFromResourceAssembler.toCommandFromResource(resource);
        var medicalExam = medicalExamCommandService.handle(createMedicalExamCommand);
        if (medicalExam.isEmpty()) return ResponseEntity.badRequest().build();
        var medicalExamResource = MedicalExamResourceFromEntityAssembler.toResourceFromEntity(medicalExam.get());
        return new ResponseEntity<>(medicalExamResource, HttpStatus.CREATED);
    }

    @GetMapping("/{medicalExamId}")
    public ResponseEntity<MedicalExamResource> getMedicalExamById(@PathVariable Long medicalExamId) {
        var getMedicalExamByIdQuery = new GetMedicalExamByIdQuery(medicalExamId);
        var medicalExam = medicalExamQueryService.handle(getMedicalExamByIdQuery);
        if (medicalExam.isEmpty()) return ResponseEntity.notFound().build();
        var medicalExamResource = MedicalExamResourceFromEntityAssembler.toResourceFromEntity(medicalExam.get());
        return ResponseEntity.ok(medicalExamResource);
    }
}
