package org.home.apapacy.models;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties({"id", "revision"})
public class SofaModel {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("_rev")
    private String revision;

    private String color;

    public void setId(String s) {
        id = s;
    }

    public String getId() {
        return id;
    }

    public String getRevision() {
        return revision;
    }

    public void setColor(String s) {
        color = s;
    }

    public String getColor() {
        return color;
    }
}

