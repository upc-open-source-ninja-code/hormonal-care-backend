package com.acme.hormonalcare.backend.medicalRecord.domain.model.entities;

import lombok.Getter;

@Getter
public class PhotoProfile{
    private String url;

    public PhotoProfile(String url) {

        this.url = url;
    }

}
