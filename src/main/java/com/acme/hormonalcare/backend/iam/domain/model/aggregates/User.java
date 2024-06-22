package com.acme.hormonalcare.backend.iam.domain.model.aggregates;

import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Entity
public class User extends AuditableAbstractAggregateRoot<User>{

    @Getter
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String username;

    @Getter
    @NotBlank
    @Size(max = 120)
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User updateUsername(String username) {
        this.username = username;
        return this;
    }

    public User updatePassword(String password) {
        this.password = password;
        return this;
    }
}
