package com.acme.hormonalcare.backend.profile.interfaces.rest;

import com.acme.hormonalcare.backend.profile.domain.model.commands.UpdateProfileImageCommand;
import com.acme.hormonalcare.backend.profile.domain.model.queries.GetProfileByIdQuery;
import com.acme.hormonalcare.backend.profile.domain.services.ProfileCommandService;
import com.acme.hormonalcare.backend.profile.domain.services.ProfileQueryService;
import com.acme.hormonalcare.backend.profile.interfaces.rest.resources.CreateProfileResource;
import com.acme.hormonalcare.backend.profile.interfaces.rest.resources.ProfileResource;
import com.acme.hormonalcare.backend.profile.interfaces.rest.resources.UpdateProfileImageResource;
import com.acme.hormonalcare.backend.profile.interfaces.rest.resources.UpdateProfilePhoneNumberResource;
import com.acme.hormonalcare.backend.profile.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.profile.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import com.acme.hormonalcare.backend.profile.interfaces.rest.transform.UpdateProfileImageCommandFromResourceAssembler;
import com.acme.hormonalcare.backend.profile.interfaces.rest.transform.UpdateProfilePhoneNumberCommandFromResourceAssembler;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/profile/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfileController(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }
    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resource){
        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profile = profileCommandService.handle(createProfileCommand);
        if(profile.isEmpty()) return ResponseEntity.badRequest().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId){
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if(profile.isEmpty()) return ResponseEntity.notFound().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    @PutMapping("/{profileId}/image")
    public ResponseEntity<ProfileResource> updateProfileImage(@PathVariable Long profileId, @RequestBody UpdateProfileImageResource updateProfileImageResource){
        var updateProfileImageCommand = UpdateProfileImageCommandFromResourceAssembler.toCommandFromResource(profileId, updateProfileImageResource);
        var updateProfileImage = profileCommandService.handle(updateProfileImageCommand);
        if(updateProfileImage.isEmpty()) return ResponseEntity.notFound().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(updateProfileImage.get());
        return ResponseEntity.ok(profileResource);
    }

    @PutMapping("/{profileId}/phoneNumber")
    public ResponseEntity<ProfileResource> updateProfilePhoneNumber(@PathVariable Long profileId, @RequestBody UpdateProfilePhoneNumberResource updateProfilePhoneNumberResource){
        var updateProfilePhoneNumberCommand = UpdateProfilePhoneNumberCommandFromResourceAssembler.toCommandFromResource(profileId, updateProfilePhoneNumberResource);
        var updateProfilePhoneNumber = profileCommandService.handle(updateProfilePhoneNumberCommand);
        if(updateProfilePhoneNumber.isEmpty()) return ResponseEntity.notFound().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(updateProfilePhoneNumber.get());
        return ResponseEntity.ok(profileResource);

    }


}

