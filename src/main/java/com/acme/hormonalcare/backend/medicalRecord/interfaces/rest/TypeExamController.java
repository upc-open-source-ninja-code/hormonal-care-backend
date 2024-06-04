package com.acme.hormonalcare.backend.medicalRecord.interfaces.rest;
import com.acme.hormonalcare.backend.medicalRecord.domain.model.queries.GetTypeExamByIdQuery;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.TypeExamCommandService;
import com.acme.hormonalcare.backend.medicalRecord.domain.services.TypeExamQueryService;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.CreateTypeExamResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.resources.TypeExamResource;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.CreateTypeExamCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.medicalRecord.interfaces.rest.transform.TypeExamResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/medical-record/medical-exam/type-exam", produces = MediaType.APPLICATION_JSON_VALUE)
public class TypeExamController {
    private final TypeExamCommandService typeExamCommandService;
    private final TypeExamQueryService typeExamQueryService;

    public TypeExamController(TypeExamCommandService typeExamCommandService, TypeExamQueryService typeExamQueryService) {
        this.typeExamCommandService = typeExamCommandService;
        this.typeExamQueryService = typeExamQueryService;
    }

    @PostMapping
    public ResponseEntity<TypeExamResource> createTypeExam(@RequestBody CreateTypeExamResource resource) {
        var createTypeExamCommand = CreateTypeExamCommandFromResourceAssembler.toCommandFromResource(resource);
        var typeExam = typeExamCommandService.handle(createTypeExamCommand);
        if (typeExam.isEmpty()) return ResponseEntity.badRequest().build();
        var typeExamResource = TypeExamResourceFromEntityAssembler.toResourceFromEntity(typeExam.get());
        return new ResponseEntity<>(typeExamResource, HttpStatus.CREATED);
    }

    @GetMapping("/{typeExamId}")
    public ResponseEntity<TypeExamResource> getTypeExamById(@PathVariable Long typeExamId) {
        var getTypeExamByIdQuery = new GetTypeExamByIdQuery(typeExamId);
        var typeExam = typeExamQueryService.handle(getTypeExamByIdQuery);
        if (typeExam.isEmpty()) return ResponseEntity.notFound().build();
        var typeExamResource = TypeExamResourceFromEntityAssembler.toResourceFromEntity(typeExam.get());
        return ResponseEntity.ok(typeExamResource);
    }
}


