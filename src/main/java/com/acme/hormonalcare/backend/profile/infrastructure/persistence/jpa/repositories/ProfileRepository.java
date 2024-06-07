package com.acme.hormonalcare.backend.profile.infrastructure.persistence.jpa.repositories;

import com.acme.hormonalcare.backend.profile.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profile.domain.model.valueobjects.Email;
import com.acme.hormonalcare.backend.profile.domain.model.valueobjects.PersonName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByName(PersonName name);

    Optional<Profile> findByEmail(Email email);
}
