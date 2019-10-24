package com.netcracker.tc.server.persistence.model.resume;

import java.io.Serializable;

/**
 * Created by unconsionable on 28.07.2014.
 */
public class ResumeStatus implements Serializable {

    private Long id;
    private String description;

    public ResumeStatus(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public ResumeStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}