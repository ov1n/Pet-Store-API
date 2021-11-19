package com.example.petstore;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(name = "PetsType")
public class PetsType {

    @Schema(required = true, description = "Pet Type id")
    @JsonProperty("petsTypeId")
    private Integer petsTypeId;

    @Schema(required = true, description = "Pet type name")
    @JsonProperty("typeName")
    private String typeName;

    public Integer getPetsTypeId() {
        return petsTypeId;
    }

    public void setPetTypeId(Integer pettypeId) {
        this.petsTypeId = pettypeId;
    }

    public String getPetType() {
        return typeName;
    }

    public void setPetType(String petType) {
        this.typeName = petType;
    }
}
