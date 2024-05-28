package com.acme.hormonalcare.backend.profiles.infrastructure.persistence.jpa.repositories;

import com.acme.hormonalcare.backend.profiles.domain.model.aggregates.Profile;
import com.acme.hormonalcare.backend.profiles.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(EmailAddress email);
    boolean existsByEmail(EmailAddress email);
}
