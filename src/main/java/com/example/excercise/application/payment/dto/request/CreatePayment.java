package com.example.excercise.application.payment.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatePayment {

    @Size(min = 1)
    @JsonProperty("type")
    private String type;

    @Size(min = 1)
    @JsonProperty("id")
    private String id;

    @Min(0)
    @JsonProperty("version")
    private Integer version;

    @Size(min = 1)
    @JsonProperty("organisation_id")
    private String organisationId;

    @NotNull
    @JsonProperty("attributes")
    private Attributes attributes;

    @Size(min = 1)
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("organisation_id")
    public String getOrganisationId() {
        return organisationId;
    }

    @JsonProperty("organisation_id")
    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    @JsonProperty("attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}