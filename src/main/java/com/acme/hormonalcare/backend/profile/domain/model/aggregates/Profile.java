package com.acme.hormonalcare.backend.profile.domain.model.aggregates;

import com.acme.hormonalcare.backend.profile.domain.model.commands.CreateProfileCommand;
import com.acme.hormonalcare.backend.profile.domain.model.valueobjects.*;
import com.acme.hormonalcare.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    @Column()
    private PersonName name;

    @Embedded
    private Age age;

    @Embedded
    private Gender gender;


    private String phoneNumber;

    @Embedded
    private Email email;

    @Embedded
    private Birthday birthday;


    private String Image;

    public Profile(PersonName name, Age age, Gender gender, String phoneNumber, Email email, Birthday birthday, String Image) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;
        this.Image = Image;
    }

    public Profile(){
    }

    public Profile(CreateProfileCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.age = new Age(command.age());
        this.birthday = new Birthday(command.birthday());
        this.gender = new Gender(command.gender());
        this.phoneNumber = command.phoneNumber();
        this.email = new Email(command.email());
        this.Image = command.Image();
    }

    public Profile upsetPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Profile upsetImage(String Image){
        this.Image = Image;
        return this;
    }

}
